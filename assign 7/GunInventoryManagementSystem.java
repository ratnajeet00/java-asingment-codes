// Implement basic operations (add, remove,
// iterate) on ArrayList and LinkedList, and perform basic operations on HashSet
// and TreeSet, including adding/removing elements and checking for duplicates.
// Apply these operations in context of inventory management system.
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Scanner;

class GunInventoryManagementSystem {
    private ArrayList<String> gunInventory;
    private LinkedList<String> inventoryHistory;
    private HashSet<String> uniqueGuns;
    private TreeSet<String> sortedUniqueGuns;

    public GunInventoryManagementSystem() {
        gunInventory = new ArrayList<>();
        inventoryHistory = new LinkedList<>();
        uniqueGuns = new HashSet<>();
        sortedUniqueGuns = new TreeSet<>();
    }

    public void addGun(String gun) {
        if (uniqueGuns.add(gun)) {
            gunInventory.add(gun);
            inventoryHistory.add("Added: " + gun);
            sortedUniqueGuns.add(gun);
            System.out.println(gun + " has been added to the inventory.");
        } else {
            System.out.println(gun + " is already in the inventory.");
        }
    }

    public void removeGun(String gun) {
        if (gunInventory.remove(gun)) {
            inventoryHistory.add("Removed: " + gun);
            uniqueGuns.remove(gun);
            sortedUniqueGuns.remove(gun);
            System.out.println(gun + " has been removed from the inventory.");
        } else {
            System.out.println(gun + " was not found in the inventory.");
        }
    }

    public void listGuns() {
        System.out.println("Current Gun Inventory:");
        if (gunInventory.isEmpty()) {
            System.out.println("No guns in inventory.");
            return;
        }
        for (String gun : gunInventory) {
            System.out.println("- " + gun);
        }
    }

    public void listInventoryHistory() {
        System.out.println("Inventory Change History:");
        for (String change : inventoryHistory) {
            System.out.println("- " + change);
        }
    }

    public void displayUniqueGuns() {
        System.out.println("Unique Guns:");
        for (String gun : uniqueGuns) {
            System.out.println("- " + gun);
        }
    }

    public void displaySortedUniqueGuns() {
        System.out.println("Sorted Unique Guns:");
        for (String gun : sortedUniqueGuns) {
            System.out.println("- " + gun);
        }
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nGun Inventory Management System");
            System.out.println("1. Add Gun");
            System.out.println("2. Remove Gun");
            System.out.println("3. List Guns");
            System.out.println("4. List Inventory History");
            System.out.println("5. Display Unique Guns");
            System.out.println("6. Display Sorted Unique Guns");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the gun to add: ");
                    String addGun = scanner.nextLine();
                    addGun(addGun);
                    break;
                case 2:
                    System.out.print("Enter the name of the gun to remove: ");
                    String removeGun = scanner.nextLine();
                    removeGun(removeGun);
                    break;
                case 3:
                    listGuns();
                    break;
                case 4:
                    listInventoryHistory();
                    break;
                case 5:
                    displayUniqueGuns();
                    break;
                case 6:
                    displaySortedUniqueGuns();
                    break;
                case 0:
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    public static void main(String[] args) {
        GunInventoryManagementSystem inventorySystem = new GunInventoryManagementSystem();
        inventorySystem.start();
    }
}
