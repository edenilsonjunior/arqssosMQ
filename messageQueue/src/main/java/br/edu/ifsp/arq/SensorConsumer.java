package br.edu.ifsp.arq;

public class SensorConsumer implements Runnable {

    private SensorQueue sensorQueue;


    public SensorConsumer(SensorQueue sensorQueue) {
        this.sensorQueue = sensorQueue;
    }

    @Override
    public void run() {
        while(true){
            SensorData data = sensorQueue.getSensorData();
            System.out.println("Consuming data: " + data);
            processSensorData(data);
        }
    }

    private void processSensorData(SensorData data) {

        checkTemperature(data);
        checkHumidity(data);
    }

    private void checkTemperature(SensorData data){

        if(data.getTemperature() > 28.00){

            String response = String.format("\n\nALERT: \nThe %s has a temperature above the recommended level: %.2f°C\n\n",
                    data.getSensorName(), data.getTemperature());

            System.out.println(response);
        }
    }

    private void checkHumidity(SensorData data){

        if(data.getHumidity() < 40.00){
            String response = String.format("\n\nALERT: \nThe %s has humidity below the recommended level: %.2f%%\n\n",
                    data.getSensorName(), data.getHumidity());

            System.out.println(response);
        }
    }

}
