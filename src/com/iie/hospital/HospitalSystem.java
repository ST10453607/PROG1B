package com.iie.hospital;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HospitalSystem {
    private ArrayList<Patient> patients;
    private Ward ward;

    public HospitalSystem() {
        patients = new ArrayList<>();
        ward = new Ward();
    }
    //registerPatient method
    public boolean registerPatient(Patient patient) {
        for (int i = 0; i< patients.size();i++) {
            if (patients.get(i).getPatientId().equals(patient.getPatientId())) {
                return false;
            }
        }
        patients.add(patient);
        return true;
    }

    //searchPatient method
    public Patient searchPatient(String patientId) {
        for (int i = 0; i< patients.size();i++) {
            if (patients.get(i).getPatientId().equals(patientId)) {
                return patients.get(i);
            }
        }
        return null;
    }

    //deletePatient method
    public boolean deletePatient(String patientId) {
        Patient found = searchPatient(patientId);

        if (found == null) {
            return false;
        } else {
            patients.remove(found);
            return true;
        }
    }
    //updatePatient method
    public boolean updatePatient(String patientId, String firstName, String lastName, String gender, String medicalCondition) {
        Patient found = searchPatient(patientId);
        if (found == null) {
            return false;
        }
        found.setFirstName(firstName);
        found.setLastName(lastName);
        found.setGender(gender);
        found.setMedicalCondition(medicalCondition);
        return true;
    }

    //displayAllPatients method
    public void displayPatients() {
        for (int i = 0; i< patients.size();i++) {
            patients.get(i).displayDetails();
        }
    }

    public Ward getWard() {
        return ward;
    };

    public int getTotalPatients() {
        return patients.size();
    }
    public void generatePatientReport() {
        System.out.println("===Patient Report===");
        displayPatients();
        System.out.println("Total Patients: " + getTotalPatients());

    }
    public void sortPatientsBySurname() {
        Collections.sort(patients, Comparator.comparing(Patient::getLastName));
    }
    public void sortPatientsById() {
        Collections.sort(patients, Comparator.comparing(Patient::getPatientId));
    }
}
