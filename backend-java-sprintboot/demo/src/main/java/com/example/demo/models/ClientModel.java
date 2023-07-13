package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "client")
public class ClientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String names;

    @Column(nullable = false)
    private String last_names;

    @Column(nullable = false)
    private String dni;
    private String phone;
    private String email;

    public ClientModel() {
    }

    public ClientModel(Long id, String names, String last_names, String dni, String phone, String email) {
        this.id = id;
        this.names = names;
        this.last_names = last_names;
        this.dni = dni;
        this.phone = phone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLast_names() {
        return last_names;
    }

    public void setLast_names(String last_names) {
        this.last_names = last_names;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
