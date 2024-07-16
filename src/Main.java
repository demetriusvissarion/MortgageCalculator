import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Principal
        System.out.print("Principal: ");
        double principal = scanner.nextDouble();

        // Annual Interest Rate
        System.out.print("Annual Interest Rate: ");
        double annual_interest_rate = scanner.nextDouble();

        // Period
        System.out.print("Period (Years): ");
        double period = scanner.nextDouble();

        // calculate result
        double r = annual_interest_rate/100/12;
        double n = period * 12;
        double result = principal * (r * Math.pow(( 1 + r ), n) / (Math.pow(( 1 + r ), n) - 1));

        // format result to 2 decimal places
        String formattedResult = String.format("%.2f", result);

        // output result (Mortgage)
        System.out.println("Mortgage: $" + formattedResult);
    }
}

// Test data:
// Principal: 100000
// Annual Interest Rate: 3.92
// Period (Years):: 30
// Mortgage: $472.81 => desired output