package br.edu.ifsp.arq;

import java.util.Random;

public class SensorProducer implements Runnable{

    private final SensorQueue sensorQueue;
    private final String sensorName;
    private final Random random;

    public SensorProducer(String sensorName, SensorQueue sensorQueue) {
        this.sensorName = sensorName;
        this.sensorQueue = sensorQueue;
        this.random = new Random();
    }

    @Override
    public void run() {
        while(true){
            double temperature = random.nextDouble(10, 50);
            double humidity =  random.nextDouble(20, 90);

            SensorData data = new SensorData(sensorName, temperature, humidity);
            sensorQueue.addSensorData(data);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
