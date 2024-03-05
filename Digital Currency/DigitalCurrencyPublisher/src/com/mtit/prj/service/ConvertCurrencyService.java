package com.mtit.prj.service;

public interface ConvertCurrencyService {
	double convertCurrency(int paymentType, int currencyType, double paymentAmount);
}