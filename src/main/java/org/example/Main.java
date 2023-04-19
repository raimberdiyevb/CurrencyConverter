package org.example;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Objects;
import java.util.Scanner;


public class Main {
    static Parser parser = new Parser();
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Welcome to my Currency Converter!");
        String text =
                        """
                        The Exchange Rates are gotten from a real webpage.
                        Link to the website:""";
        System.out.println(text);
        System.out.println("https://www.x-rates.com/table/?from=USD&amount=1");
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        while(choice != 3){
            Thread.sleep(800);
            System.out.println("Choose what would you like me to do?");
            Thread.sleep(800);
            System.out.println("1. Show Exchange Rates");
            Thread.sleep(800);
            System.out.println("2. Open Currency Calculator");
            Thread.sleep(800);
            System.out.println("3. Close application");
            Thread.sleep(800);
            System.out.print("Please Enter Your Choice : ");
            choice = scanner.nextInt();
            if(choice == 1){
                System.out.println("Here is Exchange Rates, updated in " + LocalTime.now() + " :");
                printExchangeRates();
                System.out.println("*".repeat(60));
            }else if (choice == 2) {
                System.out.println("WIll CREATE NOW");
                getConversionResult();
                System.out.println("*".repeat(60));
            } else if (choice == 3) {
                String goodbye = "Thank you for using this application!";
                for (char c : goodbye.toCharArray()) {
                    System.out.print(c);
                    Thread.sleep(150);
                }
                System.out.println();
                System.out.println("See you soon!");
            }

        }
    }
    public static void printExchangeRates() throws IOException {
        System.out.println(" ".repeat(25) + "USDtoOther" + " ".repeat(15) + "OtherToUSD");
        for (int i = 0; i < parser.getCurrencyNames().size(); i++) {
            System.out.printf("%-24s %-24s %s%n" , parser.getCurrencyNames().get(i),parser.getUsdToCurrency().get(i),parser.getCurrencyToUsd().get(i));
        }
    }
    public static void getConversionResult() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount of money you want to convert: ");
        double inputMoney = scanner.nextDouble();
        System.out.println("Here is the list of Currencies:");
        for (int i = 0; i < parser.getCurrencyNames().size(); i++) {
            System.out.printf("%-24s %-24s%n",parser.getCurrencyNames().get(i),parser.getCurrencyShortNames().get(parser.getCurrencyNames().get(i)));
        }
        System.out.println("*".repeat(40));
        System.out.println("You can enter either full or short name");
        System.out.println("Enter the Currency of your money: ");
        String inputCurrency = scanner.nextLine();
        System.out.println("Here is the list of Currencies:");
        for (int i = 0; i < parser.getCurrencyNames().size(); i++) {
            System.out.printf("%-24s %-24s%n",parser.getCurrencyNames().get(i),parser.getCurrencyShortNames().get(parser.getCurrencyNames().get(i)));
        }
        System.out.println("*".repeat(40));
        System.out.println("You can enter either full or short name");
        System.out.println("Enter the Currency you want you money convert to: ");
        String wantedCurrency = scanner.nextLine();
        double resultMoney = 0;
        double usdAmount = 0;
        int currencyIndex = 0;
        for (int i = 0; i < parser.getCurrencyNames().size(); i++) {
            if(Objects.equals(parser.getCurrencyNames().get(i), inputCurrency)
                || parser.getCurrencyShortNames().get(parser.getCurrencyNames().get(i)).equals(inputCurrency)){
                currencyIndex = i;
            }
        }
        usdAmount = inputMoney * parser.getCurrencyToUsd().get(currencyIndex);

        for (int i = 0; i < parser.getCurrencyNames().size(); i++) {
            if(Objects.equals(parser.getCurrencyNames().get(i), wantedCurrency)
                    || parser.getCurrencyShortNames().get(parser.getCurrencyNames().get(i)).equals(wantedCurrency)){
                currencyIndex = i;
            }
        }

        resultMoney = usdAmount * parser.getUsdToCurrency().get(currencyIndex);

        System.out.println("You converted your " + inputMoney + " " + inputCurrency + " to " + resultMoney + " " + wantedCurrency);
    }
}
