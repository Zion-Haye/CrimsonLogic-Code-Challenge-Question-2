package com.example;

import java.util.ArrayList;

public class InputValidator {

    public InputValidator() {

    }

    public static boolean validateDay(String userInput) {
        ArrayList<String> days = new ArrayList<String>();
        days.add("Sunday");
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");

        for (String day : days) {
            if (userInput.equalsIgnoreCase(day)) {
                return true;
            }
        }

        System.out.println("Invalid Day Entry.");
        return false;

    }

    public static boolean validateApplicantEmail(String applicantEmail) {
        if ((applicantEmail.contains("@")) && (applicantEmail.contains(".com"))) {
            return true;
        }
        System.out.println("Invalid Email Address.");
        return false;
    }

    public static boolean validateMinute(int minute) {
        if ((minute < 0) || (minute > 59)) {
            System.out.println("Invalid Minute Value.");
            return false;
        }

        if (minute % 15 != 0) {
            System.out.println("Invalid Minute Value For Meeting Start Time.");
            return false;
        }

        return true;

    }

    public static boolean validateHour(int hour) {
        if ((hour > 12) || (hour < 1)) {
            System.out.println("Invalid Hour Value.");
            return false;
        }

        return true;
    }

    public static boolean validateMonth(String givenMonth) {
        ArrayList<String> months = new ArrayList<String>();
        months.add("January");
        months.add("February");
        months.add("March");
        months.add("April");
        months.add("May");
        months.add("June");
        months.add("July");
        months.add("August");
        months.add("September");
        months.add("October");
        months.add("November");
        months.add("December");

        for (String month : months) {
            if (month.equalsIgnoreCase(givenMonth)) {
                return true;
            }
        }
        System.out.println("Invalid Month Value.");
        return false;
    }

    public static boolean validateDayNum(int dayNum) {
        if ((dayNum >= 1) && (dayNum <= 31)) {
            return true;
        }
        System.out.println("Invalid Day Value.");
        return false;
    }

    public static boolean validateDayNumForMonth(String month, int dayNum) {

        if ((month.equalsIgnoreCase("April")) || (month.equalsIgnoreCase("June"))
                || (month.equalsIgnoreCase("September")) || (month.equalsIgnoreCase("November"))) {
            if (dayNum > 30) {
                System.out.println("Invalid Day Value For Month Given.");
                return false;
            }
        }

        if (month.equalsIgnoreCase("February")) {
            if (dayNum > 28) {
                System.out.println("Invalid Day Value For Month Given.");
                return false;
            }
        }

        return true;
    }
}
