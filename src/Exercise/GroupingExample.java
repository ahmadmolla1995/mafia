package Exercise;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingExample {
    public static void main(String[] args) {
        String[] words = {"ahmad", "reza", "ali", "romina", "alireza", "reyhaneh", "parisa", "sahar"};
        Map<String, List<String>> groups = Stream.of(words).
                collect(Collectors.groupingBy(s -> s.substring(0, 1)));

        for(String key: groups.keySet())
            System.out.println("key: " + key + " value: " + groups.get(key));

        test();
    }

    private static void test(){
        String[] names = {"iran", "turkey", "america", "argentina", "morocco", "spain", "romania"};
        List<String> results = Stream.of(names)
                .filter(w -> w.length() > 5)
                .map(w -> w.substring(0, 2))
                .map(w -> w + "-----")
                .distinct()
                .limit(4)
                .collect(Collectors.toList());

        System.out.println(results);
    }
}
