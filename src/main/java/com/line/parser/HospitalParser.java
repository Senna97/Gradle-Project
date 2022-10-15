package com.line.parser;

import com.line.domain.Hospital;

import java.util.Objects;

public class HospitalParser implements Parser<Hospital>{

    private String getAddress(String address) {
        address = address.replace("'", " ");
        return address;
    }

    public String getDistrict(String address) {
        String[] strings = address.split(" ");
        return strings[0] + " " + strings[1];
    }

    public String getEmergencyRoom(String emergencyRoom) {
        if (Objects.equals(emergencyRoom, "1")) {
            emergencyRoom = "운영O";
        } else if (Objects.equals(emergencyRoom, "2")) {
            emergencyRoom = "운영X";
        }
        return emergencyRoom;
    }

    private String getSubdivision(String name, String categoryName) {
        String[] input = new String[]{"가정의학과", "마취통증의학과", "재활의학과", "신경외과", "한의원", "소아청소년과", "정신건강의학과", "피부과", "산부인과", "성형외과", "안과", "이비인후과", "정형외과", "치과", "내과", "외과"};

        for (String s : input) {
            if (name.contains(s)) {
                return s;
            } else if (name.contains("여성")) {
                return "여성의학과";
            } else if (name.contains("남성의원") || name.contains("비뇨")) {
                return "비교기과";
            } else if (name.contains("신경과") || name.contains("정신과")) {
                return "정신건강의학과";
            } else if (name.contains("소아과")) {
                return "소아청소년과";
            }
        }
        return categoryName;
    }

    @Override
    public Hospital parse(String str) {
        String[] splitted = str.split(",");

        String address = splitted[1];
        address = getAddress(address);
        String district = getDistrict(address);

        String emergencyRoom = splitted[6];
        emergencyRoom = getEmergencyRoom(emergencyRoom);

        String categoryName = splitted[3];
        String name = splitted[10];
        String subdivision = getSubdivision(name, categoryName);

        return new Hospital(splitted[0], address, district, splitted[2], emergencyRoom, name, subdivision);
    }
}