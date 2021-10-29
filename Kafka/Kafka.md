## Kafka

### 1. 下载 Java

### 2. 安装 ZoomKeeper 框架

#### 2.1 下载 ZoomKeeper

下载最新版本 [官网链接](http://zookeeper.apache.org/releases.html)

#### 2.2 提取解压 tar 文件

```shell
$ cd opt/
$ tar -zvxf zookeeper-3.4.6.tar.gz
$ cd zookeeper-3.4.6
$ mkdir data
```

#### 2.3 创建配置文件

打开 `conf/zoo.cfg `配置文件，将下列参数设置为起点（`zoosample.cfg` 文件可作为参考）

```cfg
$ vi conf/zoo.cfg
tickTime=2000
dataDir=/path/to/zookeeper/data
clientPort=2181
initLimit=5
syncLimit=2
```

配置成功返回终端，并重新启动 zoomkeeper 服务器

#### 2.4 启动 Zoomkeeper 服务器

确认配置好 `JAVA_HOME`

```shell
$ bin/zkServer.sh start
```

返回结果

```shell
$ JMX enabled by default
$ Using config: /Users/../zookeeper-3.4.6/bin/../conf/zoo.cfg
$ Starting zookeeper ... STARTED
```

#### 2.5 启动CLI

```shell
$ bin/zkCli.sh
```

响应结果

```shell
Connecting to localhost:2181
................
................
................
Welcome to ZooKeeper!
................
................
WATCHER::
WatchedEvent state:SyncConnected type: None path:null
[zk: localhost:2181(CONNECTED) 0]
```

#### 2.6 停止 Zoomkeeper 服务器

```shell
$ bin/zkServer.sh stop
```

### 3. 安装Kafka

#### 3.1 下载Kafka

[最新版](https://www.apache.org/dyn/closer.cgi?path=/kafka/0.9.0.0/kafka_2.11-0.9.0.0.tgz)

#### 3.2 解压文件

#### 3.3 启动服务器

```shell
$ bin/kafka-server-start.sh config/server.properties
```

响应结果

```she
$ bin/kafka-server-start.sh config/server.properties
[2016-01-02 15:37:30,410] INFO KafkaConfig values:
request.timeout.ms = 30000
log.roll.hours = 168
inter.broker.protocol.version = 0.9.0.X
log.preallocate = false
security.inter.broker.protocol = PLAINTEXT
…………………………………………….
…………………………………………….
```

#### 3.4 停止服务器

```shell
$ bin/kafka-server-stop.sh config/server.properties
```

### 4. Kafka基本操作

前提：安装好 `zookeeper`  和 `Kafka` 以及 `Java`

#### 4.1 启动 Zookeeper 和 Kafaka

```shell
# 启动 zookeeper
bin/zookeeper-server-start.sh config/zookeeper.properties

# 启动 Kafka
bin/kafka-server-start.sh config/server.properties
```

输入  `JPS`

```shell
# 返回守护进程
821 QuorumPeerMain  # zookeeper 守护进程
928 Kafka # Kafka 守护进程
931 Jps
```



#### 4.2 单节点

配置步骤：

1. 创建 Kafka主题（kafka-topics.sh）

语法

```shell
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 
--partitions 1 --topic topic-name
```

示例

```shell
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1   
--partitions 1 --topic Hello-Kafka
```

> 以上命令创建了一个名为 `Hello-Kafka` 的主题，其中包含一个分区和一个副本因子。

2. 查询主题列表

语法

```shell
bin/kafka-topics.sh --list --zookeeper localhost:2181
```

3. 启动生产者发送消息

语法

```shell
bin/kafka-console-producer.sh --broker-list localhost:9092 --topic topic-name
```

语法说明：

- **broker-list 代理列表** - 我们要发送邮件的代理列表。 在这种情况下，我们只有一个代理。 `Config / server.properties` 文件包含代理端口 ID，因为我们知道我们的代理正在侦听端口 9092，因此您可以直接指定它。
- **topic主题名称** - 主题名称的示例。

示例

```shell
bin/kafka-console-producer.sh --broker-list localhost:9092 --topic Hello-Kafka
```

3. 启动消费者消费消息

语法

```shell
bin/kafka-console-consumer.sh --zookeeper localhost:2181 —topic topic-name 
--from-beginning
```

示例

```shell
bin/kafka-console-consumer.sh --zookeeper localhost:2181 —topic Hello-Kafka 
--from-beginning
```

### 5. Java 部署 Kafka

#### 5.1 创建普通 Maven 工程

#### 5.2 添加 Kafka 依赖

```xml
<dependencies>
    <dependency>
        <groupId>org.apache.kafka</groupId>
        <artifactId>kafka_2.12</artifactId>
        <version>2.2.0</version>
        </dependency>
</dependencies>
```

