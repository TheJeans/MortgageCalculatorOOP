public class MortgageCalculator {
    private final static int monthsInYear = 12;
    private final static int percent = 100;

    private int principal;
    private double interest;
    private int years;

    public MortgageCalculator(int principal, double annualInterest, int years) {
        this.principal = principal;
        this.interest = annualInterest;
        this.years = years;
    }

    public double calculateMortgage() {
        /**
         * Calculates interest and number of payments a MONTH.
         * Finds the mortgage through the equation: M = P[(r(1+r)^n)/((1+r)^n-1)]
         * Where M is monthly payment, P is principal, r is your monthly interest rate, & n is your number of payments.
         * Returns mortgage calculation.
         */
        double monthlyInterest = getMonthlyInterest();
        int numberOfPayments = getNumberOfPayments();

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return mortgage;
    }

    public double calculateBalance(int numberOfPaymentsMade){
        /**
         * Calculates interest and number of payments a MONTH.
         * Finds the mortgage through the equation: B = P[(1+r)^n-(1+r)p]/[(1+r)^n-1]
         * Where B is balance, P is principal, r is your monthly interest rate, n is your number of payments, & p is the number of payments made.
         * Returns mortgage calculation.
         */
        double monthlyInterest = getMonthlyInterest();
        int numberOfPayments = years* monthsInYear;


        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return balance;
    }

    public double[] getRemainingBalances(){
        double[] balances = new double[getNumberOfPayments()];
        for (int month = 1; month <= balances.length; month++) {
            balances[month-1]= calculateBalance(month);
        }
        return balances;
    }

    private int getNumberOfPayments() {
        return years* monthsInYear;
    }

    private double getMonthlyInterest() {
        return interest / percent / monthsInYear;
    }

}
