import java.util.Scanner;

class CheckUpi extends Thread {

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter UPI ID: ");
        String upiId = sc.next();

        if (validateUpiId(upiId)) {
            System.out.println("UPI ID is valid. Payment processed.");
        } else {
            System.out.println("Invalid UPI ID. Payment failed.");
        }
    }

    private boolean validateUpiId(String upiId) {
        if (upiId.contains("@") && upiId.length() >= 5) {
            return true;
        }
        return false;
    }
}
