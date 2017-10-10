/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.javabrains.lambdas.unit3;

import io.javabrains.lambdas.unit1.Osoba;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 *
 * @author Hubert
 */
public class StreamsExample1 {

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
        
        people.stream() 
                .filter(p-> p.getLastName().startsWith("C"))
                .forEach(p -> System.out.println(p.getFirstName()));
        
        long count = people.stream()
                .filter(p-> true)
                .count();
        
        System.out.println("liczba elementow listy: " + count);
        count  = people.stream()
//                .filter(p-> p.getFirstName().startsWith("C"))
//                .filter(p -> Character.toString(p.getFirstName().charAt(0)).equalsIgnoreCase("c"))
                .filter(p -> "c".equalsIgnoreCase(Character.toString(p.getFirstName().charAt(0))))
                .count();
        
        
        System.out.println("liczba osob ktorych nazwisko zaczyna sie na C: "+ count);
        
               
    }

}
