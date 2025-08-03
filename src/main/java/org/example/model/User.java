package org.example.model;

public class User {
    private String email;
    private String name;
    private String phoneNumber;
    private final static String role = "user";
    private int employmentId;
    private int reportTo;

    // Default constructor
    public User() {}

    // Getters and Setters
    // Parameterized constructor
    public User(String email,String name){
        this.email = email;
        this.name = name;
    }

    public User(int emp_id, String email,String name){
        this.employmentId = emp_id;
        this.email = email;
        this.name = name;
    }

    public User(String email, String name, String phoneNumber, String role, int employmentId) {
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
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

    public int getReportTo() { return reportTo; }

    public void setReportTo(int reportTo) { this.reportTo = reportTo; }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public int getEmploymentId() {
        return employmentId;
    }

    public void setEmploymentId(int employmentId) {
        this.employmentId = employmentId;
    }

}
