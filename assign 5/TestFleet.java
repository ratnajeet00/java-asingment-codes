// Design a Java application that models a fleet of
// vehicles by creating an interface `Vehicle` with methods for starting,
// stopping, getting speed, and fuel type. Implement this interface in `Car`,
// `Bus`, and `Motorcycle` classes. Additionally, create a `Maintenance` interface
// with a maintenance method, and implement it in the `Car` and `Bus` classes.
// Demonstrate the use of these interfaces and their implementations through a
// test class that showcases polymorphism and interface-based programming


// TestFleet.java
public class TestFleet {
    public static void main(String[] args) {
        Vehicle car = new Car(120, "Petrol");
        Vehicle bus = new Bus(80, "Diesel");
        Vehicle motorcycle = new Motorcycle(100, "Petrol");

        car.start();
        System.out.println("Car speed: " + car.getSpeed());
        System.out.println("Car fuel type: " + car.getFuelType());
        car.stop();

        bus.start();
        System.out.println("Bus speed: " + bus.getSpeed());
        System.out.println("Bus fuel type: " + bus.getFuelType());
        bus.stop();

        motorcycle.start();
        System.out.println("Motorcycle speed: " + motorcycle.getSpeed());
        System.out.println("Motorcycle fuel type: " + motorcycle.getFuelType());
        motorcycle.stop();

        Maintenance carMaintenance = (Maintenance) car;
        carMaintenance.performMaintenance();

        Maintenance busMaintenance = (Maintenance) bus;
        busMaintenance.performMaintenance();
    }
}