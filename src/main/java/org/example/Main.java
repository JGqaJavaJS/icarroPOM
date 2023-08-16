package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrL = new ArrayList<Integer>();
        arrL.add(1);
        arrL.add(2);
        arrL.add(3);
        arrL.add(4);

        // Using lambda expression to print all elements
        // of arrL
        arrL.forEach(elementByQue -> System.out.println(elementByQue));
        arrL.forEach(System.out::println); // ClassNameCreated::someMyfunction

        System.out.println("-------------------------------------------------");

        for (Integer integer : arrL) {
            System.out.println(integer);
        }

        for(int i = 0; i < arrL.size(); i++) {
            System.out.println(arrL.get(i));
        }
        System.out.println("-------------------------------------------------");


        // Using lambda expression to print even elements
        // of arrL
        arrL.forEach(n -> {
            if (n % 2 == 0)
                System.out.println(n);
        });
    }
}
