package com.company;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by akucera on 10/31/15.
 */
public class Convertor {

    private String name;
    private String day;
    private int month;
    private String year;
    private String street;
    private String city;
    private String zip;
    private String summary;

    public String firstToSecond(String src) {
        readFirst(src);
        return printSecond();
    }

    private String printSecond() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("  \"what\": \""+name+" - "+summary+"\",\n");
        sb.append("  \"when\": \""+day+"."+month+"."+year+"\",\n");
        sb.append("  \"where\": {\n");
        sb.append("    \"street\": \""+street+"\",\n");
        sb.append("    \"city\": \""+city+"\",\n");
        sb.append("    \"zip\": \""+zip+"\",\n");
        sb.append("  }\n");
        sb.append("}");

        return sb.toString();
    }

    private void readFirst(String src) {
        String pattern = "^-Event\\n" +
                "^--name\\n" +
                "^(.*)$\\n" +
                "^--start\\n" +
                "^(\\d*)(th |nd |st )(\\w*) (\\d*)$\\n" +
                "--location\\n^(.*), (.*), (.*)$\\n" +
                "--sumary\\n^(.*)";
        Pattern r = Pattern.compile(pattern, Pattern.MULTILINE | Pattern.UNICODE_CHARACTER_CLASS);
        Matcher m = r.matcher(src);
        m.find();

        name = m.group(1);
        day = m.group(2);
        month = convertMonthNameToInt(m.group(4));
        year = m.group(5);
        street = m.group(6);
        zip = m.group(7);
        city = m.group(8);
        summary = m.group(9);
    }

    private int convertMonthNameToInt(String month) {
        Date date = null;
        try {
            date = new SimpleDateFormat("MMM", Locale.ENGLISH).parse(month);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int mo = cal.get(Calendar.MONTH);
        return mo + 1;
    }
}
