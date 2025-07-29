package org.example.model;

public class Vendor {
    private final String mail;
    private String name;
    private String password;
    String role = "admin";

    public Vendor(String mail, String password, String role){
        this.mail = mail;
        this.password = password;
        this.role = role;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }
}
