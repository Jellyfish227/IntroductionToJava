package com.secondTutorial;

class Complex {
    private final double real;
    private final double imag;

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double abs() {
        return Math.sqrt(real * real + imag * imag);
    }

    public Complex add(Complex other) {
        return new Complex(real + other.real, imag + other.imag);
    }

    public Complex multiply(Complex other) {
        return new Complex(real * other.real - imag * other.imag, real * other.imag + imag * other.real);
    }
}
