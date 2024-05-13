package com.example.sweproject12;

import com.example.sweproject12.User;

public class AdvancedUser extends User {

    public AdvancedUser(String id, String email, String password, boolean gender, String type) throws Exception {
        super(id, email, password, gender); // Call parent constructor
    }

    // Methods specific to advanced user functionality

    public boolean reserveClassroom(Room room) {
        // Implement logic to reserve a classroom (check eligibility, room type, etc.)
        if (room.getRoomType().equals("Classroom")) {
            // Simulate classroom reservation for advanced user
            System.out.println("Simulating classroom reservation for advanced user...");
            return true; // Replace with actual reservation logic and return status
        } else {
            System.out.println("Advanced user cannot reserve non-classroom rooms.");
            return false;
        }
    }

    public boolean reserveLab(Room room) {
        // Implement logic to reserve a lab (check eligibility, room type, etc.)
        if (room.getRoomType().equals("Lab")) {
            // Simulate lab reservation for advanced user
            System.out.println("Simulating lab reservation for advanced user...");
            return true; // Replace with actual reservation logic and return status
        } else {
            System.out.println("Advanced user cannot reserve non-lab rooms.");
            return false;
        }
    }
}