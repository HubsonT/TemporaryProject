package oracle.lambdas2;

import java.util.List;

/**
 *
 * @author MikeW
 */
public class RoboCallTestOldWay {
  
  public static void main(String[] args) {
    
    List<Person> pl = Person.createShortList();
    RoboContactMethodsOldWay robo = new RoboContactMethodsOldWay();
    
    System.out.println("\n==== Test 01 ====");
    System.out.println("\n=== Calling all Drivers ===");
    robo.callDrivers(pl);
    
    System.out.println("\n=== Emailing all Draftees ===");
    robo.emailDraftees(pl);
    
    System.out.println("\n=== Mail all Pilots ===");
    robo.mailPilots(pl);
    
  }

}
