package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "\"users\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String last_name;

    @Column(name = "age")
    private int age;

    private String token;


    @Column(name = "password")
    private String password;


    @Column(name = "ci")
    private String ci;

    @Column(name = "phone")
    private String phone;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User(String name, String last_name, int age, String ci, String phone) {
        this.name = name;
        this.last_name = last_name;
        this.age = age;
        this.ci = ci;
        this.phone = phone;
    }

    public User(String name, String token, String password) {
        this.name = name;
        this.token = token;
        this.password = password;
    }

    public User() {

    }
}
