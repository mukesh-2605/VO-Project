package org.example.model;

public class Admin {
    private String mail;
    private String name;
    private String employment_id ;

    public Admin(String mail, String name, String employment_id){
        this.mail = mail;
        this.name = name;
        this.employment_id=employment_id;
    }

    public Admin(String mail, String name){
        this.mail = mail;
        this.name = name;
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

    public String getEmployment_id() {
        return employment_id;
    }

    public void setEmployment_id(String employment_id) {
        this.employment_id = employment_id;
    }
}
