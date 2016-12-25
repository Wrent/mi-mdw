package com.company;

public class Main {

    public static void main(String[] args) {
        Convertor conv = new Convertor();
        String test1 = "Dear Sir or Madam,\n" +
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
                "Jan Novak\n";
        System.out.println("Converting");
        System.out.println(test1);
        System.out.println("to:");
        System.out.println(conv.firstToSecond(test1));
        System.out.println("============================================");

        String test2 = "Please please make me reservation now!\n" +
                "\n" +
                "===\n" +
                "Trip id: \"150\"\n" +
                "Location: \"Vineyards of South moravia\"\n" +
                "Person: \"Petr Jarusek\"\n" +
                "===\n" +
                "\n" +
                "thx,\n" +
                "Jetr\n";
        System.out.println("Converting");
        System.out.println(test2);
        System.out.println("to:");
        System.out.println(conv.firstToSecond(test2));
        System.out.println("============================================");
    }
}
