package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import rmi.CurrencyConverterInterface.Currency;

public class Client {

	public static void main(String[] args) {
		try {
			CurrencyConverterInterface server = (CurrencyConverterInterface) Naming.lookup("//127.0.0.1/Converter");
			System.out.printf("100 EUR is %.2f USD\n", server.convert(Currency.EUR, Currency.USD, 100));
			System.out.printf("100 USD is %.2f EUR\n", server.convert(Currency.USD, Currency.EUR, 100));
			System.out.printf("100 GBP is %.2f USD\n", server.convert(Currency.GBP, Currency.USD, 100));
			System.out.printf("100 USD is %.2f GBP\n", server.convert(Currency.USD, Currency.GBP, 100));
			System.out.printf("100 GBP is %.2f EUR\n", server.convert(Currency.GBP, Currency.EUR, 100));
			System.out.printf("100 EUR is %.2f GBP\n", server.convert(Currency.EUR, Currency.GBP, 100));

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			System.err.println("Problem when starting client");
			e.printStackTrace();
		}

	}

}
