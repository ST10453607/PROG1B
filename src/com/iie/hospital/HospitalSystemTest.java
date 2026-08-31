package com.iie.hospital;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HospitalSystemTest {
    @Test
    public void testRegisterPatient() {
        HospitalSystem system = new HospitalSystem();
        Patient p = new Patient("P001", "John", "Doe", "Male", "Flu", PatientCategory.OUTPATIENT, 30);
        assertTrue(system.registerPatient(p));
    }
    @Test
    public void testDuplicatePatientId() {
        HospitalSystem system = new HospitalSystem();
        Patient p1 = new Patient("P001", "John", "Doe", "Male", "Flu", PatientCategory.OUTPATIENT, 30);
        Patient p2 = new Patient("P001", "Jane", "Smith", "Female", "Cold", PatientCategory.OUTPATIENT, 25);
        system.registerPatient(p1);
        assertFalse(system.registerPatient(p2));
    }
    @Test
    public void testSearchPatient() {
        HospitalSystem system = new HospitalSystem();
        Patient p = new Patient("P001", "John", "Doe", "Male", "Flu", PatientCategory.OUTPATIENT, 30);
        system.registerPatient(p);
        assertNotNull(system.searchPatient("P001"));
    }

    @Test
    public void testUpdatePatient() {
        HospitalSystem system = new HospitalSystem();
        Patient p = new Patient("P001", "John", "Doe", "Male", "Flu", PatientCategory.OUTPATIENT, 30);
        system.registerPatient(p);
        assertTrue(system.updatePatient("P001", "John", "Doe", "Male", "Revovered"));
    }
    @Test
    public void testDeletePatient() {
        HospitalSystem system = new HospitalSystem();
        Patient p = new Patient("P001", "John", "Doe", "Male", "Flu", PatientCategory.OUTPATIENT, 30);
        system.registerPatient(p);
        assertTrue(system.deletePatient("P001"));
    }

}
