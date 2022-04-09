package com.example;

public class Appointment {

    private String officeLocation;
    private String emailAddress;
    private String day;
    private String month;
    private int dateNum;
    private int startingHour;
    private int startingMinute;
    private int endingHour;
    private int endingMinute;
    private final int duration = 15;

    public Appointment(String officeLocation, String month, String day, int dateNum, int startingHour,
            int startingMinute, String emailAddress) {
        setOfficeLocation(officeLocation);
        setMonth(month);
        setDay(day);
        setDateNum(dateNum);
        setStartingTimes(startingHour, startingMinute);
        setEmailAddress(emailAddress);
    }

    public void setStartingTimes(int startingHour, int startingMinute) {
        setStartingHour(startingHour);
        setStartingMinute(startingMinute);

        setEndingTimes(startingHour, startingMinute);
    }

    public void setEndingTimes(int startingHour, int startingMinute) {
        endingMinute = startingMinute + duration;
        endingHour = startingHour;

        if (endingMinute == 60) {
            endingMinute = 0;
            endingHour = endingHour + 1;
        }

        setEndingHour(endingHour);
        setEndingMinute(endingMinute);
    }

    public int getDateNum() {
        return dateNum;
    }

    public void setDateNum(int dateNum) {
        this.dateNum = dateNum;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getStartingHour() {
        return startingHour;
    }

    public void setStartingHour(int startingHour) {
        this.startingHour = startingHour;
    }

    public int getEndingMinute() {
        return endingMinute;
    }

    public void setEndingMinute(int endingMinute) {
        this.endingMinute = endingMinute;
    }

    public int getEndingHour() {
        return endingHour;
    }

    public void setEndingHour(int endingHour) {
        this.endingHour = endingHour;
    }

    public int getStartingMinute() {
        return startingMinute;
    }

    public void setStartingMinute(int startingMinute) {
        this.startingMinute = startingMinute;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getOfficeLocation() {
        return officeLocation;
    }

    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }

    public String toString() {
        String appointmentDetails = "Appointment Details:\n";
        appointmentDetails += "Office Location: " + getOfficeLocation() + "\n";
        appointmentDetails += "Date: " + getDay() + " " + getDateNum() + " " + getMonth() + "\n";
        appointmentDetails += "Starting Time: " + getStartingHour() + ":" + getStartingMinute() + "\n";
        appointmentDetails += "Ending Time: " + getEndingHour() + ":" + getEndingMinute() + "\n";
        return appointmentDetails;

    }

}
