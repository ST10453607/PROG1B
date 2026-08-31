package com.iie.hospital;

public class Inpatient extends Patient {
    private String wardNumber;
    private String bedNumber;

public Inpatient(String patientID, String fistName, String lastName, String gender, String medicalCondition, PatientCategory category, int age, String wardNumber, String bedNumber) {
    super(patientID, fistName, lastName, gender, medicalCondition, category, age);
    this.wardNumber = wardNumber;
    this.bedNumber = bedNumber;
    }
public String getWardNumber() {
    return wardNumber;
}
public void setWardNumber(String wardNumber) {
    this.wardNumber = wardNumber;
}
public String getBedNumber() {
    return bedNumber;
}
public void setBedNumber(String bedNumber) {
    this.bedNumber = bedNumber;
}
@Override
public void displayDetails() {
    super.displayDetails();
    System.out.println("Ward Number: " + wardNumber);
    System.out.println("Bed Number: " + bedNumber);
}
}

