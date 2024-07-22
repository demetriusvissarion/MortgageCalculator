import java.util.Scanner;
import java.lang.Math;
import java.text.NumberFormat;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        Scanner scanner = new Scanner(System.in);
        int principal = 0;
        float annualInterestRate = -0.1f;
        double period = 0;

        // Principal
        while (principal < 1000 || principal > 1000000) {
            System.out.print("Principal (£1K - £1M): ");
            principal = scanner.nextInt();
            if (principal < 1000 || principal > 1000000) {
                System.out.println("Enter a number between 1,000 and 1,000,000.");
            }
        }

        // Annual Interest Rate
        while (annualInterestRate < 1 || annualInterestRate > 30) {
            System.out.print("Annual Interest Rate: ");
            annualInterestRate = scanner.nextFloat();
            if (annualInterestRate < 1 || annualInterestRate > 30) {
                System.out.println("Enter a value greater than 0 and less than or equal to 30.");
            }
        }

        // Period
        while (period < 1 || period > 30) {
            System.out.print("Period (Years): ");
            period = scanner.nextDouble();
            if (period < 1 || period > 30) {
                System.out.println("Enter a value between 1 and 30.");
            }
        }

        // calculate result
        double r = annualInterestRate/PERCENT/MONTHS_IN_YEAR;
        double n = period * MONTHS_IN_YEAR;
        double result = principal * (r * Math.pow(( 1 + r ), n) / (Math.pow(( 1 + r ), n) - 1));

        // format result to currency
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        String formattedResult = currencyFormat.format(result);

        // output result (Mortgage)
        System.out.println("Mortgage: $" + formattedResult);

        // ------------Loan Eligibility Section------------
        System.out.print("What is your income? ");
        int incomeInput = scanner.nextInt();
        boolean hasHighIncome = (incomeInput > 100_000);
        String className = hasHighIncome ? "First" : "Economy";

        scanner.nextLine();

        System.out.print("Do you have a good credit score? [y/n]: ");
        boolean hasGoodCredit = scanner.nextLine().trim().equalsIgnoreCase("y");

        System.out.print("Do you have a criminal record? [y/n]: ");
        boolean hasCriminalRecord = scanner.nextLine().trim().equalsIgnoreCase("y");

        boolean isEligible = (hasHighIncome || hasGoodCredit) && !hasCriminalRecord;
        if (isEligible) {
            System.out.println("You are eligible for a loan");
            System.out.println("Loan class: " + className);
        }
        else {
            System.out.println("You are NOT eligible for a loan");
        }

        scanner.close();
    }
}

// Test data:
// Principal: 100000
// Annual Interest Rate: 3.92
// Period (Years):: 30
// Mortgage: $472.81 => desired output