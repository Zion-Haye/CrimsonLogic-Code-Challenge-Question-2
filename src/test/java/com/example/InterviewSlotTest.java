package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class InterviewSlotTest {

    InterviewSlot interviewSlot = new InterviewSlot("Monday", 10, 15);

    @Test
    public void testInterviewSlotInstantiation() {
        assertNotNull(interviewSlot);
    }

    @Test
    public void testGetDay() {
        assertEquals("Monday", interviewSlot.getDay());
    }

    @Test
    public void testGetStartingHour() {
        assertEquals(10, interviewSlot.getStartingHour());
    }

    @Test
    public void testGetStartingMinute() {
        assertEquals(15, interviewSlot.getStartingMinute());
    }

    @Test
    public void testGetEndingHour() {
        assertEquals(10, interviewSlot.getEndingHour());
    }

    @Test
    public void testGetEndMinute() {
        assertEquals(30, interviewSlot.getEndingMinute());
    }

    @Test
    public void testGetStatus() {
        assertEquals("Available", interviewSlot.getStatus());
    }

}
