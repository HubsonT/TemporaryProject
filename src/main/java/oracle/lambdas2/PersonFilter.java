/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.lambdas2;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 *
 * @author Hubert
 */
public class PersonFilter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Person> pl = Person.createShortList();

        SearchCriteria search = SearchCriteria.getInstance();

//        System.out.println("Western style draftee list");
//        
//        pl.stream()
//                .filter(search.getCriteria("allDraftees"))
//                .forEach(Person::printWesternName);
//        
//        
//        //wyniki takiego wyszukiwania jak powyzej mozna tez zapisac do innej kolekcji
//        List<Person> pilotList = pl.stream()
//                .filter(search.getCriteria("allPilots"))
//                .collect(Collectors.toList());
//        
//        System.out.println("");
//        System.out.println("Western style pilot list");
//        
//        pilotList.forEach(Person::printWesternName);
//Teraz zrobimy co innego - spróbujemy policzyć średnią wieku wszystkich pilotów
//  w starym stylu:
        System.out.println("Calc the average age of all pilots - the old style");
        int sum = 0;
        int count = 0;

        for (Person p : pl) {
            if (p.getAge() >= 23 && p.getAge() <= 65) {
                sum += p.getAge();
                count++;
            }
        }

        long average = sum / count;
        System.out.println("Total age of all pilots " + sum);
        System.out.println("Average age of all pilots " + average);

        //    po nowemu
        System.out.println("Calc the average age of all pilots - lambda style");
        
        //suma wieku:
        long totalAge = pl.stream()
                .filter(search.getCriteria("allPilots"))
                .mapToInt(p-> p.getAge())
                .sum();
        
        OptionalDouble averageAge = pl.stream()
                .filter(search.getCriteria("allPilots"))
                .mapToDouble(p-> p.getAge())
                .average();
        
        System.out.println("");
        System.out.println("Total age of all pilots " + totalAge);
        System.out.println("Average age of all pilots " + averageAge.getAsDouble());
    }

}
