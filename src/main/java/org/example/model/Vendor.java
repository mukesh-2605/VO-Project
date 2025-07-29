package org.example.model;

public class Vendor {
    private final String mail;
    private String name;
    private String password;
    private String company_name;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCp_communication_channel() {
        return cp_communication_channel;
    }

    public void setCp_communication_channel(String cp_communication_channel) {
        this.cp_communication_channel = cp_communication_channel;
    }

    public String getCp_email() {
        return cp_email;
    }

    public void setCp_email(String cp_email) {
        this.cp_email = cp_email;
    }

    public String getCp_alter_phoneNum() {
        return cp_alter_phoneNum;
    }

    public void setCp_alter_phoneNum(String cp_alter_phoneNum) {
        this.cp_alter_phoneNum = cp_alter_phoneNum;
    }

    public String getCp_phoneNum() {
        return cp_phoneNum;
    }

    public void setCp_phoneNum(String cp_phoneNum) {
        this.cp_phoneNum = cp_phoneNum;
    }

    public String getCp_role() {
        return cp_role;
    }

    public void setCp_role(String cp_role) {
        this.cp_role = cp_role;
    }

    public String getContact_person_name() {
        return contact_person_name;
    }

    public void setContact_person_name(String contact_person_name) {
        this.contact_person_name = contact_person_name;
    }

    public String getRouting_number() {
        return routing_number;
    }

    public void setRouting_number(String routing_number) {
        this.routing_number = routing_number;
    }

    public String getAcc_type() {
        return acc_type;
    }

    public void setAcc_type(String acc_type) {
        this.acc_type = acc_type;
    }

    public String getAcc_num() {
        return acc_num;
    }

    public void setAcc_num(String acc_num) {
        this.acc_num = acc_num;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getBenificiary_name() {
        return benificiary_name;
    }

    public void setBenificiary_name(String benificiary_name) {
        this.benificiary_name = benificiary_name;
    }

    public String getBusiness_lisence_number() {
        return business_lisence_number;
    }

    public void setBusiness_lisence_number(String business_lisence_number) {
        this.business_lisence_number = business_lisence_number;
    }

    public String getPAN_number() {
        return PAN_number;
    }

    public void setPAN_number(String PAN_number) {
        this.PAN_number = PAN_number;
    }

    public String getGSTIN_or_VAT_or_TIN_number() {
        return GSTIN_or_VAT_or_TIN_number;
    }

    public void setGSTIN_or_VAT_or_TIN_number(String GSTIN_or_VAT_or_TIN_number) {
        this.GSTIN_or_VAT_or_TIN_number = GSTIN_or_VAT_or_TIN_number;
    }

    public String getGSTIN_or_VAT_or_TIN_type() {
        return GSTIN_or_VAT_or_TIN_type;
    }

    public void setGSTIN_or_VAT_or_TIN_type(String GSTIN_or_VAT_or_TIN_type) {
        this.GSTIN_or_VAT_or_TIN_type = GSTIN_or_VAT_or_TIN_type;
    }

    public String getS_zipcode() {
        return s_zipcode;
    }

    public void setS_zipcode(String s_zipcode) {
        this.s_zipcode = s_zipcode;
    }

    public String getS_state() {
        return s_state;
    }

    public void setS_state(String s_state) {
        this.s_state = s_state;
    }

    public String getS_city() {
        return s_city;
    }

    public void setS_city(String s_city) {
        this.s_city = s_city;
    }

    public String getS_address() {
        return s_address;
    }

    public void setS_address(String s_address) {
        this.s_address = s_address;
    }

    public String getS_country() {
        return s_country;
    }

    public void setS_country(String s_country) {
        this.s_country = s_country;
    }

    public String getB_zipcode() {
        return b_zipcode;
    }

    public void setB_zipcode(String b_zipcode) {
        this.b_zipcode = b_zipcode;
    }

    public String getB_state() {
        return b_state;
    }

    public void setB_state(String b_state) {
        this.b_state = b_state;
    }

    public String getB_city() {
        return b_city;
    }

    public void setB_city(String b_city) {
        this.b_city = b_city;
    }

    public String getB_address() {
        return b_address;
    }

    public void setB_address(String b_address) {
        this.b_address = b_address;
    }

    public String getB_country() {
        return b_country;
    }

    public void setB_country(String b_country) {
        this.b_country = b_country;
    }

    public String getPayment_terms() {
        return payment_terms;
    }

    public void setPayment_terms(String payment_terms) {
        this.payment_terms = payment_terms;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public int getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(int phone_num) {
        this.phone_num = phone_num;
    }

    public void setCompany_name(String company_name){
        this.company_name = company_name;
    }
    public String getCompany_name(){
        return company_name;
    }

}
