/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.javabrains.lambdas.unit1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Hubert
 */
public class Unit1ExerciseSolutionJava8 {

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

        //Step 1 - sortowanie po nazwisku
        Collections.sort(people, (o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));

        //Step 2 - stworzenie metody która wydrukuje wszystkie elementy z listy
        printConditionally(people, o -> true);
        
        
        //Step 3 - stworzenie metody która wydrukuje wszystkie osoby których naziwsko zaczyna się na C

        System.out.println("People whose last name begins with 'C'");
        printConditionally(people, o -> o.getLastName().startsWith("C"));

        System.out.println("People whose first name begins with 'C'");
        printConditionally(people, o -> o.getFirstName().startsWith("C"));
        

    }

    private static void printConditionally(List<Osoba> people, Condition condition) {

        for (Osoba o : people) {
            if (condition.test(o)) {
                System.out.println(o);
            }
        }
    }

}
