package com.iie.hospital;

public class Bed {
    private String bedNumber;
    private boolean occupied;
    private Inpatient patient;

public Bed(String bedNumber) {
    this.bedNumber = bedNumber;
    this.occupied = false;
    this.patient = null;
}
public String getBedNumber() {
    return bedNumber;
}
public void setBedNumber(String bedNumber) {
    this.bedNumber = bedNumber;
}
public boolean isOccupied() {
    return occupied;
}
public void setOccupied(boolean occupied) {
    this.occupied = occupied;
}
public Inpatient getPatient() {
    return patient;
}
public void setPatient(Inpatient patient) {
    this.patient = patient;
}
public void release() {
    this.patient = null;
    this.occupied = false;
}
}
