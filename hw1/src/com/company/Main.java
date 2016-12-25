package com.company;

public class Main {

    public static void main(String[] args) {
	    Convertor conv = new Convertor();
        System.out.println(conv.firstToSecond("-Event\n" +
                "--name\n" +
                "Meeting in Prague\n" +
                "--start\n" +
                "19th January 2015\n" +
                "--location\n" +
                "Th?kurova 9, 160 00, Prague 6\n" +
                "--sumary\n" +
                "Meeting with partners\n" +
                "-"));
    }
}
