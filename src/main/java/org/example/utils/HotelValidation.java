package org.example.utils;

import org.example.models.Hotel;

public class HotelValidation {


    public static boolean validatingInt(int value){
        return value <= 0;
    }

    public static boolean isHotelNull(Hotel hotel){
        return hotel == null;
    }

    public static boolean isStringInputEmptyOrNull(String input){
        return (input == null || input.isEmpty());
    }

}
