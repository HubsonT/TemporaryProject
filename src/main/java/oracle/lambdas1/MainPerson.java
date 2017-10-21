/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.lambdas1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Hubert
 */
public class MainPerson {
    
    public static void main(String[] args) {
        
        List<Person> people = new ArrayList<>();
        
        Person p1 = new Person("Janek Kowalski", Person.Sex.MALE, 15);
        Person p2 = new Person("Wanda Nowak", Person.Sex.FEMALE, 24);
        Person p3 = new Person("Marek Ogarek", Person.Sex.MALE, 19);
        Person p4 = new Person("Jacek Placek", Person.Sex.MALE, 25);
        Person p5 = new Person("Magda Nowak", Person.Sex.FEMALE, 22);
        Person p6 = new Person("Krystyna Nowakowska", Person.Sex.FEMALE, 50);
        Person p7 = new Person("Zygmunt Frojd", Person.Sex.MALE, 26);
        Person p8 = new Person("Adam Krakus", LocalDate.of(1999, 10, 22), Person.Sex.MALE, "adam@adam.com", 18);
        Person p9 = new Person("Rysiek Krakus", LocalDate.of(1995, 11, 11), Person.Sex.MALE, "rysiek@rysiek.com", 22);
        Person p10 = new Person("Maciek Krakus", LocalDate.of(1993, 10, 22), Person.Sex.MALE, "maciek@maciek.com", 24);
        
        people.add(p1);
        people.add(p2);
        people.add(p3);
        people.add(p4);
        people.add(p5);
        people.add(p6);
        people.add(p7);
        people.add(p8);
        people.add(p9);
        people.add(p10);

        //p1.printPerson();
//        for (int i = 0; i < listaOsob.size(); i++) {
//            System.out.println(listaOsob.get(i));
//        }
        //Person.printPersonOlderThan(listaOsob, 22);
        //Person.printPersonsWithinAgeRange(listaOsob, 18, 25);
        //Person.printPersons(listaOsob, new CheckPersonEligibleForSelectiveService());
        //użycie klasy anonimowej
//        Person.printPersons(listaOsob, new CheckPerson() {
//            @Override
//            public boolean test(Person p) {
//                return p.getGender() == Person.Sex.MALE
//                        && p.getAge() >= 18
//                        && p.getAge() <= 25;
//            }
//        });
        //zastąpienie klasy anonimowej przez lambdas
//        Person.printPersonsWithPredicate(listaOsob,
//                //(Person p) -> p.getGender() == Person.Sex.MALE
//                //powyższą linię można zastąpić poniższą bo jest jeden parametr
//                p -> p.getGender() == Person.Sex.MALE
//                && p.getAge() >= 18
//                && p.getAge() <= 25
//        );
        Person.processPersons(people,
                p -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25,
                p -> p.printPerson()
        );
        
        Person.processPersonsWithFunction(people,
                p -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25,
                p -> p.getEmailAddress(),
                email -> System.out.println(email)
        );

        //to samo co powyzej ale z zastosowaniem filtrow:
        System.out.println("Inny sposob");        
        
        List<String> peopleEligibleForSelectiveService = people.stream()
                .filter(p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25)
                .map(p-> p.getEmailAddress())
                .collect(Collectors.toList());
        System.out.println(peopleEligibleForSelectiveService);
    }
    
}
