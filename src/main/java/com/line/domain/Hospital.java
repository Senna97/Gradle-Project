package com.line.domain;

public class Hospital {
    private final String id;
    private final String address;
    private final String district;
    private final String category;
    private final String emergencyRoom;
    private final String name;
    private final String subdivision;

    public Hospital(String id, String address, String district, String category, String emergencyRoom, String name, String subdivision) {
        this.id = id;
        this.address = address;
        this.district = district;
        this.category = category;
        this.emergencyRoom = emergencyRoom;
        this.name = name;
        this.subdivision = subdivision;
    }

    public String getSqlInsertQuery() {
        String sql = String.format("('%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                this.id, this.address, this.district, this.category, this.emergencyRoom, this.name, this.subdivision);
        return sql;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getDistrict() {
        return district;
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