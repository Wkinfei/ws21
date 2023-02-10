package com.PAFws21.ws21.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Customer {
    private Integer id;
    private String company;
    private String lastName;
    private String firstName;
    private String emailAddress;
    private String jobTitle;
    private String businessPhone;
    private String address;
    private String city;
    private String stateProvince;

     //from SQL to object
     public static Customer fromSQL(SqlRowSet rs){
        Customer customer = new Customer();
        customer.setCustomerId(rs.getInt("id"));
        customer.setCompany(rs.getString("company"));
        customer.setLastName(rs.getString("last_name"));
        customer.setFirstName(rs.getString("first_name"));
        customer.setEmailAddress(rs.getString("email_address"));
        customer.setJobTitle(rs.getString("job_title"));
        customer.setBusinessPhone(rs.getString("business_phone"));
        customer.setAddress(rs.getString("address"));
        customer.setCity(rs.getString("city"));
        customer.setStateProvince(rs.getString("state_province"));
        return customer;
    }
    //from object to JsonObject
    public JsonObject toJsonObject() {
        return Json.createObjectBuilder()
                .add("id", getCustomerId())
                .add("company", getCompany())
                .add("last_name", getLastName())
                .add("first_name", getFirstName())
                .add("email_address",getEmailAddress()!=null ? getEmailAddress().toString() : "")
                .add("job_title",getJobTitle())
                .add("business_phone",getBusinessPhone())
                .add("address", getAddress())
                .add("city",getCity())
                .add("state_province",getStateProvince())
                .build();
    }

    public Integer getCustomerId() {
        return id;
    }
    public void setCustomerId(Integer CustomerId) {
        this.id = CustomerId;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public String getJobTitle() {
        return jobTitle;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    public String getBusinessPhone() {
        return businessPhone;
    }
    public void setBusinessPhone(String businessPhone) {
        this.businessPhone = businessPhone;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getStateProvince() {
        return stateProvince;
    }
    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    @Override
    public String toString() {
        return "Customers [id=" + id + ", company=" + company + ", lastName=" + lastName + ", firstName=" + firstName
                + ", emailAddress=" + emailAddress + ", jobTitle=" + jobTitle + ", businessPhone=" + businessPhone
                + ", address=" + address + ", city=" + city + ", stateProvince=" + stateProvince + "]";
    }

    
    
}
