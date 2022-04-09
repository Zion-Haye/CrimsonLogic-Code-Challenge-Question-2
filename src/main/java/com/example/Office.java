package com.example;

public class Office {
    private String officeLocation;
    private WeeklySchedule weeklySchedule;
    private AppointmentBooker appointmentBooker;

    public Office(String officeLocation) {
        setOfficeLocation(officeLocation);
        weeklySchedule = new WeeklySchedule();
        appointmentBooker = new AppointmentBooker();
    }

    public String getOfficeLocation() {
        return officeLocation;
    }

    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }

    public Appointment makeAppointment(String officeLocation, String month, String day, int dateNum, int startingHour,
            int startingMinute, String emailAddress) {
        if (weeklySchedule.getInterviewSlot(day, startingHour, startingMinute) != null) {
            if (appointmentBooker.makeAppointment(officeLocation, month, day, dateNum, startingHour, startingMinute,
                    emailAddress) != null) {

                System.out.println("The following Appointment has been created:\n");
                System.out.println(appointmentBooker
                        .makeAppointment(officeLocation, month, day, dateNum, startingHour, startingMinute,
                                emailAddress)
                        .toString());
                return appointmentBooker.makeAppointment(officeLocation, month, day, dateNum, startingHour,
                        startingMinute, emailAddress);
            } else {
                System.out.println("Appointment is already booked. Please try again.");
                return null;
            }
        }
        System.out.println("Invalid Interview Slot.");
        return null;
    }

    public boolean cancelAppointment(Appointment appointment) {
        return appointmentBooker.cancelAppointment(appointment);
    }

    public void viewScheduleByDay(String day) {
        weeklySchedule.viewScheduleByDay(day);
    }

    public void viewSchedule() {
        weeklySchedule.viewSchedule();
    }
}
