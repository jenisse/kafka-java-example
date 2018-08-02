package com.mycompany.kafkaexample;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class KafkaConsumerExample {

	private String kafkaSever;

	public KafkaConsumerExample(String kafkaServer) {
		this.kafkaSever = kafkaServer;
	}
	
    public void startConsuming(String topicName) {
        ConsumerThread consumerRunnable = new ConsumerThread(topicName, this.kafkaSever);
        consumerRunnable.start();
    }

    private static class ConsumerThread extends Thread {

        private String topicName;
        private String kafkaServer;
        private KafkaConsumer<String, String> kafkaConsumer;

        public ConsumerThread(String topicName, String kafkaServer) {
            this.topicName = topicName;
            this.kafkaServer = kafkaServer;
        }

        public void run() {
            Properties configProperties = new Properties();
            configProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
            configProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
            configProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
            configProperties.put(ConsumerConfig.GROUP_ID_CONFIG, "any");
            configProperties.put(ConsumerConfig.CLIENT_ID_CONFIG, "simple");

            kafkaConsumer = new KafkaConsumer<>(configProperties);
            kafkaConsumer.subscribe(Arrays.asList(topicName));
            while (true) {
            	System.out.println("Waiting messages...");
                ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofSeconds(5));
                for (ConsumerRecord<String, String> record : records) {
                    System.out.println(record.value());
				}
			}
		}
	}

}
