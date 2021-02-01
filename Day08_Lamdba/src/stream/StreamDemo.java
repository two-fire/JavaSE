package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream的生成操作
 */
public class StreamDemo {
    // 通过数组生成
    static void gen1() {
        String[] strs = {"a","b","c","d"};
        // 数组转换为一个Stream
        Stream<String> strs1 = Stream.of(strs);
        /**
         * forEach参数是Consumer<? super T> action
         * Consumer<T>代表一个输入的函数式接口
         * System.out::println是一个实例方法引用
         */
        strs1.forEach(System.out::println);
    }

    // 通过集合生成
    static void gen2() {
        List<String> list = Arrays.asList("1","2","3","4");
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);
    }

    //通过generate()
    static void gen3() {
        /**
         *  generate()返回无限顺序无序流，其中每个元素是由提供的Supplier，无限循环
         *  Supplier，代表一个输出
         */

        Stream<Integer> generate = Stream.generate(() -> 0);
        generate.limit(3).forEach(System.out::println); // 限制3次
    }
    // 使用iterator
    static void gen4() {
        /**
         * iterate()参数是UnaryOperator<T> f，无限循环
         * UnaryOperator<T> f，一个输入一个输出，类型相同
         */
        Stream<Integer> iterate = Stream.iterate(1, x -> x + 1);
        iterate.limit(3).forEach(System.out::println);
    }
    //其他方式
    static void gen5() {
        String str = "abcd";
        IntStream stream = str.chars();
        stream.forEach(System.out::println);
    }

    public static void main(String[] args) {
        //------生成操作-------
        gen1();
        gen2();
        gen3();
        gen4();
        gen5();
        System.out.println("---------------------");
        //------中间操作:如果返回值是Stream对象，意味着是中间操作
        // 取出偶数
        Arrays.asList(1,2,3,4,5).stream()
                .filter((x)->x % 2 == 0).forEach(System.out::println);
        // 求出结果集中的所有偶数的和
        long count = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9).stream()
                .filter(x -> x % 2 == 0).mapToInt(x->x).sum();
        System.out.println(count);
        // 求集合中最大值
        List<Integer> list = Arrays.asList(7,1,2,3,4,5,6);
        Optional<Integer> max = list.stream().max((a, b) -> a - b);
        System.out.println(max.get());
        // 求集合中最小值
        System.out.println(list.stream().min((a,b)->a-b).get());

        Optional<Integer> any = list.stream().filter(x -> x % 2 == 0).findAny();
        System.out.println(any.get());

        // 如果没有这个值会报错：no value present
        Optional<Integer> first = list.stream().filter(x -> x % 2 == 0).findFirst();
        System.out.println(first.get());

        Stream<Integer> integerStream = list.stream().filter(i -> {
            System.out.println("运行代码"); // 不会被打印  延迟执行 一直等于stream一直不执行
            return i % 2 == 0;
        });
        System.out.println(integerStream);
        System.out.println(integerStream.findAny().get());

        System.out.println("---------------");
        //获取最大值和最小值，但是不使用min和max方法
        Optional<Integer> min = list.stream().sorted().findFirst();
        System.out.println(min.get());
        Optional<Integer> max2 = list.stream().sorted((a,b)->b-a).findFirst();
        System.out.println(max2.get());

        //按照自然序排序
        Arrays.asList("java","c#","python","scala","jee").stream().sorted().forEach(System.out::println);
        //按照长度排序
        System.out.println("+++++++++++");
        Arrays.asList("java","c#","python","scala","jee").stream().sorted((a,b)->a.length()-b.length()).forEach(System.out::println);

        System.out.println("=============");

        // 想将集合中的元素进行过滤同时返回一个集合对象
        List<Integer> collect = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        collect.forEach(System.out::println);

        // 去重操作
        Arrays.asList(1,2,2,3,3,3,4,5,2).stream().distinct().forEach(System.out::print);
        System.out.println();
        Arrays.asList(1,2,2,3,3,3,4,5,2).stream().collect(Collectors.toSet()).forEach(System.out::print);
        System.out.println();
        // 打印20~30这样的集合数据
        Stream.iterate(1,x->x+1).limit(50).skip(20).limit(10).forEach(System.out::print);
        System.out.println();
        // 字符串值求和
        String str = "11,22,33,44,55";
        System.out.println(Stream.of(str.split(",")).mapToInt(x -> Integer.valueOf(x)).sum());
        System.out.println(Stream.of(str.split(",")).mapToInt(Integer::valueOf).sum());
        System.out.println(Stream.of(str.split(",")).map(x -> Integer.valueOf(x)).mapToInt(x -> x).sum());
        System.out.println(Stream.of(str.split(",")).map(Integer::valueOf).mapToInt(x -> x).sum());

        // 创建一组自定义对象
        String str2 = "java,scala,python";
        Stream.of(str2.split(",")).map(x->new Person(x)).forEach(System.out::print);
        System.out.println();
        Stream.of(str2.split(",")).map(Person::new).forEach(System.out::print);
        System.out.println();
        Stream.of(str2.split(",")).map(x->Person.build(x)).forEach(System.out::print);
        System.out.println();
        Stream.of(str2.split(",")).map(Person::build).forEach(System.out::print);
        System.out.println();
        // 将str中每个数值都打印出来同时算出最终的求和结果
        // peek(IntConsumer action)返回由该流的元素组成的流，另外在从生成的流中消耗元素时对每个元素执行提供的操作
        System.out.println(Stream.of(str.split(",")).peek(System.out::println).mapToInt(Integer::valueOf).sum());

        // list：{7,1,2,3,4,5,6}
        // allMatch(IntPredicate predicate)返回此流的所有元素是否与提供的谓词匹配
        System.out.println(list.stream().allMatch(x -> x % 2 == 0));
        System.out.println(list.stream().anyMatch(x -> x % 2 == 0)); // 任何一个true
    }
}
