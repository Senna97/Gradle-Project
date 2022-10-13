package com.line.parser;

import com.line.domain.Hospital;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

class HospitalParserTest {
    String line;

    HospitalParserTest() throws IOException {
        String filename = "/Users/jangseohyeon/Downloads/서울시 병의원 위치 정보.csv";
        BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(filename), StandardCharsets.UTF_8);
        bufferedReader.readLine();
        line = bufferedReader.readLine();
    }

    @Test
    @DisplayName("Parsing doing well")
    void parsingWell() {
        HospitalParser hospitalParser = new HospitalParser();

        Hospital hospital = hospitalParser.parse(this.line);
        Assertions.assertEquals("A1120837", hospital.getId());
        Assertions.assertEquals("서울특별시 금천구 벚꽃로 286 삼성리더스타워 111~114호 (가산동)", hospital.getAddress());
        Assertions.assertEquals("서울특별시 금천구", hospital.getDistrict());
        Assertions.assertEquals("C", hospital.getCategory());
        Assertions.assertEquals("2", hospital.getEmergencyRoom());
        Assertions.assertEquals("가산기대찬의원", hospital.getName());
        Assertions.assertEquals("내과", hospital.getSubdivision());
    }
}