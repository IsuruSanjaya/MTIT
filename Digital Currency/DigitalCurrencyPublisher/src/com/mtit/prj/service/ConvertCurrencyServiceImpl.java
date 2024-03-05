package com.mtit.prj.service;

public class ConvertCurrencyServiceImpl implements ConvertCurrencyService {
	@Override
	public double convertCurrency(int paymentType, int currencyType, double paymentAmount) {
		double usdAmount = 0.0;

		// take the payment type yen usd pound and convert it to usd for easy
		// calculation

		switch (paymentType) {
		case 1: // USD
			usdAmount = paymentAmount;
			break;
		case 2: // Yen
			usdAmount = paymentAmount * 0.0066;
			break;
		case 3: // Pound
			usdAmount = paymentAmount * 1.27;
			break;
		}

		// based on the above calculated total convert the currency to digital funds

		double convertedAmount = 0.0;

		switch (currencyType) {
		// Bitcoin
		case 1:
			convertedAmount = usdAmount / 0.000015;
			break;
		// Ethereum
		case 2:
			convertedAmount = usdAmount / 0.00029;
			break;
		// Dogecoin
		case 3:
			convertedAmount = usdAmount / 6.18;
			break;
		// Binance
		case 4:
			convertedAmount = usdAmount * 1.00;
			break;
		}

		return convertedAmount;
	}
}
