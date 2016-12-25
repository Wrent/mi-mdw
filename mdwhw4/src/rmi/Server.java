package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements CurrencyConverterInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double usdeur = 0.921107171;
	private double usdgbp = 0.793524837;
	private double eurgbp = 0.86149024;

	public Server() throws RemoteException {
		super();
	}

	@Override
	public double convert(Currency from, Currency to, double amount) throws RemoteException {
		if (from == to) {
			return amount;
		}

		switch (from) {
		case EUR:
			if (to == Currency.USD) {
				return amount * (1 / usdeur);
			} else {
				return amount * (eurgbp);
			}
		case USD:
			if (to == Currency.EUR) {
				return amount * (usdeur);
			} else {
				return amount * (usdgbp);
			}
		case GBP:
			if (to == Currency.EUR) {
				return amount * (1 / eurgbp);
			} else {
				return amount * (1 / usdgbp);
			}
		}
		// never used
		return amount;
	}

}
