import java.util.*;

public class Main {
    int id, price, totalSeats, seatsAvailable, seatsBooked;
    String name, endPlace;

    Main(int no, String n, int seats, int sBook) {
        id = no;
        name = n;
        totalSeats = seats;
        seatsBooked = sBook;
        seatsAvailable = totalSeats - seatsBooked;
    }

    int bookedTickets() {
        return seatsBooked;
    }

    String moveName() {
        return name;
    }

    int availableSeats() {
        return seatsAvailable;
    }

    @Override
    public String toString() {
        return "Bus ID: " + id + "\nName: " + name + "\nTotal Seats: " + totalSeats +
                "\nBooked Seats: " + seatsBooked + "\nAvailable Seats: " + seatsAvailable +
                "\nDestination: " + endPlace;
    }

    void setDestination(String place) {
        this.endPlace = place;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome To Ticket Booking");

        List<Main> buses = new ArrayList<>();

        buses.add(new Main(1, "Bus A", 50, 10));
        buses.add(new Main(2, "Bus B", 40, 5));
        buses.add(new Main(3, "Bus C", 30, 0));

        int sw;
        do {
            System.out.println("1. Traveler 2. Company 3. Exit");
            sw = sc.nextInt();
            switch (sw) {
                case 1:
                    travelerMenu(sc, buses);
                    break;

                case 2:
                    companyMenu(sc, buses);
                    break;

                case 3:
                    System.out.println("Exiting system.");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (sw != 3);

        sc.close();
    }

    private static void travelerMenu(Scanner sc, List<Main> buses) {
        int choice;
        do {
            System.out.println("1. View All Buses\n2. Book a Ticket\n3. Search a Bus\n4. Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    viewAllBuses(buses);
                    break;

                case 2:
                    bookTicket(sc, buses);
                    break;

                case 3:
                    searchBus(sc, buses);
                    break;

                case 4:
                    System.out.println("Exiting traveler menu.");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 4);
    }

    private static void viewAllBuses(List<Main> buses) {
        if (buses.isEmpty()) {
            System.out.println("No buses available.");
            return;
        }

        for (Main bus : buses) {
            System.out.println(bus);
            System.out.println("-----------------------------");
        }
    }

    private static void bookTicket(Scanner sc, List<Main> buses) {
        System.out.print("Enter Bus ID to book a ticket: ");
        int busId = sc.nextInt();

        for (Main bus : buses) {
            if (bus.id == busId) {
                if (bus.availableSeats() > 0) {
                    boolean paymentSuccessful = processPayment(sc);

                    if (paymentSuccessful) {
                        bus.seatsBooked++;
                        bus.seatsAvailable--;
                        System.out.println("Ticket booked successfully on " + bus.name);
                    } else {
                        System.out.println("Payment failed. Ticket not booked.");
                    }

                } else {
                    System.out.println("No available seats on this bus.");
                }
                return;
            }
        }

        System.out.println("Bus ID not found.");
    }

    private static boolean processPayment(Scanner sc) {
        System.out.println("Ticket Booking\nEnter Payment method\n1. Card  2. UPI ");
        int paymentChoice = sc.nextInt();

        switch (paymentChoice) {
            case 1:
                return cardPayment(sc);

            case 2:
                return upiPayment(sc);

            default:
                System.out.println("Invalid payment option. Payment failed.");
                return false;
        }
    }

    private static boolean cardPayment(Scanner sc) {
        System.out.print("Enter Card Number: ");
        String cardNumber = sc.next();

        if (cardNumber.length() == 16) {
            System.out.println("Card payment successful.");
            return true;
        } else {
            System.out.println("Invalid card number. Payment failed.");
            return false;
        }
    }

    private static boolean upiPayment(Scanner sc) {
        System.out.print("Enter UPI ID: ");
        String upiId = sc.next();

        if (upiId.contains("@")) {
            System.out.println("UPI payment successful.");
            return true;
        } else {
            System.out.println("Invalid UPI ID. Payment failed.");
            return false;
        }
    }

    private static void searchBus(Scanner sc, List<Main> buses) {
        System.out.print("Enter Bus Name to search: ");
        String searchName = sc.next();

        boolean found = false;

        for (Main bus : buses) {
            if (bus.moveName().equalsIgnoreCase(searchName)) {
                System.out.println(bus);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No bus found with the name: " + searchName);
        }
    }

    private static void companyMenu(Scanner sc, List<Main> buses) {
        System.out.print("Enter Company Username: ");
        String username = sc.next();

        System.out.print("Enter Company Password: ");
        String password = sc.next();

        if (username.equals("admin") && password.equals("password")) {
            int choice;
            do {
                System.out.println("\n1. Add Bus\n2. Remove Bus\n3. Update Bus\n4. View All Buses\n5. Exit");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        addBus(sc, buses);
                        break;

                    case 2:
                        removeBus(sc, buses);
                        break;

                    case 3:
                        updateBus(sc, buses);
                        break;

                    case 4:
                        viewAllBuses(buses);
                        break;

                    case 5:
                        System.out.println("Exiting company menu.");
                        break;

                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } while (choice != 5);

        } else {
            System.out.println("Invalid credentials. Access denied.");
        }
    }

    private static void addBus(Scanner sc, List<Main> buses) {
        System.out.print("Enter Bus ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Bus Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Total Seats: ");
        int totalSeats = sc.nextInt();

        System.out.print("Enter Booked Seats: ");
        int bookedSeats = sc.nextInt();

        System.out.print("Enter Destination: ");
        sc.nextLine();
        String destination = sc.nextLine();

        Main newBus = new Main(id, name, totalSeats, bookedSeats);
        newBus.setDestination(destination);
        buses.add(newBus);

        System.out.println("Bus added successfully.");
    }

    private static void removeBus(Scanner sc, List<Main> buses) {
        System.out.print("Enter Bus ID to remove: ");
        int busId = sc.nextInt();

        Iterator<Main> iterator = buses.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            Main bus = iterator.next();
            if (bus.id == busId) {
                iterator.remove();
                System.out.println("Bus removed successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Bus ID not found.");
        }
    }

    private static void updateBus(Scanner sc, List<Main> buses) {
        System.out.print("Enter Bus ID to update: ");
        int busId = sc.nextInt();

        for (Main bus : buses) {
            if (bus.id == busId) {
                System.out.print("Enter new Bus Name: ");
                sc.nextLine();
                bus.name = sc.nextLine();

                System.out.print("Enter new Total Seats: ");
                bus.totalSeats = sc.nextInt();

                System.out.print("Enter new Booked Seats: ");
                bus.seatsBooked = sc.nextInt();
                bus.seatsAvailable = bus.totalSeats - bus.seatsBooked;

                System.out.print("Enter new Destination: ");
                sc.nextLine();
                bus.endPlace = sc.nextLine();

                System.out.println("Bus updated successfully.");
                return;
            }
        }

        System.out.println("Bus ID not found.");
    }
}
