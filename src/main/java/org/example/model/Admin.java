package org.example.model;

public class Admin {
    private String mail;
    private String name;
    private int employment_id;
    private String phone_num;

    public Admin(String mail, String name, int employment_id, String phone_num){
        this.mail = mail;
        this.name = name;
        this.employment_id=employment_id;
        this.phone_num = phone_num;
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

    public int getEmployment_id() {
        return employment_id;
    }

    public void setEmployment_id(int employment_id) {
        this.employment_id = employment_id;
    }

    public String getPhoneNum() {
        return phone_num;
    }

    public void setPhoneNum(String phone_num) {
        this.phone_num = phone_num;
    }
}
