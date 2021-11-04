import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class SimpleConsumerOld implements Runnable {

    private String topic = null;

    private ConsumerConnector consumerConnector = null;

    public SimpleConsumerOld(String topic) {
        System.out.println("消费者初始化完成");
        this.topic = topic;

        // 创建消费者配置
        Properties props = new Properties();

        props.put("zookeeper.connect", "localhost:2181");
        props.put("auto.offset.reset","smallest");//初始的offset默认是非法的，然后这个设置的意思是，当offset非法时，如何修正offset，默认是largest，即最新，所以不加这个配置，你是读不到你之前produce的数据
        props.put("group.id", "test");
        props.put("enable.auto.commit","");
        props.put("zookeeper.session.timeout.ms", "400");
        props.put("zookeeper.sync.time.ms", "200"); //
        props.put("auto.commit.interval.ms", "1000");

        consumerConnector = Consumer.createJavaConsumerConnector(new ConsumerConfig(props));
    }

    @Override
    public void run() {
        System.out.println("启动消费者线程");
        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();

        topicCountMap.put(this.topic, 3); // 一次从一个主题中获取数据
        Map<String, List<KafkaStream<byte[], byte[]>>> messageStream = consumerConnector.createMessageStreams(topicCountMap);
        KafkaStream<byte[], byte[]> kafkaStream = messageStream.get(this.topic).get(0);

        for (kafka.message.MessageAndMetadata<byte[], byte[]> messageAndMetadata : kafkaStream) {
            String message = new String(messageAndMetadata.message());
            System.out.println("接收到: " + message);
        }

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
    }

    public static void main(String[] args) {
        SimpleConsumerOld consumerOld = new SimpleConsumerOld("TEST");
        consumerOld.run();
    }
}
