/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.lambdas2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 *
 * @author Hubert
 */
public class SearchCriteria {

    private final Map<String, Predicate<Person>> searchMap = new HashMap<>();

    private SearchCriteria() {
        super();
        initSearchMap();
    }

    private void initSearchMap() {
        Predicate<Person> allDrivers = p -> p.getAge() >= 16;
        Predicate<Person> allDraftees = p -> p.getAge() >= 18 && p.getAge() <= 25 && p.getGender() == Gender.MALE;
        Predicate<Person> allPilots = p -> p.getAge() >= 23 && p.getAge() <= 65;

        searchMap.put("allDrivers", allDrivers);
        searchMap.put("allDraftees", allDraftees);
        searchMap.put("allPilots", allPilots);
    }
    
    
    public Predicate<Person> getCriteria(String PredicateName) {
        Predicate<Person> target;
        
        target = searchMap.get(PredicateName);
        if (target ==null) {
            System.out.println("Search criteria not found");
            System.exit(1);
        }
        
        return target;
    }

    public static SearchCriteria getInstance() {
        return new SearchCriteria();
    }
}
