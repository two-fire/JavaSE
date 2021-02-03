package demo;

/**
 * @Author : LiuYan
 * @create 2021/2/2 23:41
 */
public class TryTest {
    public static void main(String[] args) {
        System.out.println(test());
    }

    private static int test() {
        int num = 10;
        try {
            System.out.println("try");
            return num+=80;
        } catch (Exception e) {
            System.out.println("error");
        } finally {
            if (num > 20) {
                System.out.println("num>20: "+num);
            }
            System.out.println("finally");
            num = 100;
        }
        return num;
    }

}
