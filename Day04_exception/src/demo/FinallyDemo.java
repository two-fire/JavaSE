package demo;

/**
 * @Author : LiuYan
 * @create 2021/2/2 23:10
 *
 * finally:在程序运行过程中，如果处理异常的部分包含finally的处理，那么无论代码是否发生异常，finally内内容总会执行。
 * finally包含的处理逻辑？
 *  1）IO流的关闭操作
 *  2）数据库的连接关闭操作
 *
 *
 */
public class FinallyDemo {
    public static void main(String[] args) {
        test();
    }
    public static void test() {
        try {
            System.out.println(1/10);
            return;
        } catch (Exception e) {
            e.printStackTrace();
            return;
        } finally {
            System.out.println("我是finally处理块");
            return;
        }
    }
}
