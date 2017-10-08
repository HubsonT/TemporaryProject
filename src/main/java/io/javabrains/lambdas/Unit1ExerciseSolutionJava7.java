/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.javabrains.lambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Hubert
 */
public class Unit1ExerciseSolutionJava7 {

    public static void main(String[] args) {

        List<Osoba> people = Arrays.asList(
                new Osoba("Charles", "Dickens", 60),
                new Osoba("Lewis", "Caroll", 42),
                new Osoba("Thomas", "Carlyle", 51),
                new Osoba("Charlote", "Bronte", 45),
                new Osoba("Mathew", "Arnold", 39)
        );

        //Step 1 - sortowanie po nazwisku
        Collections.sort(people, new Comparator<Osoba>() {
            @Override
            public int compare(Osoba o1, Osoba o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });

        //Step 2 - stworzenie metody która wydrukuje wszystkie elementy z listy
        //System.out.println(people);
        printAll(people);
        //Step 3 - stworzenie metody która wydrukuje wszystkie osoby których naziwsko zaczyna się na C
        System.out.println("People whose last name begins with 'C' - version 1");
              
        printLastNameBeginningWithC(people);
        //inna implementacja
        
        System.out.println("People whose last name begins with 'C' - version 2");
        printConditionally(people, new Condition() {
            @Override
            public boolean test(Osoba o) {
                return o.getLastName().startsWith("C");
            }
        } );
        
        
        System.out.println("People whose first name begins with 'C'");
        printConditionally(people, new Condition() {
            @Override
            public boolean test(Osoba o) {
            return o.getFirstName().startsWith("C");
            }
        });
        
        
        
    }

    private static void printAll(List<Osoba> people) {
        System.out.println("The list of all people:");
        for (Osoba o : people) {
            System.out.println(o);
        }
    }
    //słaba implementacja bo jest bardzo ograniczona - tylko do litery C
    private static void printLastNameBeginningWithC(List<Osoba> people) {
        
        for (Osoba o : people) {
            if (o.getLastName().startsWith("C")) {
                System.out.println(o);
            }
        }
    }
    
    //metoda ogólna która zrobi to samo to ta powyżej
    private static void printConditionally(List<Osoba> people, Condition condition)  {
        
        for(Osoba o: people) {
            if (condition.test(o)) {
                System.out.println(o);
            }
        }
    }
    
}

interface Condition {
    boolean test(Osoba o);
}