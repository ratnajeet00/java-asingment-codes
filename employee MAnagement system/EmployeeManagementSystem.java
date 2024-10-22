import java.util.Scanner;
import java.util.Vector;

class Employee {
    int empId;
    String name;
    int age;
    double salary;

    public Employee(int empId, String name, int age, double salary) {
        this.empId = empId;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String displayDetails() {
        return "ID: " + empId + ", Name: " + name + ", Age: " + age + ", Salary: " + salary;
    }

    public String work() {
        return name + " is working.";
    }
}

class Manager extends Employee {
    int teamSize;

    public Manager(int empId, String name, int age, double salary, int teamSize) {
        super(empId, name, age, salary);
        this.teamSize = teamSize;
    }

    @Override
    public String work() {
        return name + " is managing a team of " + teamSize + " employees.";
    }

    public String manageTeam() {
        return name + " is holding a team meeting.";
    }
}

class SeniorManager extends Manager {
    String department;

    public SeniorManager(int empId, String name, int age, double salary, int teamSize, String department) {
        super(empId, name, age, salary, teamSize);
        this.department = department;
    }

    @Override
    public String work() {
        return name + " is overseeing the " + department + " department.";
    }
}

class Developer extends Employee {
    String programmingLanguage;

    public Developer(int empId, String name, int age, double salary, String programmingLanguage) {
        super(empId, name, age, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public String work() {
        return name + " is coding in " + programmingLanguage + ".";
    }

    public String developFeature() {
        return name + " is developing a new feature using " + programmingLanguage + ".";
    }
}

class Tester extends Employee {
    String testTool;

    public Tester(int empId, String name, int age, double salary, String testTool) {
        super(empId, name, age, salary);
        this.testTool = testTool;
    }

    @Override
    public String work() {
        return name + " is testing using " + testTool + ".";
    }

    public String testSoftware() {
        return name + " is testing software using " + testTool + ".";
    }
}

class Intern extends Developer {
    String testTool;

    public Intern(int empId, String name, int age, double salary, String programmingLanguage, String testTool) {
        super(empId, name, age, salary, programmingLanguage);
        this.testTool = testTool;
    }

    @Override
    public String work() {
        return name + " is learning to code in " + programmingLanguage + " and test using " + testTool + ".";
    }
}

public class EmployeeManagementSystem {

    private Vector<Employee> employees = new Vector<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void displayAllEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee.displayDetails());
            System.out.println(employee.work());
            System.out.println("====================");
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Employee Management System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nSelect Employee Type:");
                    System.out.println("1. Manager");
                    System.out.println("2. Senior Manager");
                    System.out.println("3. Developer");
                    System.out.println("4. Tester");
                    System.out.println("5. Intern");
                    System.out.print("Enter choice: ");
                    int type = sc.nextInt();

                    System.out.print("Enter Employee ID: ");
                    int empId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();

                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();

                    switch (type) {
                        case 1:
                            System.out.print("Enter Team Size: ");
                            int teamSize = sc.nextInt();
                            ems.addEmployee(new Manager(empId, name, age, salary, teamSize));
                            break;
                        case 2:
                            System.out.print("Enter Team Size: ");
                            teamSize = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter Department: ");
                            String department = sc.nextLine();
                            ems.addEmployee(new SeniorManager(empId, name, age, salary, teamSize, department));
                            break;
                        case 3:
                            sc.nextLine();
                            System.out.print("Enter Programming Language: ");
                            String programmingLanguage = sc.nextLine();
                            ems.addEmployee(new Developer(empId, name, age, salary, programmingLanguage));
                            break;
                        case 4:
                            sc.nextLine();
                            System.out.print("Enter Test Tool: ");
                            String testTool = sc.nextLine();
                            ems.addEmployee(new Tester(empId, name, age, salary, testTool));
                            break;
                        case 5:
                            sc.nextLine();
                            System.out.print("Enter Programming Language: ");
                            programmingLanguage = sc.nextLine();
                            System.out.print("Enter Test Tool: ");
                            testTool = sc.nextLine();
                            ems.addEmployee(new Intern(empId, name, age, salary, programmingLanguage, testTool));
                            break;
                        default:
                            System.out.println("Invalid choice!");
                    }
                    break;

                case 2:
                    System.out.println("\n=== Employee List ===");
                    ems.displayAllEmployees();
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 3);

        sc.close();
    }
}
