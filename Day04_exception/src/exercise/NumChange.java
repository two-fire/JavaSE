package exercise;

/**
 * @Author : LiuYan
 * @create 2021/2/2 22:49
 *
 * 编写数据转换类，实现将参数转换为整型数据后输出
 * 编写测试类，调用数据转换方法，传参分析
 */
public class NumChange {
    public static void stringToInt(String s) {
        try {
            int i = Integer.parseInt(s);
            System.out.println("转换结果："+i);
        } catch (NumberFormatException e) {
            System.out.println("数据格式转换异常！");
        } catch (Exception e) {
            System.out.println("出错！");
        } finally {
            System.out.println("转换结束");
        }
    }

    public static void main(String[] args) {
        stringToInt(new String("a"));
        System.out.println("------------");
        stringToInt(new String("20"));
    }
}
