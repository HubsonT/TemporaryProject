/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambdas;

/**
 *
 * @author Hubert
 */
public class CheckPersonEligibleForSelectiveService implements CheckPerson {

    @Override
    public boolean test(Person p) {
        return p.gender == Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25;
    }

}
