package com.example;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class AppointmentSystemApplication {
    public static void main(String[] args) {

        Applicant applicant = getApplicantDetails();

        if (applicant != null) {
            AppointmentSystem appointmentSystem = new AppointmentSystem();

            Scanner input = new Scanner(System.in);
            String userInput = "";

            while (!userInput.equals("X")) {

                displayMainMenu();
                userInput = input.nextLine();

                switch (userInput) {
                    case "":
                        break;
                    case "1":
                        viewOfficeLocations(appointmentSystem);
                        break;
                    case "2":
                        viewOfficeSchedule(appointmentSystem);
                        break;
                    case "3":
                        viewOfficeScheduleByDay(appointmentSystem);
                        break;
                    case "4":
                        makeAppointment(appointmentSystem, applicant);
                        break;
                    case "5":
                        reschudleActiveAppointment(appointmentSystem, applicant);
                        break;
                    case "6":
                        cancelActiveAppointment(appointmentSystem, applicant);
                        break;
                    case "7":
                        viewActiveAppointment(applicant);
                        break;
                    case "X":
                        break;
                    default:
                        System.out.println("Invalid Entry\n");
                        break;
                }

            }
        }
        System.out.println("System Terminated\n");
    }

    public static Applicant getApplicantDetails() {
        String applicantEmailAddress;
        boolean isValidEmail = false;

        Scanner input = new Scanner(System.in);
        String userInput = "";

        while (!isValidEmail) {
            System.out.println("Please enter a valid email Address or enter X to Exit:");
            userInput = input.nextLine();

            if (userInput.equals("X")) {
                return null;
            }
            isValidEmail = InputValidator.validateApplicantEmail(userInput);
        }

        return new Applicant(userInput);
    }

    public static void displayMainMenu() {
        System.out.println("Welcome to CrimsonLogic's Appointment System\n");
        System.out.println("Please select an option:");
        System.out.println("1 - View Office Locations");
        System.out.println("2 - View Office Weekly Schedule");
        System.out.println("3 - View Office Weekly Schedule For a Particular Day");
        System.out.println("4 - Make Appointment");
        System.out.println("5 - Reschedule Appointment");
        System.out.println("6 - Cancel Appointment");
        System.out.println("7 - View Active Appointment");
        System.out.println("X - Exit Appointment System");
        System.out.println("Enter Option:");

    }

    public static void viewOfficeLocations(AppointmentSystem appointmentSystem) {
        System.out.println(appointmentSystem.viewListOfOffices());
    }

    public static void viewOfficeSchedule(AppointmentSystem appointmentSystem) {
        Scanner input = new Scanner(System.in);
        String userInput;

        System.out.println("Please enter the office:");
        userInput = input.nextLine();

        if (appointmentSystem.getOffice(userInput) != null) {
            appointmentSystem.getOffice(userInput).viewSchedule();
        } else {
            System.out.println("Office Not Found.");
        }
    }

    public static void viewOfficeScheduleByDay(AppointmentSystem appointmentSystem) {
        Scanner input = new Scanner(System.in);
        String office, day;

        System.out.println("Please enter the office:");
        office = input.nextLine();

        if (appointmentSystem.getOffice(office) != null) {
            System.out.println("Please enter Day:");
            day = input.nextLine();
            if (InputValidator.validateDay(day)) {
                appointmentSystem.getOffice(office).viewScheduleByDay(day);
            }
        } else {
            System.out.println("Office Not Found.");
        }
    }

    public static void makeAppointment(AppointmentSystem appointmentSystem, Applicant applicant) {
        Scanner input = new Scanner(System.in);
        String officeLocation, month, day, emailAddress;
        int startingHour, startingMinute, dayNum;

        if (applicant.getAppointment() == null) {

            System.out.println("Please enter the office:");
            officeLocation = input.nextLine();

            Office office = appointmentSystem.getOffice(officeLocation);
            if (office != null) {
                System.out.println("Please enter the Month (e.g April):");
                month = input.nextLine();

                if (InputValidator.validateMonth(month)) {
                    System.out.println("Please enter the Day Number (e.g. 7):");

                    try {
                        dayNum = input.nextInt();

                        if ((InputValidator.validateDayNum(dayNum))
                                && InputValidator.validateDayNumForMonth(month, dayNum)) {
                            System.out.println("Please enter the Meeting Starting Hour:");

                            try {
                                startingHour = input.nextInt();

                                if (InputValidator.validateHour(startingHour)) {
                                    System.out.println("Please enter the Meeting Starting Minute:");

                                    try {
                                        startingMinute = input.nextInt();

                                        if (InputValidator.validateMinute(startingMinute)) {
                                            // place code here
                                            day = getDayFromDate(dayNum, month);
                                            emailAddress = applicant.getEmailAddress();
                                            applicant.setAppointment(office.makeAppointment(officeLocation, month, day,
                                                    dayNum, startingHour, startingMinute, emailAddress));

                                        }
                                    } catch (Exception e) {
                                        System.out.println("Invalid Minute Value.");
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println("Invalid Hour Value.");
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid Day Number Value.");
                    }
                }
            } else {
                System.out.println("Office Not Found.");
            }

        } else {
            reschudleActiveAppointment(appointmentSystem, applicant);
        }
    }

    public static void reschudleActiveAppointment(AppointmentSystem appointmentSystem, Applicant applicant) {
        Scanner input = new Scanner(System.in);
        String officeLocation, month, day, emailAddress;
        int startingHour, startingMinute, dayNum;

        Appointment newAppointment = null;
        Appointment currentAppointment = applicant.getAppointment();

        if (currentAppointment != null) {
            System.out.println("Reschedule Appointment:\n");
            System.out.println("Current Appointment:\n");
            System.out.println(currentAppointment.toString());

            System.out.println("Please enter the office:");
            officeLocation = input.nextLine();

            Office office = appointmentSystem.getOffice(officeLocation);
            if (office != null) {
                System.out.println("Please enter the Month (e.g April):");
                month = input.nextLine();

                if (InputValidator.validateMonth(month)) {
                    System.out.println("Please enter the Day Number (e.g. 7):");

                    try {
                        dayNum = input.nextInt();

                        if ((InputValidator.validateDayNum(dayNum))
                                && InputValidator.validateDayNumForMonth(month, dayNum)) {
                            System.out.println("Please enter the Meeting Starting Hour:");

                            try {
                                startingHour = input.nextInt();

                                if (InputValidator.validateHour(startingHour)) {
                                    System.out.println("Please enter the Meeting Starting Minute:");

                                    try {
                                        startingMinute = input.nextInt();
                                        // startingMinute = getNearestMeetingMinute(startingMinute);

                                        if (InputValidator.validateMinute(startingMinute)) {
                                            // place code here
                                            day = getDayFromDate(dayNum, month);
                                            emailAddress = applicant.getEmailAddress();
                                            newAppointment = office.makeAppointment(officeLocation, month, day, dayNum,
                                                    startingHour, startingMinute, emailAddress);

                                            if (newAppointment != null) {
                                                officeLocation = currentAppointment.getOfficeLocation();

                                                office = appointmentSystem.getOffice(officeLocation);

                                                if (office.cancelAppointment(currentAppointment)) {
                                                    applicant.setAppointment(newAppointment);
                                                }
                                            }

                                        }
                                    } catch (Exception e) {
                                        System.out.println("Invalid Minute Value..");
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println("Invalid Hour Value.");
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid Day Number Value.");
                    }
                }
            } else {
                System.out.println("Office Not Found.");
            }

        } else {
            System.out.println("There are no appointments to reschedule");
        }
    }

    public static void cancelActiveAppointment(AppointmentSystem appointmentSystem, Applicant applicant) {
        Appointment appointment = applicant.getAppointment();
        String officeLocation;
        Office office;

        if (applicant != null) {
            System.out.println("The following appointment has been cancelled:\n");
            System.out.println(appointment.toString());

            officeLocation = appointment.getOfficeLocation();
            office = appointmentSystem.getOffice(officeLocation);

            if (office.cancelAppointment(appointment)) {
                applicant.setAppointment(null);
            }

        } else {
            System.out.println("There are no active appointments.");
        }
    }

    public static void viewActiveAppointment(Applicant applicant) {
        if (applicant.getAppointment() != null) {
            System.out.println(applicant.getAppointment().toString());
        } else {
            System.out.println("There are no active appointments.");
        }
    }

    public static String getDayFromDate(int dateNum, String givenMonth) {
        int monthIndex = 0;

        if (givenMonth.equalsIgnoreCase("January")) {
            monthIndex = 1;
        }
        if (givenMonth.equalsIgnoreCase("February")) {
            monthIndex = 2;
        }
        if (givenMonth.equalsIgnoreCase("March")) {
            monthIndex = 3;
        }
        if (givenMonth.equalsIgnoreCase("April")) {
            monthIndex = 4;
        }
        if (givenMonth.equalsIgnoreCase("May")) {
            monthIndex = 5;
        }
        if (givenMonth.equalsIgnoreCase("June")) {
            monthIndex = 6;
        }
        if (givenMonth.equalsIgnoreCase("July")) {
            monthIndex = 7;
        }
        if (givenMonth.equalsIgnoreCase("August")) {
            monthIndex = 8;
        }
        if (givenMonth.equalsIgnoreCase("September")) {
            monthIndex = 9;
        }
        if (givenMonth.equalsIgnoreCase("October")) {
            monthIndex = 10;
        }
        if (givenMonth.equalsIgnoreCase("November")) {
            monthIndex = 11;
        }
        if (givenMonth.equalsIgnoreCase("December")) {
            monthIndex = 12;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.set(2022, monthIndex - 1, dateNum);
        int day = calendar.get(calendar.DAY_OF_WEEK);

        String[] days = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" };
        int dayIndex = calendar.get(calendar.DAY_OF_WEEK);
        return days[dayIndex - 1];
    }

}
