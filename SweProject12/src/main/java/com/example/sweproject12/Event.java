package com.example.sweproject12;

import java.util.ArrayList;
import java.util.Arrays;


public class Event {

    static int eventId;
    private Account eventOrginizer;
    private Room room;
    private Reservation reservation;
    private String status; // Example statuses: "Open", "In Progress", "Cancelled"
    private int capacity;
    private ArrayList<Account> participants; // Use ArrayList for dynamic participant list

    // Constructor to initialize the event object
    public Event( Account eventOrginizer, Room room, Reservation reservation, String status, int capacity) {
        this.eventOrginizer = eventOrginizer;
        this.room = room;
        this.reservation = reservation;
        this.status = status;
        this.capacity = capacity;
        this.participants = new ArrayList<Account>(Arrays.asList(eventOrginizer)); // Initialize empty participant list
        eventId++;
    }

    // Getter methods for accessing event information
    public int getEventId() {
        return eventId;
    }

    public Account getEventOrginizer() {
        return eventOrginizer;
    }

    public Room getRoom() {
        return room;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public String getStatus() {
        return status;
    }

    public int getCapacity() {
        return capacity;
    }

    public ArrayList<Account> getParticipants() {
        return participants; // Return a copy to avoid modifying original list
    }

    // Setter methods for updating event details (with caution)
    public void setStatus(String status) {
        this.status = status;
    }

    // Method to attempt updating the event (consider specific logic)
    public boolean updateEvent() {
        // Implement logic to update the event in the system
        // This might involve modifying details, notifying participants, etc.
        System.out.println("Simulating updating event...");
        return true; // Replace with actual update logic and return status
    }

    // Method to notify the event organizer (consider notification mechanism)
    public boolean notifyOrginizer() {
        // Implement logic to send notification to the event organizer
        // This might involve email, SMS, or internal system notification
        System.out.println("Simulating notifying event organizer...");
        return true; // Replace with actual notification logic and return status
    }

    // Check if the event is full based on the number of participants
    public boolean isFull() {
        return participants.size() >= capacity;
    }

    // (Optional) Method to add a participant (consider capacity and validation)
    public boolean addParticipant(User user) {
        if (!isFull()) {
            participants.add(user);
            return true;
        }
        return false;
    }

    // (Optional) Method to remove a participant (consider validation)
    public boolean removeParticipant(User user) {
        return participants.remove(user);
    }
}