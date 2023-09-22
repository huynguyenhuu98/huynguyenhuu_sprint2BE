package com.example.backendsp2.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_customer")
    private String nameCustomer;
    private String birthday;
    private String image;
    private String member;
    private Integer gender;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String address;
    private String email;
    @CreationTimestamp
    @Column(name = "create_date", columnDefinition = "TIMESTAMP DEFAULT now()")
    private LocalDateTime createDate;
    @JoinColumn
    @OneToOne
    private Users users;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Customers(Long id, String nameCustomer, String birthday, String image, String member, Integer gender, String phoneNumber, String address, String email, LocalDateTime createDate, Users users) {
        this.id = id;
        this.nameCustomer = nameCustomer;
        this.birthday = birthday;
        this.image = image;
        this.member = member;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.createDate = createDate;
        this.users = users;
    }

    public Customers() {
    }

    public Customers(Long id, String nameCustomer, String birthday, Integer gender, String phoneNumber, String address, String email, LocalDateTime createDate) {
        this.id = id;
        this.nameCustomer = nameCustomer;
        this.birthday = birthday;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }
}
