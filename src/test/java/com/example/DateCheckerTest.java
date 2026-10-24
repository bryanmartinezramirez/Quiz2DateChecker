package com.example;

import com.example.DateChecker.Month;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DateCheckerTest {

    DateChecker dateChecker = new DateChecker();

    @ParameterizedTest(name = "{0} has 31 days")
    @EnumSource(value = Month.class, names = {
        "JANUARY",
        "MARCH",
        "MAY",
        "JULY",
        "AUGUST",
        "OCTOBER",
        "DECEMBER"
    })
    public void testMonthsWith31Days(Month month) {
        boolean actual = dateChecker.has31Days(month);

        assertTrue(actual, month + " should have 31 days");
    }

    @ParameterizedTest(name = "{0} has 30 days")
    @EnumSource(value = Month.class, names = {
        "APRIL",
        "JUNE",
        "SEPTEMBER",
        "NOVEMBER"
    })
    public void testMonthsWith30Days(Month month) {
        boolean actual = dateChecker.has31Days(month);

        assertFalse(actual, month + " should have 30 days");
    }

    @Test
    public void testFebruary() {
        boolean actual = dateChecker.has31Days(Month.FEBRUARY);

        assertFalse(
            actual,
            "February has 28 or 29 days, never 31"
        );
    }

    @Test
    public void testNullMonth() {
        assertThrows(
            IllegalArgumentException.class,
            () -> dateChecker.has31Days(null),
            "A null month must be rejected"
        );
    }
}