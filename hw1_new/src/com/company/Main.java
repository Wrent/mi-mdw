package com.company;

public class Main {

    public static void main(String[] args) {
	    Convertor conv = new Convertor();
        System.out.println(conv.firstToSecond("Dear Sir or Madam,\n" +
                "\n" +
                "please find the details about my booking bellow:\n" +
                "\n" +
                "===\n" +
                "Trip id: \"1\"\n" +
                "Location: \"Bohemian Switzerland\"\n" +
                "Person: \"Jan Novak\"\n" +
                "===\n" +
                "\n" +
                "Regards,\n" +
                "Jan Novak\n"));
    }
}
