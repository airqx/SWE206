package com.example.sweproject12;

import java.time.LocalTime;


public class TimeSlot {

    private LocalTime startTime;
    private LocalTime endTime;

    // Constructor to initialize the time slot
    public TimeSlot(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Getter methods for accessing time slot information
    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

}