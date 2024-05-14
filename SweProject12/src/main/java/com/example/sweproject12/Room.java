package com.example.sweproject12;

import java.util.Objects;

public class Room {

    // Declare attributes for room details
    private String roomNumber;
    private String roomType;
    private String location;
    private String gender; // Consider using an enum for better representation
    private boolean available; // Track room availability

    // Constructor to initialize the room object
    public Room(String roomNumber, String roomType, String location, String gender) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.location = location;
        this.gender = gender;
        this.available = true; // Assume room is available by default
    }

    // Getter methods for accessing room information
    public String getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getLocation() {
        return location;
    }

    public String getGender() {
        return gender;
    }

    public boolean isAvailable() {
        return available;
    }

    // Setter method to update room availability
    public void setAvailable(boolean available) {
        this.available = available;
    }

    // Method to check eligibility based on room gender restriction (optional)
    public boolean checkEligible(User user) {
        return gender.equals("Unisex") || gender.equalsIgnoreCase(user.isGender() ? "Male" : "Female");
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(roomNumber, room.roomNumber) &&
                Objects.equals(roomType, room.roomType) &&
                Objects.equals(location, room.location) &&
                Objects.equals(gender, room.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, roomType, location, gender);
    }
}