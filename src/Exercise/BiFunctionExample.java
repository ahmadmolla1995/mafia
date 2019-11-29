package Exercise;

import java.util.Map;
import java.util.HashMap;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;


public class BiFunctionExample {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "ahmad");
        map.put(2, "navid");
        map.put(3, "reza");

        BiFunction<Integer, Integer, String> biFunction = (first, second) -> "result:" + (first + second);
        System.out.println(biFunction.apply(20, 25));

        BiPredicate<Integer, String> condition = (i, s) -> i.toString().equals(s);
        System.out.println(condition.test(10, "10"));
        System.out.println(condition.test(20, "30"));

        for (Integer key : map.keySet())
            System.out.println(key + ": " + map.get(key));

        Optional<String> opt = Optional.of("salam");
        boolean b = opt.isPresent();
        String s = opt.get();
        String t = opt.orElse("bye");
    }
}
