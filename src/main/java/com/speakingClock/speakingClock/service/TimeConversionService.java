package com.speakingClock.speakingClock.service;

import org.springframework.stereotype.Service;

import com.speakingClock.speakingClock.exception.TimeConversionException;


@Service
public class TimeConversionService {
   
    public String convertToWords(String time) throws TimeConversionException {
        try {
            String[] parts = time.split(":");
            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
           
            String result = convertHourToWords(hours) + " " + convertMinuteToWords(minutes);
            return "It's " + result;
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            throw new TimeConversionException("Invalid time format");
        } catch (Exception e) {
            throw new TimeConversionException("An error occurred while converting time");
        }
    }
   
    public String convertHourToWords(int hours) {
        if (hours < 0 || hours > 23) {
            return "Invalid hour";
        }
       
        String[] hourWords = {
            "Midnight", "One", "Two", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten", "Eleven", "Noon", "Midnight"
        };
       
        if (hours == 0 || hours == 12) {
            return hourWords[hours];
        } else if (hours > 12) {
            return hourWords[hours - 12];
        } else {
            return hourWords[hours];
        }
    }
   
    public String convertMinuteToWords(int minutes) {
        if (minutes < 0 || minutes > 59) {
            return "Invalid minute";
        }
       
        String[] minuteWords = {
            "Zero", "One", "Two", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen",
            "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen",
            "Twenty", "Twenty-One", "Twenty-Two", "Twenty-Three", "Twenty-Four",
            "Twenty-Five", "Twenty-Six", "Twenty-Seven", "Twenty-Eight", "Twenty-Nine",
            "Thirty"
        };
       
        if (minutes <= 30) {
            return minuteWords[minutes];
        } else {
            return "Not implemented yet";
        }
    }
}

