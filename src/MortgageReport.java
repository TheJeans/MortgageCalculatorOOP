import java.text.NumberFormat;

public class MortgageReport {
    public static void printMortgage(int principal, double interest, int years){
        double mortgage = MortgageCalculator.mortgage(principal, interest, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }

    public static void printPaymentSchedule(int principal, double interest, int years){
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (int month = 1; month <= years * Main.monthsInYear; month++) {
            double balance = MortgageCalculator.balance(principal, interest, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }
}
