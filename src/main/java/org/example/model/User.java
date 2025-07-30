package org.example.model;

public class User {
    private String email;
    private String name;
    private String phoneNumber;
    private String role = "user";
    private String employmentId;

    // Default constructor
    public User() {}

    // Getters and Setters
    // Parameterized constructor
    public User(String email,String name){
        this.email = email;
        this.name = name;
    }
    public User(String email, String name, String phoneNumber, String role, String employmentId) {
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.employmentId = employmentId;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmploymentId() {
        return employmentId;
    }

    public void setEmploymentId(String employmentId) {
        this.employmentId = employmentId;
    }

}
