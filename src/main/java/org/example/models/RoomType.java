package org.example.models;

import org.example.models.types.Room;

public class RoomType {

    private int id;
    private Room name;

    public RoomType(int id, Room name) {
        this(name);
        this.id = id;
    }

    public RoomType(Room name) {
        this.name = name;
    }

    public Room getName() {
        return name;
    }
    public void setName(Room name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "RoomType{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}

