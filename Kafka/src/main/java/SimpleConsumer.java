import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleConsumer {

    private final static String TOPIC = "TOPIC-MAIN";


    public static void main(String[] args) {
        // 创建消费者配置
        Properties props = new Properties();

        props.put("bootstrap.servers", "localhost:2181");
//
//        //group 代表一个消费组
//        props.put("group.id", "jd-group");
//        props.put("enable.auto.commit", "true");
//        props.put("auto.commit.interval.ms", "1000");
//
//        //zk连接超时
//        props.put("auto.offset.reset", "earliest");
//        props.put("session.timeout.ms", "30000");
//        //反序列化
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

//        props.put("zookeeper.connect", "127.0.0.1:2182");

        //group 代表一个消费组
        props.put("group.id", "test-consumer-group");

        //zk连接超时
        props.put("zookeeper.session.timeout.ms", "4000");
        props.put("zookeeper.sync.time.ms", "200");
        props.put("auto.commit.interval.ms", "1000");
        props.put("auto.offset.reset", "earliest");//必须要加，如果要读旧数据
        //序列化类
//        props.put("serializer.class", "kafka.serializer.StringEncoder");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);

        consumer.subscribe(Collections.singleton(TOPIC));

        try {
            while (true) {
                ConsumerRecords<String, String> consumerRecords = consumer.poll(100);

                for (ConsumerRecord<String, String> record: consumerRecords) {
                    System.out.println("topic: " + record.topic() + "消息:" + record.offset() + record.value());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            consumer.close();
        }

    }

}
