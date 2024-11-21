package com.example;

import java.sql.*;
import java.util.Scanner;

public class Main {

    // Database connection class
    public static class DatabaseConnection {
        private static final String URL = "jdbc:mysql://localhost:3306/hospital_db";
        private static final String USER = "root";  // your MySQL username
        private static final String PASSWORD = "Kashiba@00";  // your MySQL password

        public static Connection getConnection() throws SQLException {
            try {
                return DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                throw new SQLException("Connection to the database failed.", e);
            }
        }
    }

    // Patient class
    public static class Patient {
        private String name;
        private int age;
        private String address;
        private String phoneNumber;

        public Patient(String name, int age, String address, String phoneNumber) {
            this.name = name;
            this.age = age;
            this.address = address;
            this.phoneNumber = phoneNumber;
        }

        // Method to add patient to the database
        public void addPatient() {
            try (Connection connection = DatabaseConnection.getConnection()) {
                String query = "INSERT INTO patients (patient_name, age, phone_number, address) VALUES (?, ?, ?, ?)";
                try (PreparedStatement stmt = connection.prepareStatement(query)) {
                    stmt.setString(1, this.name);
                    stmt.setInt(2, this.age);
                    stmt.setString(3, this.phoneNumber);
                    stmt.setString(4, this.address);
                    stmt.executeUpdate();
                    System.out.println("Patient added successfully!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Method to view all patients
        public static void viewPatients() {
            try (Connection connection = DatabaseConnection.getConnection()) {
                String query = "SELECT * FROM patients";
                try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
                    while (rs.next()) {
                        System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("patient_name") +
                                ", Age: " + rs.getInt("age") + ", Phone: " + rs.getString("phone_number") +
                                ", Address: " + rs.getString("address"));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Doctor class
    public static class Doctor {
        private String name;
        private String specialization;
        private String contactNumber;

        public Doctor(String name, String specialization, String contactNumber) {
            this.name = name;
            this.specialization = specialization;
            this.contactNumber = contactNumber;
        }

        // Method to add doctor to the database
        public void addDoctor() {
            try (Connection connection = DatabaseConnection.getConnection()) {
                String query = "INSERT INTO doctors (name, specialization, contact_number) VALUES (?, ?, ?)";
                try (PreparedStatement stmt = connection.prepareStatement(query)) {
                    stmt.setString(1, this.name);
                    stmt.setString(2, this.specialization);
                    stmt.setString(3, this.contactNumber);
                    stmt.executeUpdate();
                    System.out.println("Doctor added successfully!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Method to view all doctors
        public static void viewDoctors() {
            try (Connection connection = DatabaseConnection.getConnection()) {
                String query = "SELECT * FROM doctors";
                try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
                    while (rs.next()) {
                        System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") +
                                ", Specialization: " + rs.getString("specialization") + ", Contact: " + rs.getString("contact_number"));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Appointment class
    public static class Appointment {

        // Method to schedule an appointment
        public static void scheduleAppointment() {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter patient ID: ");
            int patientId = scanner.nextInt();

            System.out.print("Enter doctor ID: ");
            int doctorId = scanner.nextInt();

            System.out.print("Enter appointment date (yyyy-mm-dd): ");
            String appointmentDate = scanner.next();

            try (Connection connection = DatabaseConnection.getConnection()) {
                String query = "INSERT INTO appointments (patient_id, doctor_id, appointment_date) VALUES (?, ?, ?)";
                try (PreparedStatement stmt = connection.prepareStatement(query)) {
                    stmt.setInt(1, patientId);
                    stmt.setInt(2, doctorId);
                    stmt.setString(3, appointmentDate);
                    stmt.executeUpdate();
                    System.out.println("Appointment scheduled successfully!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Method to view all appointments
        public static void viewAppointments() {
            try (Connection connection = DatabaseConnection.getConnection()) {
                String query = "SELECT * FROM appointments";
                try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
                    while (rs.next()) {
                        System.out.println("Appointment ID: " + rs.getInt("id") +
                                ", Patient ID: " + rs.getInt("patient_id") +
                                ", Doctor ID: " + rs.getInt("doctor_id") +
                                ", Date: " + rs.getDate("appointment_date"));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Main program logic
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the Hospital Management System");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Add Doctor");
            System.out.println("4. View Doctors");
            System.out.println("5. Schedule Appointment");
            System.out.println("6. View Appointments");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter patient name: ");
                    String name = scanner.next();
                    System.out.print("Enter patient age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter patient address: ");
                    String address = scanner.next();
                    System.out.print("Enter patient phone number: ");
                    String phoneNumber = scanner.next();
                    Patient patient = new Patient(name, age, address, phoneNumber);
                    patient.addPatient();
                    break;

                case 2:
                    Patient.viewPatients();
                    break;

                case 3:
                    System.out.print("Enter doctor name: ");
                    String doctorName = scanner.next();
                    System.out.print("Enter doctor specialization: ");
                    String specialization = scanner.next();
                    System.out.print("Enter doctor contact number: ");
                    String contact = scanner.next();
                    Doctor doctor = new Doctor(doctorName, specialization, contact);
                    doctor.addDoctor();
                    break;

                case 4:
                    Doctor.viewDoctors();
                    break;

                case 5:
                    Appointment.scheduleAppointment();
                    break;

                case 6:
                    Appointment.viewAppointments();
                    break;

                case 7:
                    System.out.println("Exiting the system...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
