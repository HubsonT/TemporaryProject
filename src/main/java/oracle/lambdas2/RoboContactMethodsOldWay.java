/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.lambdas2;

import java.util.List;

/**
 *
 * @author Hubert
 */
public class RoboContactMethodsOldWay {
    public void callDrivers(List<Person> pl) {
       for (Person p: pl) {
           if (p.getAge()>=16) {
               roboCall(p);
           }
       }
    }
    
    
    public void emailDraftees(List<Person> pl) {
        for (Person p: pl) {
            if (p.getAge()>=18 && p.getAge()<=25 && p.getGender()==Gender.MALE) {
                roboEmail(p);
            }
        }
    }
    
    
    public void mailPilots(List<Person> pl) {
        for (Person p: pl) {
            if (p.getAge()>=23 && p.getAge()<=65) {
                roboMail(p);
            }
        }
    }

    private void roboCall(Person p) {
        System.out.println("Calling " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getPhone());
    }
    
    private void roboEmail(Person p) {
        System.out.println("Emailing " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getEmail());
    }
    
    private void roboMail(Person p) {
        System.out.println("Mailing " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getAddress());
    }
    
}
