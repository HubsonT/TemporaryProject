/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.javabrains.lambdas.unit3;

import io.javabrains.lambdas.unit1.Osoba;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 *
 * @author Hubert
 */
public class MethodReferenceExample2 {

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
        performConditionally(people, o -> true, System.out::println);

        

    }

//    zmiana metody na pefrormConditionally, która będzie przyjmować jako dodatkowy parametr zachowanie ktore chcemy uzyskac
    private static void performConditionally(List<Osoba> osoby, Predicate<Osoba> predicate, Consumer<Osoba> consumer) {
        for (Osoba o : osoby) {
            if (predicate.test(o)) {
                consumer.accept(o);
            }
        }
    }

}
