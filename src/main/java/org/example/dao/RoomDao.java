package org.example.dao;

import org.example.db.DBConnection;
import org.example.models.Room;
import org.example.models.RoomType;


import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RoomDao {

    private final String baseRoomSelect = "SELECT * FROM rooms";

    public boolean createRoom(Room room){
        try(Connection con = DBConnection.getConnection()){
            PreparedStatement ps = con.prepareStatement("INSERT INTO ROOMS(number,price_pre_night,description, capacity,room_category,room_type_id, hotel_id) VALUES(?,?,?,?,?,?,?)");
            ps.setInt(1,room.getNumber());
            ps.setBigDecimal(2, room.getPricePerNight());
            ps.setString(3, room.getDescription());
            ps.setInt(4, room.getCapacity());
            ps.setString(5, room.getRoomCategory());
            ps.setInt(6,room.getRoomTypeId());
            ps.setInt(7, room.getHotelId());

            return ps.executeUpdate() > 0;

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


    public boolean updateRoom(Room room){
        try(Connection con = DBConnection.getConnection()){
          PreparedStatement ps = con.prepareStatement("UPDATE  ROOMS SET price_pre_night = ?, desceiption = ?, capacity = ?, room_category = ?, updated_at = ?, room_type_id WHERE id = ?");
          ps.setBigDecimal(1, room.getPricePerNight());
          ps.setString(2, room.getDescription());
          ps.setInt(3, room.getCapacity());
          ps.setString(4, room.getRoomCategory());
          ps.setTimestamp(5, Timestamp.valueOf(room.getUpdatedAt()));
          ps.setInt(6, room.getRoomTypeId());
          ps.setInt(7, room.getId());

          return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Room getRoom(int roomId){
        Room room = null;

        try(Connection con = DBConnection.getConnection()){
         PreparedStatement ps = con.prepareStatement( baseRoomSelect + " WHERE id = ?");
         ps.setInt(1, roomId);
         ResultSet rs = ps.executeQuery();

         if(rs.next()){
             int id = rs.getInt("id");
             int number = rs.getInt("number");
             BigDecimal pricePreNight = rs.getBigDecimal("price_pre_night");
             String description = rs.getNString("description");
             int capacity = rs.getInt("capacity");
             String roomCategory = rs.getString("room_category");
             int roomTypeId = rs.getInt("room_type_id");
             LocalDateTime createdAt = rs.getTimestamp("created_at").toLocalDateTime();
             LocalDateTime updatedAt = rs.getTimestamp("updated_at").toLocalDateTime();
             int hotelId = rs.getInt("hotel_id");

             room = new Room(id, number, pricePreNight, description, capacity, roomCategory, roomTypeId, createdAt, updatedAt, hotelId);
         }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return room;
    }


    public List<Room> getRooms(){
        List<Room> rooms = new ArrayList<>();

        try(Connection con = DBConnection.getConnection()){
            PreparedStatement ps = con.prepareStatement(baseRoomSelect);
           ResultSet rs = ps.executeQuery();

           while (rs.next()){
               int id = rs.getInt("id");
               int number = rs.getInt("number");
               BigDecimal pricePreNight = rs.getBigDecimal("price_pre_night");
               String description = rs.getNString("description");
               int capacity = rs.getInt("capacity");
               String roomCategory = rs.getString("room_category");
               int roomTypeId = rs.getInt("room_type_id");
               LocalDateTime createdAt = rs.getTimestamp("created_at").toLocalDateTime();
               LocalDateTime updatedAt = rs.getTimestamp("updated_at").toLocalDateTime();
               int hotelId = rs.getInt("hotel_id");

               Room room = new Room(id, number, pricePreNight,description, capacity, roomCategory, roomTypeId, createdAt, updatedAt, hotelId);
               rooms.add(room);
           }



        }catch (SQLException e){
            throw  new RuntimeException(e);
        }

        return rooms;
    }

    public List<Room> getHotelRooms(int hotelId){
        List<Room> rooms = new ArrayList<>();

        try(Connection con = DBConnection.getConnection()){
            PreparedStatement ps = con.prepareStatement( baseRoomSelect + " WHERE hotel_id = ?");
            ps.setInt(1, hotelId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                int number = rs.getInt("number");
                BigDecimal pricePreNight = rs.getBigDecimal("price_pre_night");
                String description = rs.getNString("description");
                int capacity = rs.getInt("capacity");
                String roomCategory = rs.getString("room_category");
                int roomTypeId = rs.getInt("room_type_id");
                LocalDateTime createdAt = rs.getTimestamp("created_at").toLocalDateTime();
                LocalDateTime updatedAt = rs.getTimestamp("updated_at").toLocalDateTime();
                int idHotel = rs.getInt("hotel_id");

                Room room = new Room(id, number, pricePreNight,description, capacity, roomCategory, roomTypeId, createdAt, updatedAt, idHotel);
                rooms.add(room);
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return rooms;
    }


    public List<Room> getRoomsByType(int roomTypeId){
        List<Room> rooms = new ArrayList<>();

        try(Connection con = DBConnection.getConnection()){
            PreparedStatement ps = con.prepareStatement(baseRoomSelect + " WHERE romm_type_id = ?");
            ps.setInt(1, roomTypeId);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                int number = rs.getInt("number");
                BigDecimal pricePreNight = rs.getBigDecimal("price_pre_night");
                String description = rs.getNString("description");
                int capacity = rs.getInt("capacity");
                String roomCategory = rs.getString("room_category");
                int typeId = rs.getInt("room_type_id");
                LocalDateTime createdAt = rs.getTimestamp("created_at").toLocalDateTime();
                LocalDateTime updatedAt = rs.getTimestamp("updated_at").toLocalDateTime();
                int idHotel = rs.getInt("hotel_id");

                Room room = new Room(id, number, pricePreNight,description, capacity, roomCategory, typeId, createdAt, updatedAt, idHotel);
                rooms.add(room);
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return rooms;
    }


    public boolean createRoomType(RoomType roomType){
        try(Connection con = DBConnection.getConnection()){
            PreparedStatement ps = con.prepareStatement("INSERT INTO room_types(name) VALUES(?)");
            ps.setString(1, roomType.getName().name());

            return ps.executeUpdate() > 0;

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


    public boolean updateRoomType(RoomType roomType){
        try(Connection con = DBConnection.getConnection()){
            PreparedStatement ps = con.prepareStatement("UPDATE room_types SET name = ? WHERE id = ?");
            ps.setString(1, roomType.getName().name());
            ps.setInt(2, roomType.getId());

            return ps.executeUpdate() > 0;


        }catch (SQLException e){
            throw  new RuntimeException(e);
        }
    }

    public RoomType getRoomType(int roomTypeId){
        RoomType roomType = null;

        try(Connection con = DBConnection.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT  * FROM room_types WHERE id = ?");
            ps.setInt(1, roomTypeId);
            ResultSet rs = ps.executeQuery();;

            if(rs.next()){
            int id = rs.getInt("id");
            org.example.models.types.Room name = org.example.models.types.Room.getTypesAsString(rs.getString("name"));
            roomType = new RoomType(id, name);

            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return roomType;
    }


}
