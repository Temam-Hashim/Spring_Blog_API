package com.example.blog.users;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Users {
    @Id
    @SequenceGenerator(
            name="user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private String name;
    private String email;;
    private String mobile;

    private LocalDate dob;
    @Transient
    private Integer age;

    public Users() {
    }

    public Users(String name, String email, String mobile, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.dob = dob;

    }

    public Users(Long id, String name, String email, String mobile,  LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob,LocalDate.now()).getYears();
    }


    public void setAge(Integer age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobile=" + mobile +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
