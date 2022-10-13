package com.line.domain;

public class Hospital {
    private String id; // splitted[0]
    private String address; // splitted[1]
    private String district;
    private String category; // splitted[2]
    private String emergencyRoom; // splitted[6]
    private String name; // splitted[10]
    private String subdivision;

    public Hospital(String id, String address, String district, String category, String emergencyRoom, String name, String subdivision) {
        this.id = id;
        this.address = address;
        this.district = district;
        this.category = category;
        this.emergencyRoom = emergencyRoom;
        this.name = name;
        this.subdivision = subdivision;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        if (address.contains("'")) {
            address = address.replace("'", "\\'");
        }
        return address;
    }

    public String getDistrict() {
        String[] strings = new String[20];
        strings = district.split(" ");

        return strings[0] + " " + strings[1];
    }

    public String getCategory() {
        return category;
    }

    public String getEmergencyRoom() {
        return emergencyRoom;
    }

    public String getName() {
        return name;
    }

    public String getSubdivision() {
        return subdivision;
    }
}
