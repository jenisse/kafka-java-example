package com.mycompany.kafkaexample;

import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class KafkaProducerExample {

    private static final String KAFKA_SERVER = "localhost:9092";
    private final Producer<String, String> producer;

    public KafkaProducerExample() {
        final Properties props = new Properties();
        props.put("metadata.broker.list", KAFKA_SERVER);
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        producer = new Producer<>(new ProducerConfig(props));
    }

    public void send(String topic, String message) {
        producer.send(new KeyedMessage<String, String>(topic, message));
    }

    public void close() {
        producer.close();
    }

}
