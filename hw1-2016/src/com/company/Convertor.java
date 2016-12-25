package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by akucera on 28.10.16.
 */
public class Convertor {
    private int id;
    private String location;
    private String name;
    private String surname;


    public String firstToSecond(String s) {
        this.readFirst(s);
        return printSecond();
    }

    private void readFirst(String s) {
        String pattern = "===\\nTrip id: \"(\\d+)\"\\nLocation: \\\"(.+)\\\"\\nPerson: \\\"(.+) (.+)\\\"\\n===";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(s);
        m.find();

        id = Integer.parseInt(m.group(1));
        location = m.group(2);
        name = m.group(3);
        surname = m.group(4);
    }

    private String printSecond() {
        StringBuilder sb = new StringBuilder();

        sb.append("{\n");
        sb.append("\t\"id\": \"" + id + "\",\n");
        sb.append("\t\"location\": \"" + location + "\",\n");
        sb.append("\t\"person\": {\n");
        sb.append("\t\t\"name\": \"" + name + "\",\n");
        sb.append("\t\t\"surname\": \"" + surname + "\"\n");
        sb.append("\t}\n");
        sb.append("}");

        return sb.toString();
    }
}
