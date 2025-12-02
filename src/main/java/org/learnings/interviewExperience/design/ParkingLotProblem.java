package org.learnings.interviewExperience.design;

/**
 * singleton class representing a parking lot
 */
class ParkingLot{
    private static ParkingLot parkingLot;
    private final Level[] levels = new Level[3];

    public ParkingLot initializeParkingLot(){
        if(parkingLot == null){
            parkingLot = new ParkingLot();
        }
        return parkingLot;
    }
    public Level getLevel(int index){
        if (index < 0 || index >= levels.length) {
            throw new IndexOutOfBoundsException("Invalid level index");
        }
        return levels[index];
    }
    public void parkVehicle(Vehicle vehicle){
        for(Level level: levels){
            for(ParkingSpot spot: level.getParkingSpots()){
                if(spot.isAvailable()){
                    spot.setAvailable(false);
                    spot.setVehicle(vehicle);
                    Ticket ticket = new Ticket("TICKET_" + System.currentTimeMillis(), spot);
                    vehicle.setTicket(ticket);
                    System.out.println("Vehicle parked at spot: " + spot.getSpotNumber() + " with ticket ID: " + ticket.getTicketId());
                    return;
                }
            }
        }
    }
    public void unparkVehicle(Vehicle vehicle){
        for(Level level: levels){
            for(ParkingSpot spot: level.getParkingSpots()){
                if(spot.getVehicle() != null && spot.getVehicle().equals(vehicle)){
                    spot.setAvailable(true);
                    spot.setVehicle(null);
                    System.out.println("Vehicle unparked from spot: " + spot.getSpotNumber());
                    System.out.println("Total parking Fee: " + calculateTotalParkingFee(vehicle));
                    return;
                }
            }
        }
        System.out.println("Vehicle not found in the parking lot.");
    }
    private int calculateTotalParkingFee(Vehicle vehicle) {
        // Assuming a simple fee structure: $2 per hour
        long parkedTime = System.currentTimeMillis() - vehicle.getTicket().getIssueTime();
        return (int) (parkedTime / (1000 * 60 * 60)) * 2; // Convert milliseconds to hours and calculate fee
    }
}
class Level{
    private final int levelNumber;
    private final int availableSpots;
    private ParkingSpot[] parkingSpots;
    public Level(int levelNumber, int totalSpots) {
        this.levelNumber = levelNumber;
        this.availableSpots = totalSpots;
        this.parkingSpots = new ParkingSpot[totalSpots];
        for (int i = 0; i < totalSpots; i++) {
            parkingSpots[i] = new ParkingSpot(i + 1);
        }
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public int getAvailableSpots() {
        return availableSpots;
    }

    public ParkingSpot[] getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(ParkingSpot[] parkingSpots) {
        this.parkingSpots = parkingSpots;
    }
}
class ParkingSpot {
    private int spotNumber;
    private boolean isAvailable;
    private Vehicle vehicle;
    public ParkingSpot(int spotNumber) {
        this.spotNumber = spotNumber;
        this.isAvailable = true;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
abstract class Vehicle{
    private final String licensePlate;
    private final String color;
    private final VehicleType vehicleType;
    private Ticket ticket;

    public Vehicle(String licensePlate, String color, VehicleType vehicleType) {
        this.licensePlate = licensePlate;
        this.color = color;
        this.vehicleType = vehicleType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getColor() {
        return color;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
    public Ticket getTicket() {
        return ticket;
    }
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
class Car extends Vehicle{
    public Car(String licensePlate, String color, VehicleType vehicleType) {
        super(licensePlate, color, vehicleType);
    }
}
class Truck extends Vehicle{
    public Truck(String licensePlate, String color, VehicleType vehicleType) {
        super(licensePlate, color, vehicleType);
    }
}
class Motorcycle extends Vehicle {
    public Motorcycle(String licensePlate, String color, VehicleType vehicleType) {
        super(licensePlate, color, vehicleType);
    }
}
enum VehicleType{
    CAR, MOTORCYCLE, TRUCK
}
class Ticket {
    private final String ticketId;
    private final ParkingSpot parkingSpot;
    private final long issueTime;

    public Ticket(String ticketId, ParkingSpot parkingSpot) {
        this.ticketId = ticketId;
        this.parkingSpot = parkingSpot;
        this.issueTime = System.currentTimeMillis();
    }

    public String getTicketId() {
        return ticketId;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public long getIssueTime() {
        return issueTime;
    }
}
public class ParkingLotProblem {
    public static void main(String[] args) {

    }
}
