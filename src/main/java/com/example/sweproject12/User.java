package com.example.sweproject12;

import com.example.sweproject12.Account;

import java.util.ArrayList;

public class User extends Account {

    private ArrayList<Reservation> myReservations;
    private ArrayList<Event> myEvents;

    public User(String id, String email, String password, boolean gender, String type) throws Exception {
        super(id, email, password, gender, type);
        myReservations = new ArrayList<Reservation>();
        myEvents = new ArrayList<Event>();
    }

    // Accessor methods for reservations and events (optional)
    public ArrayList<Reservation> getMyReservations() {
        return myReservations;
    }

    public ArrayList<Event> getMyEvents() {
        return myEvents;
    }

    // Additional methods specific to user functionality

    public boolean reserveFacility(Room room) {
        // Implement logic to reserve a room (check availability, store reservation)
        System.out.println("Simulating reserving a room...");
        return true; // Replace with actual reservation logic and return status
    }

    public boolean openEvent(Room room) {
        // Implement logic to create and open a new event in a room
        System.out.println("Simulating opening a new event...");
        return true; // Replace with actual event creation logic and return status
    }

    public boolean modifyEvent() {
        // Implement logic to modify an existing event (details, participants, etc.)
        System.out.println("Simulating modifying an event...");
        return true; // Replace with actual event modification logic and return status
    }

    public boolean joinEvent(Room room) {
        // Implement logic to join an existing event in a room
        System.out.println("Simulating joining an event...");
        return true; // Replace with actual event joining logic and return status
    }

    public boolean quitEvent() {
        // Implement logic to leave an event the user has joined
        System.out.println("Simulating quitting an event...");
        return true; // Replace with actual event quitting logic and return status
    }

    public boolean modifyReservation(String reason) {
        // Implement logic to modify an existing reservation (dates, times, etc.)
        System.out.println("Simulating modifying a reservation...");
        return true; // Replace with actual reservation modification logic and return status
    }

    public ArrayList<Room> displayAllAvailableRooms() {
        // Implement logic to retrieve a list of all available rooms
        // This might involve accessing a room management system or database
        System.out.println("Simulating retrieval of all available rooms...");
        return new ArrayList<Room>(); // Replace with actual retrieval logic
    }

    public ArrayList<Event> displayAllEvents() {
        // Implement logic to retrieve a list of all events (user might be interested)
        // This might involve filtering based on user preferences or subscriptions
        System.out.println("Simulating retrieval of all events...");
        return new ArrayList<Event>(); // Replace with actual retrieval logic
    }
}