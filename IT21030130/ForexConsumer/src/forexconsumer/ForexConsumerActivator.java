package forexconsumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import forexproducer.ForexService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ForexConsumerActivator implements BundleActivator {
    private ServiceReference serviceReference;
    private Scanner scanner;
    private Map<Integer, String> currencyMap;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("----- Forex Subscriber Activated -----");
        serviceReference = context.getServiceReference(ForexService.class.getName());
        ForexService forexService = (ForexService) context.getService(serviceReference);

        scanner = new Scanner(System.in);
        currencyMap = new HashMap<>();
        currencyMap.put(1, "USD");
        currencyMap.put(2, "EUR");
        currencyMap.put(3, "GBP");
        currencyMap.put(4, "AED");

        boolean exit = false;
        while (!exit) {
            System.out.println("\n---------- Forex Trading ----------");
            System.out.println("Please enter the LKR amount you wish to trade : ");
            double amount = scanner.nextDouble();

            boolean backToRateSelection = true;
            while (backToRateSelection) {
                System.out.println("\nChoose from the following options:");
                System.out.println("1. View Rates");
                System.out.println("0. Navigate Back");
                int choice = scanner.nextInt();

                if (choice == 1) {
                    forexService.publishRates();

                    boolean rateSelection = true;
                    while (rateSelection) {
                        System.out.println("\nPlease select a rate to calculate: ");
                        int selection = scanner.nextInt();

                        double selectedRate = 0;
                        String currency = "";

                        switch (selection) {
                            case 1:
                                selectedRate = 322.44;
                                currency = currencyMap.get(1);
                                break;
                            case 2:
                                selectedRate = 384.23;
                                currency = currencyMap.get(2);
                                break;
                            case 3:
                                selectedRate = 445.98;
                                currency = currencyMap.get(3);
                                break;
                            case 4:
                                selectedRate = 150.51;
                                currency = currencyMap.get(4);
                                break;
                            case 0:
                                rateSelection = false;
                                break;
                            default:
                                System.out.println("Invalid selection!");
                                continue;
                        }

                        if (selection != 0) {
                            double calculatedAmount = amount * selectedRate;

                            System.out.println("\nAmount: " + amount);
                            System.out.println("Selected Rate: " + selectedRate + " " + currency);
                            System.out.println("Calculated Amount: " + calculatedAmount + " " + currency);

                            System.out.println("\n1. Select a rate again");
                            System.out.println("2. Proceed to Payment");
                            System.out.println("0. Exit");
                            
                            int backChoice = scanner.nextInt();
                            if (backChoice == 1) {
                                continue;
                            } else if (backChoice == 2) {
                                System.out.println("Proceeding...");
                                Thread.sleep(5000);
                                backToRateSelection = false;
                                rateSelection = false;
                                break;
                            } else if (backChoice == 0) {
                                exit = true;
                                backToRateSelection = false;
                                rateSelection = false;
                                break;
                            } else {
                                System.out.println("Invalid choice!");
                            }
                        } else {
                            break;
                        }
                    }
                } else if (choice == 0) {
                    backToRateSelection = false;
                    break;
                } else {
                    System.out.println("Invalid choice!");
                }
            }
        }
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("----- Forex Subscriber Deactivated -----");
        context.ungetService(serviceReference);
    }
}
