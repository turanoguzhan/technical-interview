package com.ouz.solution;

import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string :>");
        // 1122233444445bbbceeef
        String textOne = scanner.nextLine();
        System.out.print("Enter other string :>");
        // 233355677aaabccceeedfff
        String textTwo = scanner.nextLine();

        HashMap<Character, Integer> mapTextOne = new HashMap<>();
        // build map with textOne
        for (int i = 0; i < textOne.length(); i++) {
            char element = textOne.charAt(i);
            if (mapTextOne.containsKey(element)) {
                mapTextOne.put(element, mapTextOne.get(element) + 1);
            } else {
                mapTextOne.put(element, 1);
            }
        }

        HashMap<Character, Integer> mapTextTwo = new HashMap<>();
        // build map with textTwo
        for (int i = 0; i < textTwo.length(); i++) {
            char element = textTwo.charAt(i);
            if (mapTextTwo.containsKey(element)) {
                mapTextTwo.put(element, mapTextTwo.get(element) + 1);
            } else {
                mapTextTwo.put(element, 1);
            }
        }

        AtomicInteger attempt = new AtomicInteger(0);

        // get key differences and add to AtomicInteger. Because stream needs final or effective final
        // differences between values of each key gives us number of remove attempts
        mapTextOne.keySet().stream().forEach(key -> {
            if (mapTextTwo.containsKey(key)) {
                attempt.addAndGet(Math.abs(mapTextOne.get(key) - mapTextTwo.get(key)));
            } else {
                attempt.addAndGet(mapTextOne.get(key));
            }
        });

        // and if mapTwo size bigger than map One,
        // it means that if there are values that we didn't traverse yet in map two.
        // int that lines, we traverse and add values of that keys for removal operations.
        mapTextTwo.keySet().stream().forEach(key -> {
            if (!mapTextOne.containsKey(key)) {
                attempt.addAndGet(mapTextTwo.get(key));
            }
        });

        System.out.println("Result attempt : " + attempt);

    }
}
