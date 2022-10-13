package com.line.parser;

import com.line.domain.Hospital;

public class HospitalParser implements Parser<Hospital> {

    @Override
    public Hospital parse(String str) {
        String[] splitted = str.split(",");
        return new Hospital(splitted[0], splitted[1], splitted[1], splitted[2], splitted[6], splitted[10], splitted[7]);
    }
}
