package com.example.registerapp.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Constants {
    public static final int FIELD_NAME = 10;
    public static final int FIELD_AGE = 11;
    public static final int FIELD_PHONE = 12;
    public static final int FIELD_CEP = 13;
    public static final int FIELD_STREET = 14;
    public static final int FIELD_NUMBER = 15;
    public static final int FIELD_DISTRICT = 16;
    public static final int FIELD_CITY = 17;
    public static final int FIELD_UF = 18;

    public static final String PERSONAL_DATA_ID = "personal_data_id";

    public static final List<String> listUf = Collections.unmodifiableList(
            new ArrayList<String>() {{
                add("AC");
                add("AL");
                add("AP");
                add("AM");
                add("BA");
                add("CE");
                add("ES");
                add("GO");
                add("MA");
                add("MT");
                add("MS");
                add("MG");
                add("PA");
                add("PB");
                add("PR");
                add("PE");
                add("PI");
                add("RJ");
                add("RN");
                add("RS");
                add("RO");
                add("RR");
                add("SC");
                add("SP");
                add("SE");
                add("TO");
                add("DF");
                // etc
            }});
}
