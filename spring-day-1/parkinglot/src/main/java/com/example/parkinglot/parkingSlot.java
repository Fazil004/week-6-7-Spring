package com.example.parkinglot;

public class parkingSlot {
    static int count=0;
    int slotId;
    boolean isOccupied;
    Vehicle vehicle;

    public parkingSlot() {
        count++;
        slotId=count;
        isOccupied = false;
        this.vehicle = null;
    }

    public int getSlotId() {return slotId;}
    public boolean isOccupied() {return isOccupied;}
    public Vehicle getVehicle() {return vehicle;}

    public void assignVehicle(Vehicle vehicle) {
        isOccupied = true;
        this.vehicle = vehicle;
        System.out.println("slot is assigned");
    }
    public void unassignVehicle(Vehicle vehicle) {
        isOccupied = false;
        this.vehicle = null;
        System.out.println("slot is unassigned");
    }
}
