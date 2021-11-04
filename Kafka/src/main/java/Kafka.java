import javafx.concurrent.Worker;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Kafka {
    private static final String TOPIC = "TEST";

    public static void main(String[] args) {

        ThreadPoolExecutor task = new ThreadPoolExecutor(1, 2147483, 60, TimeUnit.MINUTES, new SynchronousQueue<Runnable>());
//        SimpleConsumerOld consumerOld = new SimpleConsumerOld(TOPIC);
//        consumerOld.run();
//        task.execute(consumerOld);


        SimpleProducer producer = new SimpleProducer(TOPIC);
        producer.run();

        SimpleConsumerOld consumerOld = new SimpleConsumerOld(TOPIC);
        consumerOld.run();
    }
}
