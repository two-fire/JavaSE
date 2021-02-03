package demo;

/**
 * @Author : LiuYan
 * @create 2021/2/3 9:48
 *
 * 声明异常 throws
 * 在异常情况出现的时候，可以使用try-catch-finally的方法处理异常，也可以将异常向外抛出，由外部进行处理
 *     1. 在方法调用过程中，可能存在n多个方法之间的调用。此时假如每个方法中都包含了异常情况
 *        那么就需要在每个方法中都进行try-catch。另外一种比较简单的方式，就是在方法最外层调用处理一次即可。
 *        使用throws方法，对所有执行过程中的所有方法出现的异常进行统一集中处理。
 *     2. 如何判断使用try catch还是throws
 *          最稳妥方式是在每个方法中都进行异常的处理。
 *          偷懒的方式是判断在整个调用的过程中，外层的调用方法是否有对异常的处理。如果有直接使用throws，
 *           如果没有，就要使用try catch。
 *
 * 抛出异常 throw
 *
 */
public class Exception2 {
    public static void main(String[] args) {

        try {
            show();
        } catch (GenderException e) {
            e.printStackTrace();
        }
        System.out.println("hehe");
    }

    public static void show() throws GenderException{
        String gender="1234";
        if (gender.equals("man")) {
            System.out.println("man");
        } else if (gender.equals("woman")) {
            System.out.println("woman");
        } else {
            //如果错误向外抛，main中会对异常进行捕获，捕获的异常信息就是下面这句话
//            throw new Exception("性别出现错误");
            throw new GenderException("Gender is wrong");
        }
    }

    public static void  test1() throws Exception {
        System.out.println(1/0);
    }
    public static void  test2() throws Exception {
        test1();
        System.out.println(100/0);
    }
    public static void  test3() throws Exception {
        test2();
    }
    public static void  test4() throws Exception {
        test3();
    }
}
