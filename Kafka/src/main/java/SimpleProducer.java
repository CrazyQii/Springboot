import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.KafkaAdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.internals.Topic;

import java.util.*;

/**
 * 生产者
 */
public class SimpleProducer {

    private final static String TOPIC = "TOPIC-MAIN";

    public static void main(String[] args) {
        // 创建生产者配置实例
        Properties props = new Properties();

        // 本地id
//        props.put("bootstrap.servers", "localhost:9092");
//        props.put("acks", "all"); //所有follower都响应了才认为消息提交成功，即"committed"
//        props.put("retries", 0); //retries = MAX 无限重试
//        props.put("batch.size", 16384); //producer将试图批处理消息记录，以减少请求次数.默认的批量处理消息字节数
//        props.put("linger.ms", 1); //延迟1ms发送，这项设置将通过增加小的延迟来完成--即，不是立即发送一条记录，producer将会等待给定的延迟时间以允许其他消息记录发送，这些消息记录可以批量处理
//        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        props.put("metadata.broker.list", "127.0.0.1:9092");
        //配置value的序列化类
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        //配置key的序列化类
        props.put("key.serializer.class", "kafka.serializer.StringEncoder");
        props.put("request.required.acks","-1");

        // 创建producer

        try (KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props)) {
            while (true) {
                String msg = "Hello," + new Random().nextInt(100);
                ProducerRecord<String, String> record = new ProducerRecord<String, String>(TOPIC, msg);
                producer.send(record);
                System.out.println("消息发送成功:" + msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
