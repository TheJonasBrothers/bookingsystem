package org.example.dao;

import org.example.db.DBConnection;
import org.example.models.Hotel;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HotelDao {


    public boolean createHotel(Hotel hotel){

        try(Connection con = DBConnection.getConnection()){
            PreparedStatement  ps = con.prepareStatement("INSERT INTO hotels(name, description, address, city, country, stars) VALUES(?,?,?,?,?,?)");
            ps.setString(1, hotel.getName());
            ps.setString(2, hotel.getDescription());
            ps.setString(3, hotel.getAddress());
            ps.setString(4, hotel.getCity());
            ps.setString(5, hotel.getCountry());
            ps.setInt(6, hotel.getStars());

            return ps.executeUpdate() > 0;

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean updateHotel(Hotel hotel){

        try(Connection con = DBConnection.getConnection()){
            PreparedStatement ps = con.prepareStatement("UPDATE hotels SET name = ?, description = ?, address = ?, city = ?, country = ?, stars = ?, updated_at = ?, created_at = ? WHERE id = ?");
            ps.setString(1, hotel.getName());
            ps.setString(2, hotel.getDescription());
            ps.setString(3, hotel.getAddress());
            ps.setString(4, hotel.getCity());
            ps.setString(5, hotel.getCountry());
            ps.setInt(6, hotel.getStars());
            ps.setTimestamp(7, Timestamp.valueOf(hotel.getUpdatedAt()));
            ps.setTimestamp(8, Timestamp.valueOf(hotel.getCreatedAt()));
            ps.setInt(9, hotel.getId());

            return ps.executeUpdate() > 0;


        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    public Hotel getHotel(int hotelId){
        Hotel hotel = null;

        try(Connection con = DBConnection.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT * FROM hotels WHERE hotelId = ?");
            ps.setInt(1,hotelId);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String city = rs.getString("city");
                String country = rs.getString("country");
                int stars = rs.getInt("stars");
                String description = rs.getString("description");
                LocalDateTime createdAt = rs.getTimestamp("created_at").toLocalDateTime();
                LocalDateTime updatedAt = rs.getTimestamp("updated_at").toLocalDateTime();
                hotel = new Hotel(id,name,address,city,country,stars,description,createdAt,updatedAt);
            }


        }catch(SQLException e){
            throw new RuntimeException(e);
        }

        return hotel;
    }

    public List<Hotel> getHotels() {

        List<Hotel> hotels = new ArrayList<>();

        try(Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM hotels");
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String city = rs.getString("city");
                String country = rs.getString("country");
                int stars = rs.getInt("stars");
                String description = rs.getString("description");
                LocalDateTime createdAt = rs.getTimestamp("created_at").toLocalDateTime();
                LocalDateTime updatedAt = rs.getTimestamp("updated_at").toLocalDateTime();
                Hotel hotel = new Hotel(id, name, address, city, country, stars, description, createdAt, updatedAt);
                hotels.add(hotel);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hotels;
    }

}
