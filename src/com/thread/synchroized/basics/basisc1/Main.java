package com.thread.synchroized.basics.basisc1;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ParkingCash cash = new ParkingCash();
        ParkingStats stats = new ParkingStats(cash);
        System.out.printf("Parking Simulator\n");
        int numberSensors = 2 * Runtime.getRuntime().availableProcessors();
        Thread[] threads = new Thread[numberSensors];
        for (int i = 0; i < numberSensors; i++) {
            Sensor sensor = new Sensor(stats);
            Thread thread = new Thread(sensor);
            thread.start();
            threads[i] = thread;
        }
        for (int i = 0; i < numberSensors; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Number of cars: %d \n",stats.getNumberCaes());
        System.out.printf("Number of NumberMotorcycles: %d \n",stats.getNumberMotorcycles());
        cash.close();
    }
}
