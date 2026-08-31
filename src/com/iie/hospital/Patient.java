package com.iie.hospital;

public class Patient {
    private String patientId;
    private String firstName;
    private String lastName;
    private String gender;
    private String medicalCondition;
    private PatientCategory category;
    private int age;
public Patient(String patientId, String firstName, String lastName, String gender, String medicalCondition, PatientCategory category, int age) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.medicalCondition = medicalCondition;
        this.category = category;
        this.age = age;
}
public String getPatientId() {
    return patientId;
}
public void setPatientId(String patientId) {
    this.patientId = patientId;
}
public String getFirstName() {
    return firstName;
}
public void setFirstName(String firstName) {
   this.firstName = firstName;
}
public String getLastName() {
    return lastName;
}
public void setLastName(String lastName) {
    this.lastName = lastName;
}
public String getGender() {
    return gender;
}
public void setGender(String gender) {
    this.gender = gender;
}
public String getMedicalCondition() {
    return medicalCondition;
}
public void setMedicalCondition(String medicalCondition) {
    this.medicalCondition = medicalCondition;
}
public PatientCategory getCategory() {
    return category;
}
public void setCategory(PatientCategory category) {
    this.category = category;
}
public int getAge() {
    return age;
}
public void setAge(int age) {
    this.age = age;
}
public void displayDetails() {
    System.out.println("Patient ID: " + patientId);
    System.out.println("First name: " + firstName);
    System.out.println("Last name: " + lastName);
    System.out.println("Gender: " + gender);
    System.out.println("Medical Condition: " + medicalCondition);
    System.out.println("Category: " + category);
    System.out.println("Age: " + age);

}

}
