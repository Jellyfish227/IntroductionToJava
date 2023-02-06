package com.firstTutorial;

import java.text.NumberFormat;

public class MortgageReport {
    private final NumberFormat currency;
    private MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    private static void partSeparation(String part) {
        System.out.println();
        System.out.println(part.toUpperCase());
        for (int i = part.length(); i > 0; i--)
            System.out.print("-");
        System.out.println();
    }

    public void printPaymentSchedule() {
        partSeparation("payment schedule");
        for (double balance : calculator.getRemainingBalances()) {
            System.out.println(currency.format(balance));
        }
    }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        partSeparation("mortgage");
        System.out.println("Monthly Payments: " + currency.format(mortgage));
    }
}
