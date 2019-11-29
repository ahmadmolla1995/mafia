package Exercise;

import java.util.List;
import java.util.Arrays;

public class MapExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c", "d");
        list.stream().map(String::toUpperCase).forEach(System.out::print);
    }
}
