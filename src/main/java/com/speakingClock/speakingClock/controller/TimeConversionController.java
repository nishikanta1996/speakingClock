package com.speakingClock.speakingClock.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.speakingClock.speakingClock.exception.TimeConversionException;
import com.speakingClock.speakingClock.service.TimeConversionService;

@RestController
public class TimeConversionController {

    private final TimeConversionService timeConversionService;

    public TimeConversionController(TimeConversionService timeConversionService) {
        this.timeConversionService = timeConversionService;
    }

    @GetMapping("/convert-time")
    public String convertToWords(@RequestParam String time) {
        try {
            String result = timeConversionService.convertToWords(time);
            return result;
        } catch (TimeConversionException e) {
            return "Error: " + e.getMessage();
        }
    }
}


