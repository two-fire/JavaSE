package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.*;

public class LambdaTest {
    public static void main(String[] args) throws Exception {
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("running1...");
            }
        };
        runnable1.run();

        Runnable runnable2 = ()->{
            System.out.println("running2...");
        };
        runnable2.run();

        Runnable runnable3 = () -> System.out.println("running3...");
        runnable3.run();

        //-------- 有返回值 ---------
        Callable<String> c1 = new Callable() {
            @Override
            public String call() throws Exception {
                return "mashibing";
            }
        };
        System.out.println(c1.call());

        Callable<String> c2 = () -> {return "mashibing2";};
        System.out.println(c2.call());

        Callable<String> c3 = () -> "mashibing3";
        System.out.println(c3.call());

        //---自定义函数接口实现Student----
        StudentDao sd1 = new StudentDao() {
            @Override
            public void insert(Student student) {
                System.out.println("插入学生1");
            }
        };
        StudentDao sd2 = (student) -> {
            System.out.println("student:"+student);
        };
        StudentDao sd3 = (Student student) -> System.out.println("student3"+student);
        sd1.insert(new Student());
        sd2.insert(new Student());
        sd3.insert(new Student());

        //---自定义函数接口实现Teacher----
        TeacherDao td1 = new TeacherDao() {
            @Override
            public int get(Teacher teacher) {
                return 1;
            }
        };
        TeacherDao td2 = (teacher) -> {return 2;};
        TeacherDao td3 = (Teacher teacher) -> {return 3;};
        TeacherDao td4 = (teacher) -> 4;
        TeacherDao td5 = (Teacher teacher) -> 5;
        System.out.println(td1.get(new Teacher()));
        System.out.println(td2.get(new Teacher()));
        System.out.println(td3.get(new Teacher()));
        System.out.println(td4.get(new Teacher()));
        System.out.println(td5.get(new Teacher()));

        System.out.println("++++++++++++++++++++");
        /**
         * 在java中提供了一系列函数式接口，用来接收后续传入的逻辑，
         * 但是对输入输出有要求。
         */
        // Function：一个输入一个输出，一般输入输出类型不同
        // 要求必须有一个输入（第一个类型String），一个输出（第二个类型Integer）
        Function<String, Integer> f1 = (str) -> {return str.length();};
        System.out.println(f1.apply("abcdefg"));
        // UnaryOperator：一个输入一个输出，类型相同
        UnaryOperator<String> uo1 = (String u) -> {return u.concat("qqq");};
        System.out.println(uo1.apply("unaryOperator"));
        // BiFunction：两个输入一个输出，一般输入输出类型不同
        BiFunction<Integer, String, String> bf = (a, str) -> {
            return a.toString()+str;};
        System.out.println(bf.apply(1,"bifunction"));
        // BinaryOperator：两个输入一个输出，输入输出类型相同
        BinaryOperator<String> bo = (st1,st2) -> {return st1+st2;};
        System.out.println(bo.apply("Binary","operator"));
        // Supplier：代表一个输出
        Supplier<String> s1 = ()->{return "Supplier";};
        System.out.println(s1.get());

        // Consumer：代表一个输入
        Consumer<String> c11 = (str) -> System.out.println(str);
        c11.accept("Consumer");
        // BiConsumer：代表两个输入
        BiConsumer<String, Integer> bc1 = (str, i) -> System.out.println(str+","+i);
        bc1.accept("BiConsumer",1);

        System.out.println("====================");

        // 对下面的方法进行基本调用
        /**
         * 不管是get()还是exec()，都是在run()中进行一个具体执行的。
         * 只不过返回值没有进行一个处理
         */
        // 如果想打印结果
//        Runnable runnable4 = () -> {
//            int i = get();
//            System.out.println(i);};
        Runnable runnable4 = () -> get();
        Runnable runnable5 = () -> exec();
        // 错误
//        Runnable runnable6 = () -> 100;
//        Runnable runnable7 = () ->"";
        runnable4.run();
        runnable5.run();

        LambdaInterface li1 = () -> get(); // 调用下面的get方法
//        LambdaInterface li2 = () -> find(); // 错误，接口明确定义要返回int类型
        LambdaInterface li3 = () -> 100;
//        LambdaInterface li4 = () -> ""; // 错误
        LambdaInterface li5 = () -> true?0:1;

//        System.out.println(li1.get());
        li1.get();


        List<String> list = Arrays.asList("a","b","c");
        for (String s : list) {
            System.out.print(s);
        }
        // 方法引用
        list.forEach(System.out::print);
    }

    static int get() {
        return 1;
    }

    static String find() {
        return  "find";
    }

    static void exec() {
        find();
    }
}
