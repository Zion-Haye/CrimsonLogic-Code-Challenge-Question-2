package com.example;

import java.util.ArrayList;

public class AppointmentSystem {
    private ArrayList<Office> offices;

    public AppointmentSystem() {
        offices = new ArrayList<Office>();
        initialiseOffices();
    }

    public Office getOffice(String officeLocation) {
        for (Office office : offices) {
            if (office.getOfficeLocation().equalsIgnoreCase(officeLocation)) {
                return office;
            }
        }
        return null;
    }

    public String viewListOfOffices() {
        if (offices.isEmpty()) {
            return "There are no offices";
        } else {
            String listOfOffices = "Office Locations:\n";
            for (Office office : offices) {
                listOfOffices += office.getOfficeLocation() + "\n";
            }
            return listOfOffices;
        }
    }

    // Populate Office Data
    private void initialiseOffices() {
        addOffice(new Office("North"));
        addOffice(new Office("South"));
        addOffice(new Office("West"));
        addOffice(new Office("East"));
    }

    private void addOffice(Office office) {
        offices.add(office);
    }
}
