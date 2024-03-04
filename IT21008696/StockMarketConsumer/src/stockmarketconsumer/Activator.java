package stockmarketconsumer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import stockmarketproducer.Stock;

public class Activator implements BundleActivator {

	private static BundleContext context;

	ServiceReference servRef;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {

		System.out.println("Starting Stock Subscriber");
		servRef = bundleContext.getServiceReference(Stock.class.getName());
		Stock stock = (Stock) bundleContext.getService(servRef);
		System.out.println(stock.publishService());

		stock.enterMarketBook();  // Using Producers services
		
		proceedToPayment();
	}

	public void stop(BundleContext bundleContext) throws Exception {

		System.out.println("Stopping Stocks Subscriber");
		bundleContext.ungetService(servRef);
	}
	public void proceedToPayment() {
		int x =0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Press 1 to Proceed to Payment\nPress 0 to Return to Exit");
		x=scan.nextInt();
		
		if(x==1) {
			System.out.println("Proceeding to Payment");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("Exit Market Book...");
		}
	}

}
