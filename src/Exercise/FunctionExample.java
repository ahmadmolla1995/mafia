package Exercise;

import java.util.HashMap;
import java.util.function.Function;
import java.util.Map;

public class FunctionExample {
    public static void main(String[] args) {
        Function<Integer, String> function = (t) -> {
            if (t == 0)
                return "zero";
            return "non zero";
        };

        System.out.println(function.apply(7));

        Function<Map<String, Integer>, Void> mapFunction = (t) -> {
            if (t.size() == 5)
                t.replace("ahmad", 0);
            return null;
        };

        Map<String, Integer> map = new HashMap<>();
        map.put("ahmad", 4);
        map.put("mariam", 4);
        map.put("hamid", 4);
        map.put("ali", 4);
        System.out.println(mapFunction.apply(map));
    }
}
