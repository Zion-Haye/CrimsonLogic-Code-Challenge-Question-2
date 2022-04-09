package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class AppointmentTest {

    Appointment appointment = new Appointment("West", "April", "Monday", 8, 10, 15, "test@gmail.com");

    @Test
    public void testAppointmentInstantiation() {
        assertNotNull(appointment);
    }

    @Test
    public void testGetOfficeLocation() {
        assertEquals("West", appointment.getOfficeLocation());
    }

    @Test
    public void testGetMonth() {
        assertEquals("April", appointment.getMonth());
    }

    @Test
    public void testGetDay() {
        assertEquals("Monday", appointment.getDay());
    }

    @Test
    public void testGetDateNum() {
        assertEquals(8, appointment.getDateNum());
    }

    @Test
    public void testGetStartingHour() {
        assertEquals(10, appointment.getStartingHour());
    }

    @Test
    public void testGetStartingMinute() {
        assertEquals(15, appointment.getStartingMinute());
    }

    @Test
    public void testGetEmailAddress() {
        assertEquals("test@gmail.com", appointment.getEmailAddress());
    }

    @Test
    public void testGetEndingHour() {
        assertEquals(10, appointment.getEndingHour());
    }

    @Test
    public void testGetEndMinute() {
        assertEquals(30, appointment.getEndingMinute());
    }

}
