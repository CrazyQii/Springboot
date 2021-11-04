import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;


import java.util.*;

/**
 * 生产者
 */
public class    SimpleProducer {

    private String topic = null;

    private KafkaProducer<String, String> producer = null;

    public SimpleProducer(String topic) {
        System.out.println("生产者初始化完成");
        this.topic = topic;

        // 创建生产者配置实例
        Properties props = new Properties();

        // 本地id
        props.put("bootstrap.servers", "172.25.117.45:9092");
        props.put("acks", "all"); //所有follower都响应了才认为消息提交成功，即"committed"
        props.put("retries", 2); //retries = MAX 无限重试
        props.put("batch.size", 16384); //producer将试图批处理消息记录，以减少请求次数.默认的批量处理消息字节数
        props.put("linger.ms", 1); //延迟1ms发送，这项设置将通过增加小的延迟来完成--即，不是立即发送一条记录，producer将会等待给定的延迟时间以允许其他消息记录发送，这些消息记录可以批量处理
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        // 创建producer
        this.producer = new KafkaProducer<String, String>(props);
    }

    public void run() {
        System.out.println("开始发送消息");
        try {
            while (true) {
                String msg = "Hello," + new Random().nextInt(100);
                String key = "Key" +  new Random().nextInt(10);
                ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, key, msg);
                producer.send(record);
                System.out.println("消息发送成功:" + msg);
                Thread.sleep(5000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
