package com.example.backendsp2.model;

import javax.persistence.*;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_name")
    private String userName;
    private String pass;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles roles;

    public Users() {
    }

    public Users(Long id) {
        this.id = id;
    }

    public Users(Long id, String userName, String pass, Roles roles) {
        this.id = id;
        this.userName = userName;
        this.pass = pass;
        this.roles = roles;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
