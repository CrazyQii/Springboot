import org.apache.kafka.clients.producer.KafkaProducer;

import java.util.Properties;

/**
 * 生产者
 */
public class SimpleProducer {

    private final KafkaProducer<String, String> producer;

    private final static String TOPIC = "topic_test";

    public SimpleProducer() {
        // 创建生产者配置实例
        Properties props = new Properties();

        // 本地id
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all"); //所有follower都响应了才认为消息提交成功，即"committed"
        props.put("retries", 0); //retries = MAX 无限重试
        props.put("batch.size", 16384); //producer将试图批处理消息记录，以减少请求次数.默认的批量处理消息字节数
        props.put("linger.ms", 1); //延迟1ms发送，这项设置将通过增加小的延迟来完成--即，不是立即发送一条记录，producer将会等待给定的延迟时间以允许其他消息记录发送，这些消息记录可以批量处理
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        this.producer = new KafkaProducer<String, String>(props);
    }

}
