/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambdas;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hubert
 */
public class MainPerson {

    
    
    public static void main(String[] args) {
       
    List<Person> listaOsob = new ArrayList<>();
        
        
        Person p1 = new Person("Janek Kowalski", Person.Sex.MALE, 15);
        Person p2 = new Person("Wanda Nowak", Person.Sex.FEMALE, 24);
        Person p3 = new Person("Marek Ogarek", Person.Sex.MALE, 19);
        Person p4 = new Person("Jacek Placek", Person.Sex.MALE, 25);
        Person p5 = new Person("Magda Nowak", Person.Sex.FEMALE, 22);
        Person p6 = new Person("Krystyna Nowakowska", Person.Sex.FEMALE, 50);
        Person p7 = new Person("Zygmunt Frojd", Person.Sex.MALE, 26);
        
        listaOsob.add(p1);
        listaOsob.add(p2);
        listaOsob.add(p3);
        listaOsob.add(p4);
        listaOsob.add(p5);
        listaOsob.add(p6);
        listaOsob.add(p7);
        
        //p1.printPerson();
        
        for (int i = 0; i < listaOsob.size(); i++) {
            System.out.println(listaOsob.get(i));
        }
        
        Person.printPersonOlderThan(listaOsob, 22);
        Person.printPersonsWithinAgeRange(listaOsob, 18, 25);
    }
    
}
