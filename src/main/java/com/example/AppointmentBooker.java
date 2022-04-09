package com.example;

import java.util.ArrayList;

public class AppointmentBooker {

    private ArrayList<Appointment> bookedAppointments;

    public AppointmentBooker() {
        bookedAppointments = new ArrayList<Appointment>();
    }

    public Appointment makeAppointment(String officeLocation, String month, String day, int dateNum, int startingHour,
            int startingMinute, String emailAddress) {
        if (!checkAppointmentExists(month, day, dateNum, startingHour, startingMinute)) {
            Appointment appointment = new Appointment(officeLocation, month, day, dateNum, startingHour, startingMinute,
                    emailAddress);
            bookedAppointments.add(appointment);
            return appointment;
        }

        return null;
    }

    public boolean cancelAppointment(Appointment appointment) {

        if (appointment != null) {
            bookedAppointments.remove(appointment);
            System.out.println("Appointment Succesfully Cancelled\n");
            return true;
        }

        System.out.println("Appointment Cancellation Unsuccesful\n");
        return false;

    }

    public boolean checkAppointmentExists(String month, String day, int dateNum, int startingHour, int startingMinute) {
        for (Appointment appointment : bookedAppointments) {
            if ((appointment.getMonth().equalsIgnoreCase(month)) && (appointment.getDay().equalsIgnoreCase(day))
                    && (appointment.getDateNum() == dateNum) && (appointment.getStartingHour() == startingHour)
                    && (appointment.getEndingMinute() == startingMinute)) {
                return true;
            }
        }
        return false;
    }

}
