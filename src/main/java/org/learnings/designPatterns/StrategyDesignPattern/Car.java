package org.learnings.designPatterns.StrategyDesignPattern;

public interface Car {
    void drive();
}

class SportsCar implements Car {
    @Override
    public void drive() {
        System.out.println("Drive Algorith for sports car");
    }
}

class RaceCar implements Car {
    @Override
    public void drive() {
        System.out.println("Drive Algorith for sports car");
    }
}

class NormalCar implements Car {
    @Override
    public void drive() {
        System.out.println("Drive Algorith for Normal car");
    }
}

class Client {
    public static void main(String[] args) {
        Car sportsCar = new SportsCar();
        sportsCar.drive();
        Car raceCar = new RaceCar();
        raceCar.drive();
        Car normalCar = new NormalCar();
        normalCar.drive();
    }
}

// So to avoid the duplicacy of drive implementation in implementing classes
// we generally create a common strategy for Drive Algo

interface DriveStrategy {
    void drive();
}

class SportsDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Sports Drive Algo");
    }
}

class RaceDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Sports Drive Algo");
    }
}

class NormalDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Normal Drive Algo");
    }
}

class AnotherCar {
    DriveStrategy driveStrategy;

    AnotherCar(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }

    public void drive() {
        driveStrategy.drive();
    }
}

class MotorSports extends AnotherCar {
    MotorSports() {
        super(new RaceDriveStrategy()); // constructor injection as we are justfifyng which strategy to be injected
    }
}

class RaceSports extends AnotherCar {
    RaceSports() {
        super(new RaceDriveStrategy());
    }
}

class TaxiCar extends AnotherCar {
    TaxiCar() {
        super(new NormalDriveStrategy());
    }
}

class AnotherClient {
    public static void main(String[] args) {
        AnotherCar moterSports = new MotorSports();
        moterSports.drive();
        AnotherCar raceSports = new RaceSports();
        raceSports.drive();
        AnotherCar taxiCar = new TaxiCar();
        taxiCar.drive();
    }
}