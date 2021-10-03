package com.indiana.models;

import javax.persistence.*;

@Entity
@Table(name = "user_details")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private String phone;

    private String description;

    @Lob
    private byte[] imageProfile;

    private String placeOfLiving;


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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImageProfile() {
        return imageProfile;
    }

    public void setImageProfile(byte[] imageProfile) {
        this.imageProfile = imageProfile;
    }

    public String getPlaceOfLiving() {
        return placeOfLiving;
    }

    public void setPlaceOfLiving(String placeOfLiving) {
        this.placeOfLiving = placeOfLiving;
    }

    public UserDetails() {
    }

    public UserDetails(String name, String surname, String phone, String description, byte[] imageProfile, String placeOfLiving) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.description = description;
        this.imageProfile = imageProfile;
        this.placeOfLiving = placeOfLiving;
    }
}
