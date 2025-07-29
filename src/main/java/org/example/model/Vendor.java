package org.example.model;

public class Vendor {
    private final String mail;
    private String name;
    private String password;
    private String company_name;
    private String category;
    private int phone_num;
    private String website;
    private String payment_terms;
    private String b_country;
    private String b_address;
    private String b_city;
    private String b_state;
    private String b_zipcode;
    private String s_country;
    private String s_address;
    private String s_city;
    private String s_state;
    private String s_zipcode;
    private String GSTIN_or_VAT_or_TIN_type;
    private String GSTIN_or_VAT_or_TIN_number;
    private String PAN_number;
    private String business_lisence_number;
    private String benificiary_name;
    private String bank_name;
    private String acc_num;
    private String acc_type;
    private String routing_number;
    private String contact_person_name;
    private String cp_role;
    private String cp_phoneNum;
    private String cp_alter_phoneNum;
    private String cp_email;
    private String cp_communication_channel;
    private String status;
    private String userid;
    private String remarks;

    public Vendor(String mail, String password){
        this.mail = mail;
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


}
