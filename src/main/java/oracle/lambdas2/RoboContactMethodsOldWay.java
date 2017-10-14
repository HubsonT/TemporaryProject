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
           if (isDriver(p)) {
               roboCall(p);
           }
       }
    }

    
    
    public void emailDraftees(List<Person> pl) {
        for (Person p: pl) {
            if (isDraftee(p)) {
                roboEmail(p);
            }
        }
    }
    
    
    public void mailPilots(List<Person> pl) {
        for (Person p: pl) {
            if (isPilot(p)) {
                roboMail(p);
            }
        }
    }

    public static boolean isPilot(Person p) {
        return p.getAge()>=23 && p.getAge()<=65;
    }

    public static boolean isDraftee(Person p) {
        return p.getAge()>=18 && p.getAge()<=25 && p.getGender()==Gender.MALE;
    }
    
    public static boolean isDriver(Person p) {
        return p.getAge()>=16;
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
