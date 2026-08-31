package com.iie.hospital;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HospitalSystem hospitalSystem = new HospitalSystem();
        Ward ward = hospitalSystem.getWard();
        boolean running = true;


        while (running) {
            System.out.println("Welcome to Hospital System");
            System.out.println("1. Register Patient");
            System.out.println("2. Search Patient");
            System.out.println("3. Update Patient");
            System.out.println("4. Delete Patient");
            System.out.println("5. Display All Patients");
            System.out.println("6. Allocate bed");
            System.out.println("7. Release bed");
            System.out.println("8. Display Ward Layout");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Patient ID: ");
                    String id = scanner.nextLine();
                    System.out.print("First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Last Name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Gender: ");
                    String gender = scanner.nextLine();
                    System.out.print("Medical Condition: ");
                    String condition = scanner.nextLine();
                    System.out.print("Age: ");
                    int age = Integer.parseInt(scanner.nextLine());
                    System.out.print("Category (INPATIENT/OUTPATIENT/EMERGENCY ): ");
                    String catInput = scanner.nextLine().toUpperCase();
                    PatientCategory category = PatientCategory.valueOf(catInput);

                    Patient newPatient;
                    if (category == PatientCategory.INPATIENT) {
                        System.out.print("Bed Number (e.g. B01): ");
                        String bedNumber = scanner.nextLine();
                        Inpatient inpatient = new Inpatient(id, firstName, lastName, gender, condition, category, age, "1", bedNumber);
                        boolean allocated = ward.allocatedBed(bedNumber, inpatient);
                        if (!allocated) {
                            System.out.println("Bed unavailable or invalid. Registration cancelled.");
                            break;
                        }
                        newPatient = inpatient;
                    } else {
                        newPatient = new Patient(id, firstName, lastName, gender, condition, category, age);
                    }

                    boolean registered = hospitalSystem.registerPatient(newPatient);
                    System.out.println(registered ? "Patient registered" : "Duplicate Patient ID. Registration failed.");
                    break;

                case "2":
                    System.out.print("Enter Patient ID to search: ");
                    Patient found = hospitalSystem.searchPatient(scanner.nextLine());
                    if (found == null) {
                        System.out.println("Patient not found.");
                    } else {
                        found.displayDetails();
                    }
                    break;

                case "3":
                    System.out.print("Enter Patient ID to update: ");
                    String updatedId = scanner.nextLine();
                    System.out.print("New First Name: ");
                    String updatedFirstName = scanner.nextLine();
                    System.out.print("New Last Name: ");
                    String updatedLastName = scanner.nextLine();
                    System.out.print("New Gender: ");
                    String updatedGender = scanner.nextLine();
                    System.out.print("New Medical Condition: ");
                    String updatedCondition = scanner.nextLine();
                    boolean updated = hospitalSystem.updatePatient(updatedId, updatedFirstName, updatedLastName, updatedGender, updatedCondition);
                    System.out.println(updated ? "Patient updated" : "Patient not found.");
                    break;

                case "4":
                    System.out.print("Enter Patient ID to delete: ");
                    boolean deleted = hospitalSystem.deletePatient(scanner.nextLine());
                    System.out.println(deleted ? "Patient deleted" : "Patient not found.");
                    break;

                case "5":
                    hospitalSystem.displayPatients();
                    break;

                case "6":
                    System.out.print("Bed number to allocate: ");
                    System.out.println("Use Register Patient (Option 1) to allocate a bed to a new inpatient");
                    break;

                case "7":
                    System.out.print("Bed number to release: ");
                    boolean released = ward.releaseBed(scanner.nextLine());
                    System.out.println(released ? "Bed released" : "Bed not found or already empty.");
                    break;

                case "8":
                    ward.displayWardLayout();
                    break;

                case "9":
                    hospitalSystem.generatePatientReport();
                    break;

                case "10":
                    ward.generateOccupancyReport();
                    break;

                case "11":
                    hospitalSystem.sortPatientsBySurname();
                    System.out.println("Sorted patients by Surname");
                    break;

                case "12":
                    hospitalSystem.sortPatientsById();
                    System.out.println("Sorted patients by ID");
                    break;

                case "13":
                    running = false;
                    System.out.println("Exiting Hospital System");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");

            }

        }
        scanner.close();

        }
    }

