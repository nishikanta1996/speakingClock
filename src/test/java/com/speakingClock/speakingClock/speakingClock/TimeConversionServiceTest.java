package com.speakingClock.speakingClock.speakingClock;


import org.junit.Before;
import org.junit.Test;

import com.speakingClock.speakingClock.exception.TimeConversionException;
import com.speakingClock.speakingClock.service.TimeConversionService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TimeConversionServiceTest {

    private TimeConversionService timeConversionService;

    @Before
    public void setUp() {
        timeConversionService = new TimeConversionService();
    }

    @Test
    public void testConvertToWordsValidTime() {
        try {
            String result = timeConversionService.convertToWords("12:30");
            assertEquals("It's Noon Thirty", result);
        } catch (TimeConversionException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void testConvertToWordsMidnight() {
        try {
            String result = timeConversionService.convertToWords("00:00");
            assertEquals("It's Midnight", result);
        } catch (TimeConversionException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void testConvertToWordsNoon() {
        try {
            String result = timeConversionService.convertToWords("12:00");
            assertEquals("It's Noon", result);
        } catch (TimeConversionException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test(expected = TimeConversionException.class)
    public void testConvertToWordsInvalidTimeFormat() throws TimeConversionException {
        timeConversionService.convertToWords("12-30");
    }

    @Test(expected = TimeConversionException.class)
    public void testConvertToWordsInvalidHour() throws TimeConversionException {
        timeConversionService.convertToWords("25:30");
    }

    @Test(expected = TimeConversionException.class)
    public void testConvertToWordsInvalidMinute() throws TimeConversionException {
        timeConversionService.convertToWords("12:70");
    }

    @Test
    public void testConvertHourToWords() {
        String result = timeConversionService.convertHourToWords(8);
        assertEquals("Eight", result);
    }

    @Test
    public void testConvertMinuteToWords() {
        String result = timeConversionService.convertMinuteToWords(15);
        assertEquals("Fifteen", result);
    }
}

