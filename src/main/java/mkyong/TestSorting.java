/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mkyong;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import oracle.lambdas2.Gender;

/**
 *
 * @author Hubert
 */
public class TestSorting {

    public static void main(String[] args) {
        List<Person> people = Person.createShortList();
        System.out.println("Bez sortowania");
        System.out.println(people);

        Collections.sort(people, (p1, p2) -> p2.getAge() - p1.getAge());

        System.out.println("Po sortowaniu");
        System.out.println(people);

        List<String> listaImion = people.stream().map(p -> p.getGivenName()).collect(Collectors.toList());
        System.out.println(listaImion);

        List<String> listaMailiOsobDoSluzbyWojskowej = people.stream()
                .filter(p -> p.getGender() == Gender.MALE && p.getAge() >= 18 && p.getAge() <= 25)
                .map(p -> p.getEmail()).collect(Collectors.toList());

        listaMailiOsobDoSluzbyWojskowej.forEach(p -> System.out.println(p));

        people.stream()
                .map(p -> "Name: " + p.getGivenName() + " " + p.getSurName() + ", email: " + p.getEmail())
                .forEach(p -> System.out.println(p));

        List<String> names2 = people.stream()
                .filter(p -> p.getAge() <= 25 && p.getGender() == Gender.MALE)
                .map(p -> p.getGivenName().toUpperCase())
                .collect(Collectors.toList());

        System.out.println(names2);

        System.out.println("Oldest is: " + people.stream()
//                .max((p1, p2) -> p1.getAge() - p2.getAge()));
                .max((p1, p2) -> p1.getAge() > p2.getAge() ? 1 : -1));
        
        
        //mapa pogrupowana wg imienia - jest dwóch Joe, więc zgrupuje to razem
        Map<String, List<Person>> map = people.stream()
                .collect(Collectors.groupingBy(Person::getGivenName));
        
        map.forEach(((k,v) -> System.out.println(k + " " +v)));
                   
        
    }
}
