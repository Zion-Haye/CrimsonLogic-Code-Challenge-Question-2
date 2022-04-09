package com.example;

public class Applicant {
    private String emailAddress;
    private Appointment appointment;

    public Applicant(String emailAddress) {
        setEmailAddress(emailAddress);
        appointment = null;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public String toString() {
        String applicantDetails = "Applicant Details: \n";
        applicantDetails += "Email Address: " + getEmailAddress();
        return applicantDetails;
    }
}
