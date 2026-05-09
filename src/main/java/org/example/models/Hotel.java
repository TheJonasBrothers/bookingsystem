package org.example.models;

import java.time.LocalDateTime;

public class Hotel {

    private  int id;
    private  String name;
    private  String address;
    private  String city;
    private  String country;
    private  int stars;
    private  String description;
    private  LocalDateTime createdAt;
    private  LocalDateTime updatedAt;

    public Hotel(int id, String name, String address, String city, String country, int stars, String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this(name, address, city, country, stars, description);
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


    public Hotel(String name, String address, String city, String country, int stars, String description) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.country = country;
        this.stars = stars;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }


    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }



    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", stars=" + stars +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
