package br.edu.ifsp.arq;

import java.util.LinkedList;
import java.util.Queue;

public class SensorQueue {

    private final Queue<SensorData> queue;

    public SensorQueue() {
        this.queue = new LinkedList<>();
    }

    public void addSensorData(SensorData data) {
        synchronized (queue){
            queue.add(data);
            queue.notify();
        }
    }

    public SensorData getSensorData() {
        synchronized (queue){
            while (queue.isEmpty()) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return queue.poll();
        }
    }

}
