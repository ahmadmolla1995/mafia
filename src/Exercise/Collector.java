package Exercise;

import java.util.Collection;
import java.util.stream.Stream;
import java.util.stream.Collectors;


public class Collector {
    public static void main(String[] args) {
        String[] names = {"ahmad", "bahram", "sadegh", "alireza", "ali"};
        Collection<String> result = Stream.of(names)
                .filter(n -> n.startsWith("a"))
                .collect(Collectors.toList());
        for(String name: result)
            System.out.print(name + ' ');

        Stream<String> myStream = Stream.of("first", "second", "three", "four");
        String str = myStream.collect(Collectors.joining(","));
        System.out.println(str);
    }
}
