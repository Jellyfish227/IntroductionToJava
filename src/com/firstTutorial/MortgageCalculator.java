package com.firstTutorial;

public class MortgageCalculator {
    private final static byte MONTH_IN_YEAR = 12;
    private final static byte PERCENT = 100;

    private int principal;
    private float annualInterest;
    private byte years;

    public MortgageCalculator(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public double calculateMortgage() {
        float monthlyInterest = getMonthlyInterest();
        int periodInMonths = getPeriodInMonths();

        return principal
                * ((monthlyInterest * Math.pow(1 + monthlyInterest, periodInMonths))
                / (Math.pow(1 + monthlyInterest, periodInMonths) - 1));

    }

    public double calculateBalance(short months_paid) {
        float monthlyInterest = getMonthlyInterest();
        int periodInMonths = getPeriodInMonths();

        return principal * (Math.pow((1 + monthlyInterest), periodInMonths) - Math.pow((1 + monthlyInterest), months_paid))
                / (Math.pow((1 + monthlyInterest), periodInMonths) - 1);
    }

    public double[] getRemainingBalances() {
        var balances = new double[getPeriodInMonths()];
        for (short month = 1; month <= balances.length; month++)
            balances[month - 1] = calculateBalance(month);

        return balances;
    }
    private int getPeriodInMonths() {
        return (years * MONTH_IN_YEAR);
    }

    private float getMonthlyInterest() {
        return (annualInterest / PERCENT) / MONTH_IN_YEAR;
    }

}
