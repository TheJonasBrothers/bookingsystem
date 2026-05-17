package org.example.models.types;

public enum Room {
    STANDARD,
    SUITE,
    LUXURY_SUITE;

    public static Room getTypesAsString(String type){
        if(type == null){
            throw new IllegalArgumentException("");
        }

        Room roomType = null;

        switch (type){
            case "Standrad":
                roomType = STANDARD;
                break;
            case "Suite":
                roomType = SUITE;
                break;
            case  "Luxury Suite":
                roomType = LUXURY_SUITE ;
                break;
            default:
               throw new IllegalArgumentException("");
        }

        return roomType;
    }

}
