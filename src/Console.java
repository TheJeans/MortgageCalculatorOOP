import java.util.Scanner;

public class Console {
    public static double readNumber(String prompt, double min, double max){
        /**
         * Takes the desired prompt, min, and max.
         * Creates the scanner and proceeds into the loop.
         * Prints the prompt and takes in the input value
         * if the input(value) is within the min and max range
         * it breaks out of the loop and returns the value.
         * Otherwise, it will tell the user to input a value
         * between min and max until they do so.
         */
        Scanner input = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = input.nextDouble();
            if (value >= min && value <= max) {
                break;
            }
            System.out.println("Enter a value between " + min + " and " + max);
        }
        return value;
    }
}
