package com.seleniumeasy.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String eMail;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "website_or_domain_name")
    private String websiteOrDomainName;

    @Column(name = "hosting")
    private String hosting;

    @Column(name = "project_description")
    private String projectDescription;

    public Customer() {
    }

    public Customer(String firstName,
                    String lastName,
                    String eMail,
                    String phone,
                    String address,
                    String city,
                    String state,
                    String zipCode,
                    String websiteOrDomainName,
                    String hosting,
                    String projectDescription) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.websiteOrDomainName = websiteOrDomainName;
        this.hosting = hosting;
        this.projectDescription = projectDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getWebsiteOrDomainName() {
        return websiteOrDomainName;
    }

    public void setWebsiteOrDomainName(String websiteOrDomainName) {
        this.websiteOrDomainName = websiteOrDomainName;
    }

    public String getHosting() {
        return hosting;
    }

    public void setHosting(String hosting) {
        this.hosting = hosting;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", email=" + eMail +
                ", phone=" + phone +
                ", address=" + address +
                ", city=" + city +
                ", state=" + state +
                ", zipCode=" + zipCode +
                ", websiteOrDomainName=" + websiteOrDomainName +
                ", hosting=" + hosting +
                ", projectDescription=" + projectDescription + "]";
    }
}
