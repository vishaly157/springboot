package com.example.demo.dbmodel;


import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "emp_dtl")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "fname")
    private String fName;
    @Column(name = "lname")
    private String lName;
    private int city;
    private String email;
    private long contact;

    public Employee () {

    }

    public Employee(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }

    public int getId() {
        return id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

}
