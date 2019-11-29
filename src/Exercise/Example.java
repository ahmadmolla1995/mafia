package Exercise;

import java.util.function.Function;

public class Example {
    public static void main(String[] args) {
        Function<String, Boolean> function = (name) -> name.charAt(0) == name.charAt(name.length() - 1);
        System.out.println(function.apply("ahmad reza"));

        Function<String, Boolean> secondFunction = (name) -> name.substring(0, 1).equals(name.substring(name.length() - 2));
        secondFunction.apply("ABBA");
    }
}
