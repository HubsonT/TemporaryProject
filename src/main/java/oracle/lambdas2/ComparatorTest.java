/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.lambdas2;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Hubert
 */
public class ComparatorTest {

    public static void main(String[] args) {
        List<Person> personList = Person.createShortList();
        
//        Collections.sort(personList, new Comparator<Person>() {
//            @Override
//            public int compare(Person p1, Person p2) {
//                return p1.getSurName().compareTo(p2.getSurName());
//            }
//        });
//        
//        System.out.println("=== Sorted Asc SurName ===");
//        for(Person p: personList){
//            p.printName();
//        }
        
        //user lambda instead
        
        System.out.println("=== Sorted Asc SurName - Lambda Way ===");
        
        Collections.sort(personList, (p1,p2) -> p1.getSurName().compareTo(p2.getSurName()));
        personList.forEach(p-> p.printName());
        
        
        
        System.out.println("=== Sorted Desc SurName - Lambda Way ===");
        
        Collections.sort(personList, (p1,p2) -> p2.getSurName().compareTo(p1.getSurName()));
        personList.forEach(p-> p.printName());
        
    }
    
}
