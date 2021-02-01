package functionref;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 构造方法的引用
 */
public class Test5 {

    public static void main(String[] args) {
        Supplier<Account> s1 = ()->new Account();
        s1.get();
        Supplier<Account> s2 = Account::new;
        s2.get();

        Supplier<List> s3 = ArrayList::new;
        Supplier<Set> s4 = HashSet::new;
        Supplier<Thread> s5 = Thread::new;
        Supplier<String> s6 = String::new;
//        Supplier<Integer> s7 = Integer::new; // 错误，没有无参构造方法

        Consumer<Integer> c1 = (age) -> new Account(age);
        Consumer<Integer> c2 = Account::new;
        c1.accept(123);
        c2.accept(234);
        Function<String,Account> f1 = (str)->new Account(str);
        Function<String,Account> f2 = Account::new;
        f1.apply("abc");
        f2.apply("bcd");
    }
}

class Account {
    public Account(int age) {
        System.out.println("age 参数构造"+age);
    }
    public Account(String s) {
        System.out.println("s 参数构造"+s);
    }
    public Account() {
        System.out.println("调用无参构造方法");
    }

}
class Person {
    public Person(){
        System.out.println("调用无参构造方法");
    }
}