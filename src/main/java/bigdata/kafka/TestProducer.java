package bigdata.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.PartitionInfo;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestProducer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.0.223:9092,192.168.0.224:9092,192.168.0.225:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        //生产者发送消息
        String topic = "topic.test.01";
        Producer<String, String> producer = new KafkaProducer<>(props);

        for(int i=0; i<10; i++) {
            String value = "v_" + i;
            ProducerRecord<String, String> msg = new ProducerRecord<>(topic, value);
            producer.send(msg);
        }

        //列出topic的相关信息
        List<PartitionInfo> partitions = producer.partitionsFor(topic);
        for(PartitionInfo p : partitions) {
            System.out.println(p);
        }


        System.out.println("send message over.");
        producer.close(100, TimeUnit.MILLISECONDS);
    }
}
