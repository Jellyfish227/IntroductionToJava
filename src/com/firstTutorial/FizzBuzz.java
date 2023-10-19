package com.firstTutorial;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class FizzBuzz{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        print("Number: ");
        int number = scanner.nextInt();


        if (number % 5 == 0 && number % 3 == 0)
            System.out.println("FizzBuzz");
        else if(number % 5 == 0)
            System.out.println("Fizz");
        else if(number % 3 == 0)
            System.out.println("Buzz");
        else
            System.out.println(number);
        }
    public static void print(String prompt){
        System.out.println(prompt);
    }

}

