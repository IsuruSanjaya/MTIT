package stockmarketproducer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StocksImpl implements Stock{

	@Override
	public String publishService() {
		// TODO Auto-generated method stub
		return "Entered into Stocks Market";
	}

	@Override
	public void enterMarketBook() {
		// TODO Auto-generated method stub
		
		int x = 1;
		HashMap<String, Double> stocks = new HashMap<String, Double>();
		stocks.put("UBER", 25.0);
		stocks.put("Starbucks", 15.0);
		stocks.put("Budwieser", 10.0);

		System.out.println("Choose selection\n1. View available Stocks\n0.Exit Stock Market Book");
		Scanner scan = new Scanner(System.in);
		x = scan.nextInt();
		
		while (x == 1) {
			int choice, noOfstocks, requiredStocks;
			noOfstocks = 1;

			for (Map.Entry<String, Double> entry : stocks.entrySet()) {
				System.out.println("Stock: " + noOfstocks +" "+ entry.getKey() + ", Price: " + entry.getValue());
				noOfstocks++;
			}
			
			int selectProcess = 1;
			while (selectProcess == 1) {
				
				System.out.print("Choose a Stock: ");
				choice = scan.nextInt();

				switch (choice) {
				case 2:
					System.out.print("Enter amount of stocks needed: ");
					requiredStocks = scan.nextInt();
					System.out.println("Total Payment to be made: $" + stocks.get("UBER") * requiredStocks);

					break;
				case 3:
					System.out.print("Enter amount of stocks needed: ");
					requiredStocks = scan.nextInt();
					System.out.println("Total Payment to be made: $" + stocks.get("Starbucks") * requiredStocks);

					break;
				case 1:
					System.out.print("Enter amount of stocks needed: ");
					requiredStocks = scan.nextInt();
					System.out.println("Total Payment to be made: $" + stocks.get("Budwieser") * requiredStocks);

					break;
				default:
					System.out.println("Invalid stock selection...");
					break;
				}
				System.out.println("Press 0 to Confirm Stock Excahnge, \nPress 1 to Select Stock again; ");
				selectProcess=scan.nextInt();
			}
			try {
				System.out.println("Adding Order to Book");
				Thread.sleep(4500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Trade Successful Added to Book\n");
			System.out.println("Choose selection\n1. View available Stocks\n0.Exit Stock Market Book");
			x = scan.nextInt();
		}
	}

}
