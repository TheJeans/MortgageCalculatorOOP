public class MortgageCalculator {
    public static double mortgage(int principal, double interest, int years) {
        /**
         * Calculates interest and number of payments a MONTH.
         * Finds the mortgage through the equation: M = P[(r(1+r)^n)/((1+r)^n-1)]
         * Where M is monthly payment, P is principal, r is your monthly interest rate, & n is your number of payments.
         * Returns mortgage calculation.
         */
        double monthlyInterest = interest/ Main.percent/ Main.monthsInYear;
        int numberOfPayments = years* Main.monthsInYear;

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
        double monthlyInterest = interest/ Main.percent/ Main.monthsInYear;
        int numberOfPayments = years* Main.monthsInYear;


        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return balance;
    }
}
