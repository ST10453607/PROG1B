package com.iie.hospital;

public class Ward {
    private Bed[][] wardBeds;

    public Ward() {
        wardBeds = new Bed[4][5];
        int bedCounter = 1;
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 5; col++) {
                String bedNumber = String.format("B%02d", bedCounter);
                wardBeds[row][col] = new Bed(bedNumber);
                bedCounter++;
            }
        }
    }

    //Find bed method
    public Bed findBed(String bedNumber) {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 5; col++) {
                if (wardBeds[row][col].getBedNumber().equals(bedNumber)) {
                    return wardBeds[row][col];
                }
            }
        }
        return null;
    }

    //Allocated method
    public boolean allocatedBed(String bedNumber, Inpatient patient) {
        Bed bed = findBed(bedNumber);

        if (bed == null) {
            return false;
        }
        if (bed.isOccupied()) {
            return false;
        } else {
            bed.setOccupied(true);
            bed.setPatient(patient);
            return true;
        }

    }

    //releaseBed method
    public boolean releaseBed(String bedNumber) {
        Bed bed = findBed(bedNumber);

        if (bed == null || !bed.isOccupied()) {
            return false;
        } else {
            bed.release();
            return true;
        }
    }

    // displayWardLayout method
    public void displayWardLayout() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 5; col++) {
                Bed bed = wardBeds[row][col];
                if (bed.isOccupied()) {
                    System.out.print(bed.getBedNumber() + "[Occupied] ");
                } else {
                    System.out.print(bed.getBedNumber() + "[Empty] ");
                }
            }
            System.out.println();
        }

    }

    public int getTotalBeds() {
        return 20;
    }

    public int getOccupiedCount() {
        int count = 0;
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 5; col++) {
                if (wardBeds[row][col].isOccupied()) {
                    count++;
                }
            }
        }
        return count;
    }
    public int getAvailableCount() {
        return getTotalBeds() - getOccupiedCount();
    }
    public double getOccupancyPercentage() {
        return (getOccupiedCount() * 100.0) / getTotalBeds();
    }
    public void generateOccupancyReport() {
        System.out.println("=== Bed Occupancy Report ===");
        System.out.println("Total Beds: " + getTotalBeds());
        System.out.println("Occupied Beds: " + getOccupiedCount());
        System.out.println("Available Beds: " + getAvailableCount());
        System.out.println("Occupancy Percentage: " + getOccupancyPercentage());
    }

            }





