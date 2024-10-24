import java.util.Scanner;

class Booked implements Runnable {

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ticket Booking");
        System.out.println("Enter Payment method");
        System.out.println("1. Card  2. UPI ");

        int sw = sc.nextInt();
        switch (sw) {
            case 1:
                handleCardPayment(sc);
                break;

            case 2:
                CheckUpi checkUpi = new CheckUpi();
                checkUpi.start();
                break;

            default:
                System.out.println("Invalid option selected.");
                break;
        }
    }

    private void handleCardPayment(Scanner sc) {
        String cardNo, code;
        int expDate;

        System.out.println("Card number:");
        cardNo = sc.next();

        System.out.println("Expiry date (MMYY):");
        expDate = sc.nextInt();

        System.out.println("Enter code on back:");
        code = sc.next();

        if (cardNo.length() == 16 && expDate > 1224 && code.length() == 3) {
            System.out.println("Card Accepted");
        } else {
            System.out.println("Invalid card details.");
        }
    }
}
