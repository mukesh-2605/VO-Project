package org.example.model;

public class Admin {
    private String mail;
    private String name;
    private String password;
    String role = "admin";
    private String employment_id ;

    public Admin(String mail, String name, String password, String role,String employment_id){
        this.mail = mail;
        this.name = name;
        this.password = password;
        this.role = role;
        this.employment_id=employment_id;
    }

    public Admin(String mail, String name, String password){
        this.mail = mail;
        this.name = name;
        this.password = password;
    }

    public Admin() {
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    public void setEmail(String mail){
        this.mail = mail;
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

    public String getEmployment_id() {
        return employment_id;
    }

    public void setEmployment_id(String employment_id) {
        this.employment_id = employment_id;
    }
}
