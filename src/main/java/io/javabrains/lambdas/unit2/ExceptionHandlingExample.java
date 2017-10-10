/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.javabrains.lambdas.unit2;

import java.util.function.BiConsumer;

/**
 *
 * @author Hubert
 */
public class ExceptionHandlingExample {

    public static void main(String[] args) {
        int[] someNumbers = {1, 2, 3, 4};
        int key = 0;

//        process(someNumbers, key, (v, k) -> {
//            try {
//                System.out.println(v / k);
//            } catch (ArithmeticException e) {
//                System.out.println("Cannot divide by zero");
//            }
//        });
//Powyzsze rozwiazanie nie jest zbyt eleganckie bo psuje nam caly efekt osiagniety dzieki lambda -
//z jednej linijki robi sie kilka. Rozwiazaniem jest storzenie wrappera ktory zajmie sie tylko obsluga wyjatku
//cos jakby lamba opakowujaca nasza lambda
        process(someNumbers, key, wrapperLambda((v, k) -> System.out.println(v / k)));

    }

    private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer) {
        for (int i : someNumbers) {
            consumer.accept(i, key);
        }
    }

    private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer) {
        return (v, k) -> {
            try {
                consumer.accept(v, k);
            } catch (ArithmeticException e) {
                System.out.println("Exception caught in wrapper lambda: Cannot divide by zero");
            }
        };
    }

}
