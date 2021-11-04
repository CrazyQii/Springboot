import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 消费者新版本
 */
public class SimpleConsumer {

//    private final static String TOPIC = "TEST";
//
//    public static void main(String[] args) {
//        // 创建消费者配置
//        Properties props = new Properties();
//
//        // Kafka地址
//        props.put("bootstrap.servers", "172.20.102.102:9092");
//
//        //group 代表一个消费组
//        // 组名 不同组名可以重复消费。例如你先使用了组名A消费了kafka的1000条数据，
//        // 但是你还想再次进行消费这1000条数据，并且不想重新去产生，那么这里你只需要更改组名就可以重复消费了。
//        props.put("group.id", "jd-group");
//        // 是否自动提交，默认为true
//        props.put("enable.auto.commit", "true");
//        props.put("auto.commit.interval.ms", "1000");
//
//        // zk连接超时
//        props.put("session.timeout.ms", "30000");
//        // 消费规则
//        // earliest: 当各分区下有已提交的offset时，从提交的offset开始消费；无提交的offset时，从头开始消费 。
//        // latest: 当各分区下有已提交的offset时，从提交的offset开始消费；无提交的offset时，消费新产生的该分区下的数据 。
//        // none: topic各分区都存在已提交的offset时，从offset后开始消费；只要有一个分区不存在已提交的offset，则抛出异常。
//        props.put("auto.offset.reset", "earliest");
//        // 反序列化
//        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//
//
//        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
//        consumer.subscribe(Collections.singletonList(TOPIC));
//        try {
//            while (true) {
//                ConsumerRecords<String, String> records = consumer.poll(100);
//                for (ConsumerRecord<String, String> record: records) {
//                    System.out.println("消息: " + record.offset() + record.value());
////                    System.out.println("key"  + record.key());
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            consumer.close();
//        }
//
//    }

}
