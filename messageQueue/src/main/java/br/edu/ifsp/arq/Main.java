package br.edu.ifsp.arq;

public class Main {
    public static void main(String[] args) {

        SensorQueue sensorQueue = new SensorQueue();

        Thread producer1 = new Thread(new SensorProducer("Kitchen", sensorQueue));
        Thread producer2 = new Thread(new SensorProducer("Living room", sensorQueue));

        Thread consumer = new Thread(new SensorConsumer(sensorQueue));

        producer1.start();
        producer2.start();
        consumer.start();
    }
}
