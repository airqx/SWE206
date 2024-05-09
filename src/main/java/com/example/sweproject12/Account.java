package com.example.sweproject12;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;

public class Account {

    // Declare attributes with proper access modifiers
    private final String id;
    private String email;
    private String password;
    private boolean gender;
    private String type;
    private boolean loggedIn; // Track login status

    // Constructor to initialize the account object
    public Account(String id, String email, String password, boolean gender, String type) throws Exception {
        this.id = id;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.type = type;
        this.loggedIn = false; // Initially not logged in
        byte[] passwordHash = hashPassword(password);
    }

    // Getter methods for accessing account information
    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        // Don't return actual password for security reasons
        return "***";
    }

    public boolean isGender() {
        return gender;
    }

    public String getType() {
        return type;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    // Login method to attempt authentication
    public boolean logIn(String attemptedPassword) {
        if (attemptedPassword.equals(password)) {
            loggedIn = true;
            return true;
        }
        return false;
    }

    // Logout method to reset login status
    public boolean logOut() {
        if (loggedIn) {
            loggedIn = false;
            return true;
            // LogOut Successful
        }
        return false;
    }

    // Verify password for potential security checks
    public boolean verifyPassword(String attemptedPassword) {
        return attemptedPassword.equals(password);
    }
    //secure password comparison method

    private byte[] hashPassword(String password) throws Exception {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16]; // Adjust salt size as needed
        random.nextBytes(salt);
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 256); // Adjust iterations and key length as needed
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] hash = factory.generateSecret(spec).getEncoded();
        byte[] hashAndSalt = new byte[salt.length + hash.length];
        System.arraycopy(salt, 0, hashAndSalt, 0, salt.length);
        System.arraycopy(hash, 0, hashAndSalt, salt.length, hash.length);
        return Base64.getEncoder().encode(hashAndSalt); // Encode for storage

    }
}
