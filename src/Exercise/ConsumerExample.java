package Exercise;

import java.util.function.Consumer;
import java.util.List;

public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<List<Integer>> modify = list -> {
            for(int i = 0; i < list.size(); i++)
                list.set(i, 2*list.get(i));
        };
    }
}
