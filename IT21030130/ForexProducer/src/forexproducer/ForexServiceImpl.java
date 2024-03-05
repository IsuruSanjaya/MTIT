package forexproducer;

public class ForexServiceImpl implements ForexService {

    @Override
    public void publishRates() {
    	System.out.println("\n----- Forex Rates -----");
        System.out.println("(1) 1 USD -> 322.44 LKR");
        System.out.println("(2) 1 EUR -> 384.23 LKR");
        System.out.println("(3) 1 GBP -> 445.98 LKR");
        System.out.println("(4) 1 AED -> 150.51 LKR");
    }
}