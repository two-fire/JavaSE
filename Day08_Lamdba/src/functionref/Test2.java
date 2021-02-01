package functionref;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * 静态方法的引用
 */
public class Test2 {
    static String put() {
        System.out.println("put...");
        return "put";
    }

    public static void getSize(int size) {
        System.out.println(size);
    }

    public static String toUpperCase(String str) {
        return str.toUpperCase();
    }
    public static void main(String[] args) {
//        System.out.println(put());
        Supplier<String> s1 = () -> Test2.put();
        System.out.println(s1.get());

        Supplier<String> s2 = Test2::put;
        System.out.println(s2.get());

        Supplier<String> s3 = Fun::hello;
        System.out.println(s3.get());

        Consumer<Integer> c1 = Test2::getSize;
        c1.accept(123);
        Consumer<Integer> c2 = (size) -> Test2.getSize(size);
        c1.accept(123);

        UnaryOperator<String> u1 = (str)->str.toUpperCase();
        UnaryOperator<String> u2 = (str)->Test2.toUpperCase(str);
        UnaryOperator<String> u3 = Test2::toUpperCase;
        UnaryOperator<String> u4 = Fun::toUpperCase;
        UnaryOperator<String> u5 = (str)->Fun.toUpperCase(str);

        System.out.println(u1.apply("aaa"));
        System.out.println(u2.apply("aaa"));
        System.out.println(u3.apply("aaa"));
        System.out.println(u4.apply("aaa"));
        System.out.println(u5.apply("aaa"));

    }
}
class Fun {
    public static String hello(){
        return "hello";
    }

    public static String toUpperCase(String str) {
        return str.toUpperCase();
    }
}
