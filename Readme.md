# kafka-java-example

Example for message queueing using Kafka. Simple Producer-Consumer java application

## Getting Started

These instructions will get you a copy of the project set up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

Java (jre)

Kafka binaries 


### Installing

A step by step series of examples that tell you how to get a development env running

1- Set Java_HOME and Path variables

```
JAVA_HOME = C:\Program Files\Java\jre1.8.0_172
```

```
Path =+ %JAVA_HOME%\bin 
```

2- Download Binaries from https://kafka.apache.org/downloads

3- Unzip Binaries and locate them in a directory
```
Example ---> C (ejemplo= C:\tools\kafka_2.12-2.0.0\kafka_2.12-2.0.0)
```

4- Start Zookeper Server in default server 2181

open a terminal on the directory where the Kafka binaries are

run the following command 
```
.\bin\windows\zookeper-server-start.bat .\config\zookeeper.properties
```

5- Start Kafka Server in default server 9092

open a terminal on the directory where the Kafka binaries are

run the following command 
```
.\bin\windows\kafka-server-start.bat .\config\server.properties
```

6- Create a topic

open a terminal on the directory where the Kafka binaries are

run the following command 
```
.\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test
```


## Running 

With both servers running run the maven project


### And you will see that is a damn socket!!!!!!

