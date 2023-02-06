package com.firstTutorial;

//@SuppressWarnings("ReassignedVariable")
public class Main {
    public static void main(String[] args) {
        int principal = (int) Console.readNumber("Principal: ",1_000,1_000_000);
        float annualInterest = (float) Console.readNumber("Annual interest(in percent): ",1,30);
        byte years = (byte) Console.readNumber("Years: ",1,30);

        var calculator = new MortgageCalculator(principal, annualInterest, years);

        MortgageReport report = new MortgageReport(calculator);
        report.printMortgage();
        report.printPaymentSchedule();
    }

}