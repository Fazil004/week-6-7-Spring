package com.example.parkinglot;

public class Vehicle {
    String licensePlate;
    int entrytime;

    public Vehicle() {}
    public Vehicle(String licensePlate, int entrytime) {
        this.licensePlate = licensePlate;
        this.entrytime = entrytime;
    }
    public String getLicensePlate() {return licensePlate;}
    public int getEntrytime() {return entrytime;}

    public void setLicensePlate(String licensePlate) {this.licensePlate = licensePlate;}
    public void setEntrytime(int entrytime) {this.entrytime = entrytime;}

    @Override
    public String toString() {
        return licensePlate;
    }
}
