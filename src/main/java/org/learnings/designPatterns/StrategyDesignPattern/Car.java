package org.learnings.designPatterns.StrategyDesignPattern;

// Problem: Different cars have different driving behaviors (e.g., normal drive, sports drive, off-road drive).
// If we hardcode driving logic in Car, it's hard to change or extend behaviors without modifying Car class and also 2 or more child classes can have the same behavior.

// Strategy Pattern Solution: Define a DrivingStrategy interface and inject it into Car.
// This allows changing driving behavior at runtime and adding new strategies easily.

// Strategy interface
interface DrivingStrategy {
    void drive();
}

// Concrete strategies
class NormalDriveStrategy implements DrivingStrategy {
    public void drive() {
        System.out.println("Driving in normal mode.");
    }
}

class SportsDriveStrategy implements DrivingStrategy {
    public void drive() {
        System.out.println("Driving in sports mode!");
    }
}

class OffRoadDriveStrategy implements DrivingStrategy {
    public void drive() {
        System.out.println("Driving off-road.");
    }
}

// Context class
public class Car {
    private DrivingStrategy drivingStrategy;

    public Car(DrivingStrategy drivingStrategy) {
        this.drivingStrategy = drivingStrategy;
    }

    public void setDrivingStrategy(DrivingStrategy drivingStrategy) {
        this.drivingStrategy = drivingStrategy;
    }

    public void drive() {
        drivingStrategy.drive();
    }

    // Example usage
    public static void main(String[] args) {
        Car sedan = new Car(new NormalDriveStrategy());
        sedan.drive(); // Output: Driving in normal mode.

        sedan.setDrivingStrategy(new SportsDriveStrategy());
        sedan.drive(); // Output: Driving in sports mode!

        Car suv = new Car(new OffRoadDriveStrategy());
        suv.drive(); // Output: Driving off-road.
    }
}