package com.jeremiahgarza;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int loanAmt = 0;
        float monthlyInterest = 0;
        int numberOfPayments = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Loan Amount: ");
            loanAmt = scanner.nextInt();
            if (loanAmt >= 10_000 && loanAmt <= 1_000_000)
                break;
            System.out.println("Please enter a valid amount between $10,000 and $1,000,000");
        }

        while (true) {
            System.out.println("Annual Interest Rate: ");
            float annualInterest = scanner.nextFloat();
            if (annualInterest >= 1 && annualInterest <= 30) {
                monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a valid interest rate between 1 - 30");
        }

        while (true) {
            System.out.println("Period (in Years): ");
            byte years = scanner.nextByte();
            if (years >= 1 && years <= 30) {
                numberOfPayments = years * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Please enter a value between 1 - 30");
        }
            double mortgage = loanAmt
                    * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                    / (Math.pow(1 + monthlyInterest, numberOfPayments) -1);

            String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
            System.out.println("Mortgage Payment: " + mortgageFormatted);

    }
}
