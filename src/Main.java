/**
 * PT 3
 * Further continuation of "Mortgage Calculator" with OOP this time.
 * It takes the inputs from the user and calculates the mortgage at the end of the questions.
 * Then it calculates and displays the monthly payments as well as a payment schedule that shows
 * the balance after every months payment.
 */
public class Main {
    final static int monthsInYear = 12;
    final static int percent = 100;

    public static void main(String[] args) {

        /**
         * Collect inputs from user
         */
        int principal = (int) Console.readNumber("What is the principal?: $", 1000, 1_000_000);
        double interest = Console.readNumber("What is the annual interest rate?: ", 1, 30);
        int years = (int) Console.readNumber("What is the period (in years)?: ", 1, 30);


        /**
         * Call methods and display answers
         */
        MortgageReport.printMortgage(principal, interest, years);
        MortgageReport.printPaymentSchedule(principal, interest, years);

    }


}
