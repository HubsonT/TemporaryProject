package oracle.lambdas2;

import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author MikeW
 */
public class RoboCallTestLambda {
  
  public static void main(String[] args) {
    
    List<Person> pl = Person.createShortList();
    RoboContactMethodsLambda robo = new RoboContactMethodsLambda();
    
      Predicate<Person> allDrivers = p -> p.getAge()>=16;
      Predicate<Person> allDraftees = p -> p.getAge() >=18 && p.getAge() <=25 && p.getGender()==Gender.MALE;
      Predicate<Person> allPilots = p -> p.getAge()>=23 && p.getAge() <=65;
    
    
    System.out.println("\n=== Calling all Drivers ===");
    robo.callDrivers(pl, allDrivers);
    
    System.out.println("\n=== Emailing all Draftees ===");
    robo.emailDraftees(pl, allDraftees);
    
    System.out.println("\n=== Mail all Pilots ===");
    robo.mailPilots(pl, allPilots);
    
  }

}
