package com.example;

import java.util.ArrayList;

public class WeeklySchedule {
    private final int firstInterviewStartingHour = 8;
    private final int lastInterviewEndingHour = 4;
    private int lunchStartingHour;
    private int lunchEndingHour;
    private final int lunchDuration = 1;
    private ArrayList<InterviewSlot> interviewSlots;

    public WeeklySchedule() {
        interviewSlots = new ArrayList<InterviewSlot>();
        initialiseWeeklySchedule();
    }

    public int getLastInterviewEndingHour() {
        return lastInterviewEndingHour;
    }

    public int getFirstInterviewStartingHour() {
        return firstInterviewStartingHour;
    }

    public int getLunchDuration() {
        return lunchDuration;
    }

    public int getLunchEndingHour() {
        return lunchEndingHour;
    }

    public void setLunchEndingHour(int lunchEndingHour) {
        this.lunchEndingHour = lunchEndingHour;
    }

    public int getLunchStartingHour() {
        return lunchStartingHour;
    }

    public InterviewSlot getInterviewSlot(String day, int startingHour, int startingMinute) {
        for (InterviewSlot interviewSlot : interviewSlots) {
            if ((interviewSlot.getDay().equalsIgnoreCase(day)) && (interviewSlot.getStartingHour() == startingHour)
                    && (interviewSlot.getStartingMinute() == startingMinute)) {
                return interviewSlot;
            }
        }
        return null;
    }

    public void viewScheduleByDay(String day) {
        if (!interviewSlots.isEmpty()) {
            for (InterviewSlot interviewSlot : interviewSlots) {
                if (interviewSlot.getDay().equalsIgnoreCase(day)) {
                    System.out.println(interviewSlot.toString());
                }
            }
        } else {
            System.out.println("There is no schedule for this office on this day.");
        }
    }

    public void viewSchedule() {
        if (!interviewSlots.isEmpty()) {
            for (InterviewSlot interviewSlot : interviewSlots) {
                System.out.println(interviewSlot.toString());
            }
        } else {
            System.out.println("There is no schedule for this office.");
        }
    }

    // Populate Schedule
    private void initialiseWeeklySchedule() {
        setLunchStartingHour(12);
        setAvailableInterviewSlotsByHourRange("Monday", 8, 10);
        setAvailableInterviewSlotsByHourRange("Tuesday", 9, 11);
        setAvailableInterviewSlotsByHourRange("Wednesday", 10, 12);
        setAvailableInterviewSlotsByHourRange("Thursday", 11, 2);
        setAvailableInterviewSlotsByHourRange("Friday", 12, 4);
    }

    private void setLunchStartingHour(int lunchStartingHour) {
        this.lunchStartingHour = lunchStartingHour;
        calculateLunchEndingHour(lunchStartingHour);
    }

    private void calculateLunchEndingHour(int lunchStartingHour) {
        this.lunchEndingHour = lunchStartingHour + lunchDuration;

    }

    private void setAvailableInterviewSlotsByHourRange(String date, int startingHour, int endingHour) {
        int currentMeetingStartingHour = startingHour;
        int currentMeetingStartingMinute = 0;

        InterviewSlot interviewSlot = null;

        while (currentMeetingStartingHour != endingHour) {

            if (currentMeetingStartingHour != lunchStartingHour) {
                interviewSlot = getInterviewSlot(date, currentMeetingStartingHour, currentMeetingStartingMinute);
                if (interviewSlot == null) {
                    interviewSlots
                            .add(new InterviewSlot(date, currentMeetingStartingHour, currentMeetingStartingMinute));
                } else {
                    interviewSlot.setAvailable(true);
                }
            }

            currentMeetingStartingMinute = currentMeetingStartingMinute + 15;

            if (currentMeetingStartingMinute == 60) {
                currentMeetingStartingMinute = 0;
                currentMeetingStartingHour = currentMeetingStartingHour + 1;
            }

            if (currentMeetingStartingHour == 13) {
                currentMeetingStartingHour = 1;
            }

        }

    }
}
