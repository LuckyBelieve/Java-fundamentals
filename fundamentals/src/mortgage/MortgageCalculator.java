package mortgage;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args) {
        final byte MONTH = 12;
        final byte PERCENT = 100;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Principal:");
        int principal = scanner.nextInt();
        System.out.print("Annual interest rate:");
        float annualIntrest = scanner.nextFloat();
        float monthlyIntrest = annualIntrest/(MONTH*PERCENT);
        System.out.print("period (years):");
        byte period = scanner.nextByte();
        int numberOfPayments = period * MONTH;
        double mortgage = principal * ((monthlyIntrest*Math.pow(1+monthlyIntrest,numberOfPayments))/((Math.pow(1+monthlyIntrest,numberOfPayments))-1));
        String mortageValue = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("Mortgage:"+mortageValue);


    }
}
