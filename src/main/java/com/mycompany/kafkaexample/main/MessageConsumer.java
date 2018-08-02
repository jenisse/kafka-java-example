package com.mycompany.kafkaexample.main;

import com.mycompany.kafkaexample.KafkaConsumerExample;

public class MessageConsumer {

	public static void main(String[] args) {
		String kafkaServer = "localhost:9092";
		String topicName = "test";

		KafkaConsumerExample kafkaConsumerExample = new KafkaConsumerExample(kafkaServer);
		kafkaConsumerExample.startConsuming(topicName);
	}

}
