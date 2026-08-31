package com.iie.hospital;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class WardTest {

    @Test
    public void testAllocateBed() {
        Ward ward = new Ward();
        Inpatient patient = new Inpatient("P001", "John", "Doe", "Male", "Flu", PatientCategory.INPATIENT, 30, "1", "B01");
        assertTrue(ward.allocatedBed("B01", patient));
    }

    @Test
    public void testReleaseBed() {
        Ward ward = new Ward();
        Inpatient patient = new Inpatient("P001", "John", "Doe", "Male", "Flu", PatientCategory.INPATIENT, 30, "1", "B01");
        ward.allocatedBed("B01", patient);
        assertTrue(ward.releaseBed("B01"));
    }

    @Test
    public void testCannotAllocateOccupiedBed() {
        Ward ward = new Ward();
        Inpatient patient1 = new Inpatient("P001", "John", "Doe", "Male", "Flu", PatientCategory.INPATIENT, 30, "1", "B01");
        Inpatient patient2 = new Inpatient("P002", "Jane", "Smith", "Female", "Cold", PatientCategory.INPATIENT, 25, "1", "B01");
        ward.allocatedBed("B01", patient1);
        assertFalse(ward.allocatedBed("B01", patient2));
    }

    @Test
    public void testFullWardPreventsAllocation() {
        Ward ward = new Ward();
        String[] bedNumbers = {"B01", "B02", "B03", "B04", "B05", "B06", "B07", "B08", "B09", "B10",
                "B11", "B12", "B13", "B14", "B15", "B16", "B17", "B18", "B19", "B20"};
        for (int i = 0; i < bedNumbers.length; i++) {
            Inpatient patient = new Inpatient("P0" + i, "Test", "Patient", "Male", "Condition", PatientCategory.INPATIENT, 30, "1", bedNumbers[i]);
            ward.allocatedBed(bedNumbers[i], patient);
        }
        Inpatient overflowPatient = new Inpatient("P999", "Overflow", "Patient", "Male", "Condition", PatientCategory.INPATIENT, 30, "1", "B01");
        assertFalse(ward.allocatedBed("B01", overflowPatient));
    }
}
