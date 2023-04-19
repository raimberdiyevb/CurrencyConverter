package org.example;

import java.util.ArrayList;

public class Try {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> array1 = new ArrayList<>();
        ArrayList<String> array2 = new ArrayList<>();
        ArrayList<String> array3 = new ArrayList<>();

        // Populate the arrays with some sample data
        array1.add("Element 1");
        array1.add("Elem2");
        array1.add("Element    3");

        array2.add("Va 1");
        array2.add("Va ddsflue 2");
        array2.add("Value fsfsdfdsfsd");

        array3.add("Da");
        array3.add("Data fsdf  2");
        array3.add("Data   3");

        // Iterate through the arrays and print each element in a formatted way
        for (int i = 0; i < array1.size(); i++) {
            System.out.printf("%-20s %-20s %s%n", array1.get(i), array2.get(i), array3.get(i));
        }
        System.out.println();
        System.out.println();
        System.out.println();

        run();
    }
    public static void run() throws InterruptedException {
        String message = "Hello, world!";
        int delay = 1000; // in milliseconds (1 second)

        for (char c : message.toCharArray()) {
            System.out.print(c);
            Thread.sleep(delay);
        }
    }
}
