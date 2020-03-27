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


    public static double mortgage (int principal, double interest, int years) {
        /**
         * Calculates interest and number of payments a MONTH.
         * Finds the mortgage through the equation: M = P[(r(1+r)^n)/((1+r)^n-1)]
         * Where M is monthly payment, P is principal, r is your monthly interest rate, & n is your number of payments.
         * Returns mortgage calculation.
         */
        double monthlyInterest = interest/percent/monthsInYear;
        int numberOfPayments = years*monthsInYear;

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return mortgage;
    }

    public static double balance(int principal, double interest, int years, int numberOfPaymentsMade){
        /**
         * Calculates interest and number of payments a MONTH.
         * Finds the mortgage through the equation: B = P[(1+r)^n-(1+r)p]/[(1+r)^n-1]
         * Where B is balance, P is principal, r is your monthly interest rate, n is your number of payments, & p is the number of payments made.
         * Returns mortgage calculation.
         */
        double monthlyInterest = interest/percent/monthsInYear;
        int numberOfPayments = years*monthsInYear;


        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return balance;
    }

}
