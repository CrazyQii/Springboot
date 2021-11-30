## 0.8.2.0 版本Kafka Java实现
 - 使用 Docker 安装 Kafka
 - Java程序消费者、生产者功能基本实现

### 特点
1. 消费者手动提交位移
2. 异常简单处理

[Kafka常见问题处理](https://www.crazyqiqi.top/2021/11/26/Kafka-%E4%B8%89-%E5%B8%B8%E8%A7%81%E9%97%AE%E9%A2%98/#%E9%81%BF%E5%85%8D%E6%B6%88%E6%81%AF%E4%B8%A2%E5%A4%B1%E5%AE%9E%E8%B7%B5)

### Docker-Compose部署Kafka

单集群配置文件：`zk-single-kafka-single.yml`

多集群配置文件：`zk-single-kafka-multiple.yml`

```shell
# 启动
docker-compose -f zk-single-kafka-single.yml up

# 查看状态

# 关闭
docker-compose -f zk-single-kafka-single.yml down
```

相关参数说明
```markdown
KAFKA_ADVERTISED_HOST_NAME：广播主机名称，一般用IP指定
KAFKA_ZOOKEEPER_CONNECT：Zookeeper连接地址，格式：zoo1：port1,zoo2:port2:/path
KAFKA_LISTENERS：Kafka启动所使用的的协议及端口
KAFKA_ADVERTISED_LISTENERS：Kafka广播地址及端口，也就是告诉客户端，使用什么地址和端口能连接到Kafka，这个很重要，如果不指定，宿主机以外的客户端将无法连接到Kafka，比如我这里因为容器与宿主机做了端口映射，所以广播地址采用的是宿主机的地址及端口，告诉客户端只要连接到宿主机的指定端口就行了
KAFKA_BROKER_ID：指定BrokerId，如果不指定，将会自己生成
```