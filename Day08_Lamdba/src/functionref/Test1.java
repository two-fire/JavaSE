package functionref;

import java.util.function.Function;

public class Test1 {
    public static void main(String[] args) {
        Function<String, Integer> f1 = (str) -> {return str.length();};
        System.out.println(f1.apply("function"));
    }
}
