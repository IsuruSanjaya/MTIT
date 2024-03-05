package paymentgatewayproducer;

import java.util.Scanner;

public class PaymentMethodsImpl implements PaymentPublish {

    private Scanner scanner;

    public PaymentMethodsImpl() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void selectPaymentMethod() {
        System.out.println("Please select a payment method:");
        System.out.println("1. Debit");
        System.out.println("2. Credit");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                processDebitPayment();
                break;
            case 2:
                processCreditPayment();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void processDebitPayment() {
        System.out.println("Choose a debit card:");
        System.out.println("1. Master Card");
        System.out.println("2. Visa Card ");
        System.out.println("3. Infiniti Debit Card");
        int cardChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Assuming you have a method to handle card details entry
        enterCardDetails();
    }

    private void processCreditPayment() {
        System.out.println("Choose a credit card:");
        System.out.println("1. Master card classic");
        System.out.println("2. Platinum ");
        System.out.println("3. Gold Card");
        int cardChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Assuming you have a method to handle card details entry
        enterCardDetails();
    }

    public void enterCardDetails() {
        System.out.println("Enter card number:");
        String cardNumber = scanner.nextLine();

        System.out.println("Enter cardholder name:");
        String cardHolderName = scanner.nextLine();

        System.out.println("Enter CVV:");
        String cvv = scanner.nextLine();

        System.out.println("Enter expiration year:");
        int expYear = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter expiration month:");
        int expMonth = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Now you can use these details for payment processing or any other operations
        // For simplicity, let's just print them here
        System.out.println("Payment details:");
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Cardholder Name: " + cardHolderName);
        System.out.println("CVV: " + cvv);
        System.out.println("Expiration Year: " + expYear);
        System.out.println("Expiration Month: " + expMonth);
        System.out.println("Payment Success");
        
        ReturnPayment();
    }
    
    public void ReturnPayment() {
    	 System.out.println("Press 0 to exit :");
         String Exit = scanner.nextLine();

         System.out.println("ForeX " +Exit);
       
    }
    
}
