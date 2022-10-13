package com.line.domain;

public class Hospital {
    private String id; // splitted[0]
    private String address; // splitted[1]
    private String district; // splitted[1] - 수정
    private String category; // splitted[2]
    private String emergencyRoom; // splitted[6]
    private String name; // splitted[10]
    private String subdivision; // splitted[7]

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
        String[] input = new String[]{"가정의학과", "내과", "소아과", "정신과", "피부과", "비뇨기과", "산부인과", "성형외과", "안과", "외과", "이비인후과", "정형외과", "치과", "소아치과", "한의원", "한방병원"};
        for (int i = 0; i < input.length; i++) {
            if (name.contains(input[i])) {
                return input[i];
            } else if (subdivision.contains(input[i])) {
                return input[i];
            }
        }
        return null;
    }
}
