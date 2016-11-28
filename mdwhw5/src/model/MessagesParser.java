package model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessagesParser {

	public static List<Integer> parseMessage(String message) {
		Matcher m = Pattern.compile("\\d+").matcher(message);
        List<Integer> numbers = new ArrayList<Integer>();
        while(m.find()) {
            numbers.add(Integer.parseInt(m.group()));
        }
        return numbers;
	}
}
