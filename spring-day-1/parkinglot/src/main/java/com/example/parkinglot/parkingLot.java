package com.example.parkinglot;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public class parkingLot {
    List<parkingSlot> slots;

    public parkingLot() {
        slots = new ArrayList<parkingSlot>();
        for(int i = 0; i < 11; i++) {
            slots.add(new parkingSlot());
        }
    }
    public void parkVehicle(Vehicle vehicle) {
        for(parkingSlot slot : slots) {
            if(!slot.isOccupied) {
                slot.assignVehicle(vehicle);
                System.out.println("slot id "+slot.slotId+" is assigned");
                break;

            }
        }
    }
    public void unparkVehicle(Vehicle vehicle) {
        for(parkingSlot slot : slots) {
            if(slot.vehicle == vehicle) {
                slot.unassignVehicle(vehicle);
            }
        }
    }
    public int getFreeSlots() {
        int freeSlots = 0;
        for(parkingSlot slot : slots) {
            if(!slot.isOccupied) {
                freeSlots++;
            }
        }
        System.out.println("freeSlots "+freeSlots);
        return freeSlots;
    }
    public void printStatus() {
        int occupied = 0;
        for(parkingSlot slot : slots) {
            if(slot.vehicle != null) {
                System.out.print(slot.slotId+" is occupied ");
                System.out.println();
            }
            else {
                System.out.print(slot.slotId+" is unoccupied ");
                System.out.println();
            }
        }
    }
}
