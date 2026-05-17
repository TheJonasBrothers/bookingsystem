package org.example.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Room {

    private int id;
    private int number;
    private BigDecimal pricePerNight;
    private String description;
    private int capacity;
    private String roomCategory;
    private int roomTypeId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int hotelId;


    public Room(int id, int number, BigDecimal pricePerNight, String description, int capacity, String roomCategory, int roomTypeId, LocalDateTime createdAt, LocalDateTime updatedAt, int hotelId) {
        this(number, pricePerNight, description, capacity, roomCategory, roomTypeId, hotelId);
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Room(int number, BigDecimal pricePerNight, String description, int capacity, String roomCategory, int roomTypeId, int hotelId) {
        this.number = number;
        this.pricePerNight = pricePerNight;
        this.description = description;
        this.capacity = capacity;
        this.roomCategory = roomCategory;
        this.roomTypeId = roomTypeId;
        this.hotelId = hotelId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public BigDecimal getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(BigDecimal pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getRoomCategory() {
        return roomCategory;
    }

    public void setRoomCategory(String roomCategory) {
        this.roomCategory = roomCategory;
    }

    public int getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(int roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", number=" + number +
                ", pricePerNight=" + pricePerNight +
                ", description='" + description + '\'' +
                ", capacity=" + capacity +
                ", roomCategory='" + roomCategory + '\'' +
                ", roomTypeId=" + roomTypeId +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
