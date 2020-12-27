package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Double amount=0.00;
        String currency ="";
        Scanner scanner=new Scanner(System.in);
        try {
            System.out.println("Please insert amount:");
            amount=scanner.nextDouble();
            System.out.println("Please insert currency like AZN or USD or EUR or GBP:");
            currency=scanner.next();
            String word = ConvertNumberToString.convertToWritingAmount(amount,currency);
            System.out.println(word);
        } catch (IOException e) {
            System.out.println("Please insert right format");
        }

    }
}
