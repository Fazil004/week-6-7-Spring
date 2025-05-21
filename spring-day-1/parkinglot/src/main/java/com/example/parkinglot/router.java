package com.example.parkinglot;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
public class router {

    private parkingLot pl;

    @PostMapping("/vehicles")
    public void parkVehicle(@RequestBody Vehicle vehicle) {
        pl.parkVehicle(vehicle);
    }

    @DeleteMapping("/vehicles/{plate}")
    public void unparkVehicle(@PathVariable Vehicle vehicle) {
        pl.unparkVehicle(vehicle);
    }

    @GetMapping("/slots/free")
    public int getFreeSlots() {
        return pl.getFreeSlots();
    }

    @GetMapping("/slots/status")
    public void getStatus() {
        pl.printStatus();
    }
}