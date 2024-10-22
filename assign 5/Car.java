

// Car.java
public class Car implements Vehicle, Maintenance {
    private int speed;
    private String fuelType;

    public Car(int speed, String fuelType) {
        this.speed = speed;
        this.fuelType = fuelType;
    }

    @Override
    public void start() {
        System.out.println("Car is starting.");
    }

    @Override
    public void stop() {
        System.out.println("Car is stopping.");
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public String getFuelType() {
        return fuelType;
    }

    @Override
    public void performMaintenance() {
        System.out.println("Performing maintenance on the car.");
    }
}