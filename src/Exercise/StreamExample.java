package Exercise;

import java.util.Set;
import java.util.HashSet;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.function.Predicate;

public class StreamExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("ahmad");
        set.add("ali");
        set.add("alireza");
        set.add("armita");
        set.add("navid");
        set.add("hamid");
        set.add("reza");

        Predicate<String> predicate = s -> s.startsWith("a");
        Stream<String> filteredStream = set.stream().filter(predicate);
        Consumer<String> consumer = m -> System.out.println("hello " + m);
        filteredStream.forEach(consumer);

        set.stream().filter(predicate).forEach(System.out::println);
        set.stream().filter(
                s -> s.startsWith("a"))
                .forEach(System.out::println);

        Stream<String> names = Stream.of("ahmad", "romina", "ali");
        names.filter(t -> t.startsWith("a")).forEach(n -> System.out.println(n));
    }
}
