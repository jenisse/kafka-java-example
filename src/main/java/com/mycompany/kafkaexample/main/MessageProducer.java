package com.mycompany.kafkaexample.main;

import com.mycompany.kafkaexample.KafkaProducer;

public class MessageProducer {

	public static void main(String[] args) {
		String kafkaServer = "localhost:9092";
		String topicName = "test";

		try (KafkaProducer producer = new KafkaProducer(kafkaServer)) {
			producer.send(topicName, "Mensajes por netbeans 1");
			producer.send(topicName, "Mensajes por netbeans 2");
			producer.send(topicName, "Mensajes por netbeans 3");
			producer.send(topicName, "Mensajes por netbeans 4");
			producer.send(topicName, "Mensajes por netbeans 5");
		}
	}
}
