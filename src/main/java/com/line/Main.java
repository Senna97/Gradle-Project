package com.line;

import com.line.domain.Hospital;
import com.line.parser.HospitalParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        FileController<Hospital> hospitalFileController = new FileController<>(new HospitalParser());

        String filename = "/Users/jangseohyeon/Downloads/서울시 병의원 위치 정보.csv";
        List<Hospital> hospitals = hospitalFileController.readLines(filename);

        hospitalFileController.createOneFile("seoul_hospital_insert.sql");

        List<String> lines = new ArrayList<>();
        lines.add("INSERT INTO `likelion-db`.`seoul_hospital`(`id`,`address`,`district`,`category`,`emergency_room`,`name`,`subdivision`) VALUES\n");
        for (Hospital hospital : hospitals) {
            lines.add(hospital.getSqlInsertQuery());
            lines.add(",\n");
        }
        lines.remove(lines.size() - 1);
        lines.add(";");

        hospitalFileController.write(lines, "seoul_hospital_insert.sql");
    }
}