package com.mycompany.kafkaexample;

import java.time.LocalDateTime;
import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class KafkaProducer implements AutoCloseable {

	private final Producer<String, String> producer;

	public KafkaProducer(String kafkaServer) {
		final Properties props = new Properties();
		props.put("metadata.broker.list", kafkaServer);
		props.put("serializer.class", "kafka.serializer.StringEncoder");
		producer = new Producer<>(new ProducerConfig(props));
	}

	public void send(String topic, String message) {
		String now = LocalDateTime.now().toString();
		String messageWithHour = String.format("[%s] %s", now, message);
		producer.send(new KeyedMessage<String, String>(topic, messageWithHour));
		System.out.format("Message \"%s\" was sent to Kafka Server %n", messageWithHour);
	}

	@Override
	public void close() {
		producer.close();
	}

}
