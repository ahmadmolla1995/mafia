package Exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        /*
        Person person = new Person("ali", "mahdizadeh");
        Predicate<String> myPredicate = s -> s.equals("ali");
        System.out.println(myPredicate.test(person.getFirstName());
        */

        Map<String, Person> map = new HashMap<>();
        map.put("person1", new Person("ahmad", "molla"));
        map.put("person2", new Person("ali", "hamidi"));
        map.put("person3", new Person("mohammadjavad", "omrani"));
        map.put("person4", new Person("hamid", "javadizadeh"));
        map.put("person5", new Person("romina", "abadi"));

        Predicate<Map<String, Person>> myPredicate =
                s -> s.size() == 5 &&
                s.containsKey("person2") &&
                s.get("person2").getFirstName().equals("ali");

        System.out.println(myPredicate.test(map));
    }
}

class Person{
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }
}
