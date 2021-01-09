package com.thread.synchroized.basics.basisc1;

public class ParkingStats {
    private long numberCaes;
    private long numberMotorcycles;
    private ParkingCash cash;

    public ParkingStats(ParkingCash cash) {
        numberCaes = 0;
        numberMotorcycles = 0;
        this.cash = cash;
    }

    public void carComeIn(){
        numberCaes++;
    }

    public void carGoOUt(){
        numberCaes--;
        cash.vehiclepay();
    }

    public void motoComeIn(){
        numberMotorcycles++;
    }

    public void  motoGoOut(){
        numberMotorcycles--;
        cash.vehiclepay();
    }

    public long getNumberCaes() {
        return numberCaes;
    }

    public long getNumberMotorcycles() {
        return numberMotorcycles;
    }

    public ParkingCash getCash() {
        return cash;
    }
}
