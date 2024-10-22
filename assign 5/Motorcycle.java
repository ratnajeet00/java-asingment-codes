// Motorcycle.java
public class Motorcycle implements Vehicle {
    private int speed;
    private String fuelType;

    public Motorcycle(int speed, String fuelType) {
        this.speed = speed;
        this.fuelType = fuelType;
    }

    @Override
    public void start() {
        System.out.println("Motorcycle is starting.");
    }

    @Override
    public void stop() {
        System.out.println("Motorcycle is stopping.");
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public String getFuelType() {
        return fuelType;
    }
}