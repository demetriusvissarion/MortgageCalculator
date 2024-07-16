import java.util.Scanner;
import java.lang.Math;
import java.text.NumberFormat;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        Scanner scanner = new Scanner(System.in);

        // Principal
        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        // Annual Interest Rate
        System.out.print("Annual Interest Rate: ");
        float annualInterestRate = scanner.nextFloat();

        // Period
        System.out.print("Period (Years): ");
        double period = scanner.nextDouble();

        // calculate result
        double r = annualInterestRate/PERCENT/MONTHS_IN_YEAR;
        double n = period * MONTHS_IN_YEAR;
        double result = principal * (r * Math.pow(( 1 + r ), n) / (Math.pow(( 1 + r ), n) - 1));

        // format result to currency
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        String formattedResult = currencyFormat.format(result);

        // output result (Mortgage)
        System.out.println("Mortgage: $" + formattedResult);
    }
}

// Test data:
// Principal: 100000
// Annual Interest Rate: 3.92
// Period (Years):: 30
// Mortgage: $472.81 => desired output