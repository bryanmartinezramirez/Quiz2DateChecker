package com.example;

import com.example.DateChecker.Month;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class DateCheckerTest {

    DateChecker dateChecker = new DateChecker();

    @Test
    public void testJanuary() {
        boolean actual = dateChecker.has31Days(Month.JANUARY);

        assertTrue(actual, "January should have 31 days");
    }

    @Test
    public void testApril() {
        boolean actual = dateChecker.has31Days(Month.APRIL);

        assertFalse(actual, "April should have 30 days");
    }
}