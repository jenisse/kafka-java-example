package com.mycompany.kafkaexample;

public class ApplicationRun {

    public static void main(String[] args) {
        new KafkaConsumerExample().startConsuming("test", "test");
        new KafkaProducerExample().send("test", "Mensajes por netbeans 1");
        new KafkaProducerExample().send("test", "Mensajes por netbeans 2");
        new KafkaProducerExample().send("test", "Mensajes por netbeans 3");
        new KafkaProducerExample().send("test", "Mensajes por netbeans 4");
        new KafkaProducerExample().send("test", "Mensajes por netbeans 5");
    }
}
