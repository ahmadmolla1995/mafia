package Exercise;

import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        Predicate<String> myPredicate = s -> s.contains("and");
        boolean isValid = myPredicate.test("Ahmad and Ali");
        System.out.println(isValid);
    }
}
