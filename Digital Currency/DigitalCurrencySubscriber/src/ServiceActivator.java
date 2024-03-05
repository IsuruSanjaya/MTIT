import org.osgi.framework.BundleActivator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import java.util.Scanner;

import com.mtit.prj.service.*;

public class ServiceActivator implements BundleActivator {

	 private ServiceReference<?> serviceReference;

	    @Override
	    public void start(BundleContext context) throws Exception {
	        System.out.println("-------Online currency subscriber activated--------");
	        System.out.println("");
	        serviceReference = context.getServiceReference(ConvertCurrencyService.class.getName());
	        ConvertCurrencyService service = (ConvertCurrencyService) context.getService(serviceReference);
	        
	        
	        System.out.println("-----------------------------------");
	        System.out.println("      ONLINE CURRENCY");
	        System.out.println("-----------------------------------");

	        

	        Scanner scanner = new Scanner(System.in);


	        int paymentType = 0;
	        int currencyType = 0;
	        double paymentAmount = 0.0;
	        boolean payWithCard = false;

	        while (paymentType == 0 || currencyType == 0 || paymentAmount == 0.0 || !payWithCard) {
	            System.out.println("Select payment type:");
	            System.out.println("1 - USD");
	            System.out.println("2 - Yen");
	            System.out.println("3 - Pound");
	            System.out.print("Enter your choice (0 to go back): ");
	            paymentType = scanner.nextInt();
	            System.out.println("----------------------------------");
	            System.out.println("");

	            if (paymentType == 0 || paymentType > 3) {
	            	System.out.println("----------");
	                continue;
	            }

	            System.out.println("Select digital currency type:");
	            System.out.println("1 - Bitcoin");
	            System.out.println("2 - Ethereum");
	            System.out.println("3 - Dogecoin");
	            System.out.println("4 - Binance");
	            System.out.print("Enter your choice (0 to go back): ");
	            currencyType = scanner.nextInt();
	            System.out.println("----------------------------------");
	            System.out.println("");

	            if (currencyType == 0 || currencyType > 4) {
	            	System.out.println("---------");
	                continue;
	            }

	            System.out.print("Please enter the amount you wish to trade ?: ");
	            paymentAmount = scanner.nextDouble();
	            
	            System.out.println("----------------------------------");
	            System.out.println("");

	            if (paymentAmount < 0.0) {
	                continue;
	            }
	        
	            String DigitalCurrencyName = null;
				switch (currencyType) {
	            case 1:
	            	DigitalCurrencyName = "BTC";
	                System.out.println("                    ▄▄▄▄█████▄▄▄");
	                System.out.println("                ▄███████████████████▄");
	                System.out.println("             ▄█████▀▀           ▀██████▄");
	                System.out.println("           ▄████▀      ▄   ▄▄       ▀████▄");
	                System.out.println("         ▄████        ▐██ ▐██         ▀████");
	                System.out.println("        ▄███▀    ▐████████████▄▄▄       ████");
	                System.out.println("       ▐███▀        ▐████    ▀████▄      ████");
	                System.out.println("       ████         ▐████     ▐████       ████");
	                System.out.println("      ▐███▌         ▐████▄▄▄▄▄███▀        ████");
	                System.out.println("      ▐███          ▐████▀▀▀▀▀█████       ████");
	                System.out.println("      ▐███▌         ▐████      ▐████      ████");
	                System.out.println("       ████         ▐████      ▄████     ▐███▌");
	                System.out.println("        ████      ▄▄██████████████▀     ▐████");
	                System.out.println("         ████▄        ▐██ ▐██          ▄████");
	                System.out.println("          ▀████▄      ▐██ ▐██        ▄████");
	                System.out.println("            ▀█████▄               ▄█████▀");
	                System.out.println("              ▀████████▄▄▄▄▄▄▄███████▀");
	                System.out.println("                  ▀▀█████████████▀▀");
	            	break;
	            case 2:
	            	DigitalCurrencyName = "ETH";
	            	System.out.println("                              █");
	                System.out.println("                             ███");
	                System.out.println("                           ▄██████");
	                System.out.println("                         ███████████▄");
	                System.out.println("                      █████████████████");
	                System.out.println("                    ██████████████████████");
	                System.out.println("                 ███████████████████████████▄");
	                System.out.println("              █████████████████████████████████");
	                System.out.println("             ███████████████████████████████████");
	                System.out.println("               ███████████████████████████████▀");
	                System.out.println("                  ▀████████████████████████");
	                System.out.println("                      █████████████████");
	                System.out.println("              ███▄        █████████▀       ▄██▀");
	                System.out.println("                ████▄        ▀██       ▄█████");
	                System.out.println("                 ███████           ▄▄█████");
	                System.out.println("                      █████████████████");
	                System.out.println("                       ▐█████████████");
	                System.out.println("                           ███████");
	                System.out.println("                            ████▀");
	                System.out.println("                              █");
	            	break;
	            case 3:
	            	DigitalCurrencyName = "Doge";
	            	break;
	            case 4:
	            	DigitalCurrencyName = "Binance";
	            	break;
	            	
	            }
				
			System.out.println("----------------------------------");
			System.out.println("");
	        double amount = service.convertCurrency(paymentType, currencyType, paymentAmount);
	        System.out.println("Converted amount: " + amount + " "+ DigitalCurrencyName );
	        System.out.println("");
	        System.out.println("----------------------------------");
	        System.out.println("");
	        Thread.sleep(1000);
	        
	        System.out.println("Do you want to pay using a card? (yes/no)");
            String answer = scanner.next();
            
            if (answer == "yes") {
            	System.out.println("Redirecting to our payments gateway");
                System.out.println("----------------------------------");
            }else {
            	System.out.println("Redirecting to Home");
                System.out.println("----------------------------------");
            }
            
	        scanner.close();
	        Thread.sleep(1000);
	        
	        }
	    }

	    @Override
	    public void stop(BundleContext context) throws Exception {
	        System.out.println("---------Online currency stopped-------------");

	        context.ungetService(serviceReference);
	    }
}
