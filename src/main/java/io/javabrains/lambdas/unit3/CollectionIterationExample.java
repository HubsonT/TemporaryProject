/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.javabrains.lambdas.unit3;

import io.javabrains.lambdas.unit1.Osoba;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Hubert
 */
public class CollectionIterationExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Osoba> people = Arrays.asList(
                new Osoba("Charles", "Dickens", 60),
                new Osoba("Lewis", "Caroll", 42),
                new Osoba("Thomas", "Carlyle", 51),
                new Osoba("Charlote", "Bronte", 45),
                new Osoba("Mathew", "Arnold", 39)
        );
        System.out.println("for loop");
        for (int i = 0; i < people.size(); i++) {
            System.out.println(people.get(i));
        }
        System.out.println("-------");
        System.out.println("Enhanced for loop");
        for (Osoba p: people) {
            System.out.println(p);
        }

        System.out.println("-------");
        System.out.println("Iteration introduced in Java 8");
        
        people.forEach(p-> System.out.println(p));
        
        
    }

}
