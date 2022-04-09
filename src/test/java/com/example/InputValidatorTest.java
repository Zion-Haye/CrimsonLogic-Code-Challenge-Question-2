package com.example;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class InputValidatorTest {

    @Test
    public void testValidateDayTrue() {
        assertTrue(InputValidator.validateDay("Monday"));
    }

    @Test
    public void testValidateDayFalse() {
        assertFalse(InputValidator.validateDay("June"));
    }

    @Test
    public void testValidateApplicantEmailTrue() {
        assertTrue(InputValidator.validateApplicantEmail("test@gmail.com"));
    }

    @Test
    public void testValidateApplicantEmailFalse() {
        assertFalse(InputValidator.validateApplicantEmail("test"));
    }

    @Test
    public void testValidateMinuteTrue() {
        assertTrue(InputValidator.validateMinute(30));
    }

    @Test
    public void testValidateMinuteFalse() {
        assertFalse(InputValidator.validateMinute(60));
    }

    @Test
    public void testValidateHourTrue() {
        assertTrue(InputValidator.validateHour(3));
    }

    @Test
    public void testValidateHourFalse() {
        assertFalse(InputValidator.validateHour(13));
    }

    @Test
    public void testValidateMonthTrue() {
        assertTrue(InputValidator.validateMonth("April"));
    }

    @Test
    public void testValidateMonthFalse() {
        assertFalse(InputValidator.validateMonth("Monday"));
    }

    @Test
    public void testValidateDayNumTrue() {
        assertTrue(InputValidator.validateDayNum(15));
    }

    @Test
    public void testValidateDayNumFalse() {
        assertFalse(InputValidator.validateDayNum(32));
    }

    @Test
    public void testValidateDayNumForMonthTrue() {
        assertTrue(InputValidator.validateDayNumForMonth("July", 31));
    }

    @Test
    public void testValidateDayNumForMonthFalse() {
        assertFalse(InputValidator.validateDayNumForMonth("February", 31));
    }

}
