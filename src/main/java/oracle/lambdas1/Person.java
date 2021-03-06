/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.lambdas1;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * @author Hubert
 */
public class Person {

    public enum Sex {
        MALE, FEMALE;
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;
    int age;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Sex getGender() {
        return gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public String toString() {
        //return "Person{" + "name=" + name + ", birthday=" + birthday + ", gender=" + gender + ", emailAddress=" + emailAddress + ", age=" + age + '}';
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.NO_CLASS_NAME_STYLE);
        return builder.append(name).append(birthday).append(gender).append(emailAddress).append(age).toString();
    }

    public Person(String name, LocalDate birthday, Sex gender, String emailAddress, int age) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
        this.age = age;
    }

    public Person(String name, Sex gender, int age) {
        this(name, LocalDate.of(1970, 01, 01), gender, "none@none.pl", age);
    }

    public void printPerson() {
        System.out.println(this.toString());
    }

    public static void printPersonOlderThan(List<Person> roster, int age) {
        System.out.println("lista osób starszych niż " + age);
        for (Person p : roster) {
            if (p.getAge() > age) {
                p.printPerson();
            }
        }
    }

    public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
        System.out.println("Lista osób starszych niż " + low + " i młodszych niż " + high);
        for (Person p : roster) {
            if (p.getAge() > low && p.getAge() < high) {
                p.printPerson();
            }
        }
    }

//    public static void printPersons(List<Person> rooster, CheckPerson tester) {
//        System.out.println("Lista osób spełniających określone kryteria");
//        for(Person p: rooster){
//            if (tester.test(p)) {
//                p.printPerson();
//            }
//        }
//    }
    //zastąpienie powyższej metody opertej na interfejsie nową implementacją zastępującą interfejs 
    //zdefiniowany przez nas interfejsem funkcjonalnym Predicate zdefiniowanym w java.util.function
    public static void printPersonsWithPredicate(List<Person> rooster, Predicate<Person> tester) {
        System.out.println("Lista osób spełniających określone kryteria");
        for (Person p : rooster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    //zastosowanie dodatkowego interfejsu funkconalnego Consumer<T> aby zastąpić wywołanie metody printPerson w ciele metody, 
    //wywołaniem metody printPerson przy wywołaniu metody
    public static void processPersons(List<Person> rooster, Predicate<Person> tester, Consumer<Person> block) {
        for (Person p : rooster) {
            if (tester.test(p)) {
                block.accept(p);
            }
        }
    }

    public static void processPersonsWithFunction(
            List<Person> rooster,
            Predicate<Person> tester,
            Function<Person, String> mapper,
            Consumer<String> block) {
        for (Person p : rooster) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

}
