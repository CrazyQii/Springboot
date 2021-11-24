## Kafka消息丢失与精确消费一次性

### 消息丢失的场景

Kafka Producer 使用发送即忘的方式发送消息，调用`producer.send()`方法来发送消息，发送消息后会立即返回，但是并不能保证消息发送成功

如果在发送过程中发生了网络抖动，消息就会丢失；如果消息本身不符合要求，如超过`broker`的承载能力（消息太大，可以采用分包的形式）

解决问题方法：使用 `Producer` 的有回调的方法通知消息，即 `Producer.send(msg, callback)` ，回调方法会告诉我们消息是否发送成功

#### 消费者丢失数据

Consumer端丢失消息主要体现在：拉取了消息，并提交了位移，但是在处理消息的时候出现了宕机等故障，消费者重生后，会从前面已经提交过的下一个位置继续消费，之前未处理完成的消息不会再次处理，即相当于消费者丢失了消息

解决方法：将提交位移的时间修改为处理消息完成后，确认消息处理完成后再提交响应的位移。这样即使处理消息的过程中发生了异常，由于没有提交位移，下一次的消费还是会从之前的位移处继续消费。

Consumer消费消息时，关闭自动提交位移，由应用程序手动提交位移

#### Broker端丢失数据

Broker丢失消息主要体现在：

1. 原来的Broker宕机了，但是选举出一个落后太多 `Leader` 的 `broker` 作为 `Leader`，那么这些落后的消息都会丢失，可以禁止这些 `unclean` 的 `broker` 竞选成为 `Leader`
2. Kafka使用页缓存机制，将消息写入页缓存而非持久化到磁盘，将刷盘的工作交由操作系统来做，以此来保证高效率和高吞吐。但是如果有一部分的分页消息还在分页缓存中，未持久化到磁盘中，此时Broker宕机，重启后这部分的消息会丢失，可以采用多副本机制避免这些消息丢失

### 避免消息丢失实践

1. 不使用 `producer.send(msg)` ，而使用 `producer.send(msg, callback)`
2. 设置 `acks = all` , acks参数是 `Producer` 的一个参数，代表对已经提交消息的定义，如果设置成all，表示所有 Broker 副本都要接收到消息才算 “已提交”，是最高等级的 “已提交” 标准 
3. 设置 `retries`为一个较大的值，`retries` 表示Producer发送消息后失败的重试次数，如果发生了网络抖动，可以通过重试机制重新发送消息，避免消息丢失
4. 设置 `unclean.leader.election.enable = false`  这是Broker端的参数，表示哪些 Broker 可以精选成为 Leader，如果某一个分区落后太多的 `Broker `成为 `Leader` ，必然会导致消息的丢失，那么就需要设置值为 false， 避免这样的状况发生
5. 设置 `replication.factor >= 3`，Broker端参数，每个分区的副本数大于等于3，这是冗余避免数据丢失
6. 设置 `min.insync.replicas >1`，Broker端参数，控制消息被写入多少个副本才表示“已提交”
7. 确保 `replication.factor > min.insync.replicas` ，若两者相等，则如果有一个副本挂了，整个分区就无法正常工作了。推荐设置为：`replication.factor = min.insync.replicas + 1`；
8. `enable.auto.commit = false`，Consumer端参数，关闭位移自动提交，使用手动提交的形式

### 精确一次消费

Kafka默认提供的消息可靠机制是“至少一次”，即消息不会丢失。若`Producer`消息没有发送成功，那么会再次重发，若 Broker 端的应答未成功发送给 Producer （如网络抖动），Producer也会进行重试，再次发送消息，那么这样就会导致消息的重复发送

Kafka通过两种机制确保消息的精确一次消费

1. 幂等性(idempotence)
2. 事务(transaction)

#### 幂等性

**对接口的多次调用和对接口的一次调用产生的结果是一致的**，Kafka0.11.0.0版本引入此特性，设置参数 `enable.idempotence = true`即可指定Producer的幂等算法。开启幂等算法后，Producer会自动进行去重发送处理，实现发送者的幂等性，Kafka引入了`Producer id`（PID）和序列号（sequence number）

生产者（`producer`）被创建时会生成一个PID（对外透明），每一个PID发送到每一个分区都有对应的序列号，这些序列号从0开始单调递增

Broker端会对每一对<PID, 分区>维护一个序列号`SN_old`，针对生产者发送过来的消息，对其序列号 `SN_new` 进行判断，并做相应处理

当 `SN_new` = `SN_old` + 1 时，broker才会接收消息

当 `SN_new` > `SN_old` + 1 时，说明有数据没有写入，出现了消息乱序的状况，对应的消费者会抛出 `OutOfOrderSequenceException`

当 `SN_new` < `SN_old` + 1 时，说明数据重复发送，broker直接丢弃该消息

**注意：序列号针对<PID, 分区>，这意味着幂等生产者只能保证单个主题的单一分区内消息不重复；其次，它只能实现单会话上的幂等性，不能实现跨会话的幂等性，这里的会话即可以理解为：Producer进程的一次运行。当重启了Producer进程之后，则幂等性保证就失效了。**

#### 事务

幂等性不能跨分区运作，但是 Kafka 的事物可以弥补这个缺陷，批量的信息要么全部写入，要么全部失败，并且在 `Producer` 重启后依然能够保证消息的精确一次处理

##### Producer 事务实践

1. enable.idempotence = true

2. 设置Producer端参数transcational.id。最好为其设置一个有意义的名字。

3. 调用事务API

```java
producer.initTransactions();
try {
	producer.beginTransaction();
 	producer.send(record1);
    producer.send(record2);
	producer.commitTransaction();
} catch (KafkaExecption e) {
	producer.abortTransaction();
}
```

实际上，即使写入失败，Kafka也会将它们写入到底层的日志中，也就是说Consumer还是会看到这些消息，具体Consumer端读取事务型Producer发送的消息需要另行配置。

##### Consumer事务实践

读取事务型 Producer 发送的消息时，Consumer 端的 `isolation.level` 参数表征着事务的隔离级别，即决定了 Consumer 以怎样的级别去读取消息。该参数有以下两个取值： 

read_uncommitted：默认值，表面 Consumer 能够读到Kafka写入的任何消息，不论事务型 Producer 是否正常提交了事务。显然，如果启用了事务型的 Producer，则 Consumer 端参数就不要使用该值，否则事务是无效的。 

read_committed：表面 Consumer 只会读取事务型 Producer 成功提交的事务中写入的消息，同时，非事务型Producer写入的所有消息对 Consumer 也是可见的。

### 精确一次消费总结

Kafka所提供的消息精确一次消费的手段有两个：幂等性Producer和事务型Producer。 幂等性Producer只能保证单会话、单分区上的消息幂等性； 事务型Producer可以保证跨分区、跨会话间的幂等性； 事务型Producer功能更为强大，但是同时，其效率也会比较低下。