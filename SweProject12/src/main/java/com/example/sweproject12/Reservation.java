package com.example.sweproject12;

import java.time.LocalDate;

public class Reservation {

    private Account reserver;
    private Room room;
    private String reason;
    private LocalDate date;
    private String status;
    private String time;

    // Constructor to initialize the reservation object
    public Reservation(Account reserver, Room room, LocalDate date, String status, String time) {
        this.reserver = reserver;
        this.room = room;
        this.date = date;
        this.status = status; // Example statuses: "Pending", "Confirmed", "Cancelled"
        this.time = time;
    }

    public Reservation() {

    }

    // Getter methods for accessing reservation information
    public Account getReserver() {
        return reserver;
    }

    public Room getRoom() {
        return room;
    }

    public String getReason() {
        return reason;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public String getTime() {
        return time;
    }

    // Setter methods for updating reservation details (with caution)
    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Method to attempt updating the reservation (consider specific logic)
    public boolean updateReservation() {
        // Implement logic to update the reservation in the system
        // This might involve checking availability, updating status, etc.
        System.out.println("Simulating updating reservation...");
        return true; // Replace with actual update logic and return status
    }
}