/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.lambdas2;

import java.util.List;
import java.util.function.Function;

/**
 *
 * @author Hubert
 */
public class PersonDisplay {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Person> lista = Person.createShortList();

        Function<Person, String> nameAndEmail = p -> "Name: " + p.getGivenName() + ", email: " + p.getEmail();
        Function<Person, String> westernStyleName = p -> "Name: " + p.getGivenName() + " " + p.getSurName();

        System.out.println("Custom  display - name + email");
//        for (Person person : lista) {
//            System.out.println(
//                    person.printCustom(nameAndEmail)
//            );
//        }
        lista.forEach(p-> System.out.println(p.printCustom(nameAndEmail)));

        System.out.println("\nlist of people - surname + givenname");
//        for(Person person: lista) {
//            System.out.println(person.printCustom(westernStyle));
//        }
        lista.forEach(p -> System.out.println(p.printCustom(westernStyleName)));
        
//        inny sposob wywolania tego co powyżej
        System.out.println("\nlist of people - western style");
        lista.forEach(p-> p.printWesternName());
         
        System.out.println("\nlist of people - estern style");
//        tu uzywamy tzw. method reference, kiedy gotowa metoda jest juz zdefiniowana
        lista.forEach(Person::printEasternName);
    }

}
