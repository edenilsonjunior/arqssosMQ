package br.edu.ifsp.arq;

import java.time.LocalDateTime;

public class SensorData {

    private String sensorName;
    private double temperature;
    private double humidity;
    private LocalDateTime timestamp;

    public SensorData(String sensorName, double temperature, double humidity) {
        this.sensorName = sensorName;
        this.temperature = temperature;
        this.humidity = humidity;
        this.timestamp = LocalDateTime.now();
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "SensorData{" +
                "sensorName='" + sensorName + '\'' +
                ", temperature=" + String.format("%.2f", temperature) +
                ", humidity=" + String.format("%.2f", humidity) +
                ", timestamp=" + timestamp +
                '}';
    }

}
