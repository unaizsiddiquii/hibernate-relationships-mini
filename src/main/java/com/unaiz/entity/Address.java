package com.unaiz.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String city;
    private String state;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;


    public Address() {
    }

    public Address(String city, String state) {
        this.city = city;
        this.state = state;
    }

    // Getters & Setters
    public int getId() {
        return id;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Address [id=" + id + ", city=" + city + ", state=" + state + "]";
    }

}
