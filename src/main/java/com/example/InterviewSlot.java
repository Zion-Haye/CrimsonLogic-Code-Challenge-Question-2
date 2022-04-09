package com.example;

public class InterviewSlot {
    private int startingHour;
    private int endingHour;
    private int startingMinute;
    private int endingMinute;
    private final int duration = 15;
    private boolean isAvailable;
    private String day;
    private String status;

    public InterviewSlot(String day, int startingHour, int startingMinute) {
        setDay(day);
        setStartingHour(startingHour);
        setStartingMinute(startingMinute);
        setAvailable(true);

        calculateInterviewEndingTimes(startingHour, startingMinute);

    }

    private void calculateInterviewEndingTimes(int startingHour, int startingMinute) {

        int endingMinute = startingMinute + duration;
        int endingHour = startingHour;

        if (endingMinute == 60) {
            endingMinute = 0;
            endingHour = endingHour + 1;
        }

        setEndingHour(endingHour);
        setEndingMinute(endingMinute);

    }

    public int getStartingHour() {
        return startingHour;
    }

    public String getStatus() {
        return status;
    }

    private void setStatus(boolean isAvailable) {
        if (!isAvailable) {
            this.status = "Unvailable";
        } else {
            this.status = "Available";
        }
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
        setStatus(isAvailable);
    }

    public int getDuration() {
        return duration;
    }

    public int getEndingMinute() {
        return endingMinute;
    }

    public void setEndingMinute(int endingMinute) {
        this.endingMinute = endingMinute;
    }

    public int getStartingMinute() {
        return startingMinute;
    }

    public void setStartingMinute(int startingMinute) {
        this.startingMinute = startingMinute;
    }

    public int getEndingHour() {
        return endingHour;
    }

    public void setEndingHour(int endingHour) {
        this.endingHour = endingHour;
    }

    public void setStartingHour(int startingHour) {
        this.startingHour = startingHour;
    }

    public String toString() {

        String interviewSlotDetails;

        interviewSlotDetails = "Interview Details:\n";
        interviewSlotDetails += "Status: " + getStatus() + "\n";
        interviewSlotDetails += "Date: " + getDay() + "\n";
        interviewSlotDetails += "Duration: " + getDuration() + "\n";
        interviewSlotDetails += "Starting Time: " + getStartingHour() + ":" + getStartingMinute() + "\n";
        interviewSlotDetails += "Ending Time: " + getEndingHour() + ":" + getEndingMinute() + "\n";
        return interviewSlotDetails;
    }
}
