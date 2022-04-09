package com.example;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class ApplicantTest {

    Applicant applicant = new Applicant("test@gmail.com");

    @Test
    public void testApplicantInstantiation() {
        assertNotNull(applicant);
    }

    @Test
    public void getEmailAddress() {
        assertNotNull("test@gmail.com", applicant.getEmailAddress());
    }

    @Test
    public void getAppointment() {
        assertNull(applicant.getAppointment());
    }

}
