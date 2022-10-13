package com.line;

import com.line.domain.Hospital;
import com.line.parser.HospitalParser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public void createOneFile(String fileName) {
        File file = new File(fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void write(List<String> strs, String fileName) {
        File file = new File(fileName);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (String str : strs) {
                writer.write(str);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        LineReader<Hospital> hospitalLineReader = new LineReader<>(new HospitalParser());
        String filename = "/Users/jangseohyeon/Downloads/서울시 병의원 위치 정보.csv";
        List<Hospital> hospitals = hospitalLineReader.readLines(filename);

        Main main = new Main();
        main.createOneFile("seoul_hospital_insert.sql");

        List<String> strings = new ArrayList<>();
        strings.add("INSERT INTO `likelion-db`.`seoul_hospital`(`id`,`address`,`district`,`category`,`emergency_room`,`name`,`subdivision`) VALUES\n");
        for (Hospital hospital : hospitals) {
            strings.add("('" + hospital.getId() + "','");
            strings.add(hospital.getAddress() + "','");
            strings.add(hospital.getDistrict() + "','");
            strings.add(hospital.getCategory() + "','");
            strings.add(hospital.getEmergencyRoom() + "','");
            strings.add(hospital.getName() + "','");
            strings.add(hospital.getSubdivision() + "')");
            strings.add(",\n");
        }
        strings.remove(strings.size() - 1);
        strings.add(";");

        main.write(strings, "seoul_hospital_insert.sql");
    }
}
