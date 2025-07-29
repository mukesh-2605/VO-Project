package org.example.model;

public class Admin {
    private final String mail;
    private String name;
    private String password;
    String role = "admin";
    private String employement_id ;

    public Admin(String mail, String name, String password, String role,String employement_id){
        this.mail = mail;
        this.name = name;
        this.password = password;
        this.role = role;
        this.employement_id=employement_id;
    }

    public Admin(String mail, String name, String password){
        this.mail = mail;
        this.name = name;
        this.password = password;
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
