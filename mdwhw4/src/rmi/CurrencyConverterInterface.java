package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CurrencyConverterInterface extends Remote {
	public enum Currency {
		EUR, USD, GBP
	}

	public double convert(Currency from, Currency to, double amount) throws RemoteException;
}
