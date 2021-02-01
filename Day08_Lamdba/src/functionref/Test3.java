package functionref;

import why4.Test;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 实例方法的引用
 */
public class Test3 {
    public String put() {
        return "put..";
    }

    public void getSize(int size) {
        System.out.println("size" + size);
    }

    public static void main(String[] args) {
        System.out.println(new Test3().put());
        Supplier<String> s1 = () -> new Test3().put();
        Supplier<String> s2 = () -> {return new Test3().put();};
        Supplier<String> s3 = new Test3()::put;
        System.out.println(s1.get());
        System.out.println(s2.get());
        System.out.println(s3.get());
        // System.out是标准输出流，是个PrintStream类对象。即调用println()普通方法
//        System.out::println

        // 唯一的创建一个test3对象
        Test3 test3 = new Test3();
        Consumer<Integer> c1 = (size)->new Test3().getSize(size);
        Consumer<Integer> c2 = new Test3()::getSize;
        Consumer<Integer> c3 = test3::getSize;
        c1.accept(123);
        c2.accept(123);
        c3.accept(123);
    }
}

