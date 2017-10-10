/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.javabrains.lambdas.unit2;

import io.javabrains.lambdas.unit1.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 *
 * @author Hubert
 */
public class StandardFuctionalIntefacesExample {

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
        //printConditionally(people, o -> true);
        performConditionally(people, o -> true, o -> System.out.println(o));
        
        
        //Step 3 - stworzenie metody która wydrukuje wszystkie osoby których naziwsko zaczyna się na C

        System.out.println("People whose last name begins with 'C'");
        //printConditionally(people, o -> o.getLastName().startsWith("C"));
        performConditionally(people, o -> o.getLastName().startsWith("C"), o -> System.out.println(o));

        System.out.println("People whose first name begins with 'C'");
        //printConditionally(people, o -> o.getFirstName().startsWith("C"));
        performConditionally(people, o -> o.getFirstName().startsWith("C"), o-> System.out.println(o));
        //powyzsze oczywiscie możemy sobie zmieniac, bo consumer akceptuje cokolwiek, co zwraca void, czyli mozemy
        //sobie wydrukowac np. pierwsze imie osob ktorych imie zaczyna sie na C
        performConditionally(people, o -> o.getFirstName().startsWith("C"), o-> System.out.println(o.getFirstName()));
        

    }

//    private static void printConditionally(List<Osoba> people, Predicate<Osoba> predicate) {
//
//        for (Osoba o : people) {
//            if (predicate.test(o)) {
//                System.out.println(o);
//            }
//        }
//    }
//    zmiana metody na pefrormConditionally, która będzie przyjmować jako dodatkowy parametr zachowanie ktore chcemy uzyskac
    
    private static void performConditionally(List<Osoba> osoby, Predicate<Osoba> predicate, Consumer<Osoba> consumer) {
        for(Osoba o: osoby) {
            if (predicate.test(o)) {
                consumer.accept(o);
            }
        }
    }
}
