/**
 * @Author : LiuYan
 * @create 2021/2/3 14:50
 */
public class IntegerDemo {
    public static void main(String[] args) {
        int a = 10;
        Integer it1 = new Integer(10);
        // 手动通过方法进行类型转换
        Integer it2 = Integer.valueOf(a);
        int i = it1.intValue();
        System.out.println(a==it1);  // ture

        int b = -128; // 将-128赋值给b
        Integer i1 = -128; // 1.基本类型int -128的变量 2.自动装箱int->Integer
        Integer i2 = -128;
        Integer i3 = 128;
        Integer i4 = 128;
        System.out.println(b == i1); // true
        System.out.println(i1 == i2); // true
        System.out.println(i3 == i4); // false
        Integer integer1 = new Integer(-128);
        System.out.println(i1 == integer1); // false

        Double d1 = 1.0;
        Double d2 = 1.0;
        Double d3 = 2.0;
        Double d4 = 2.0;
        System.out.println(d1 == d2); //false
        System.out.println(d3 == d4); // false

        Integer integer = 128;
        int c = integer;
        System.out.println(c == integer); // true
        System.out.println(integer == c); // true

        int d = 10;
        Integer integer2 = d;
        Integer integer3 = 10;
        System.out.println(d == integer2); // true
        System.out.println(integer3 == integer2); // true
        int e = 128;
        Integer integer4 = e;
        Integer integer5 = 128;
        System.out.println(e == integer4); // true
        System.out.println(integer4 == integer5); // false

        Integer integer6 = 128;
        Integer integer7 = new Integer(128);
        System.out.println(integer6 == integer7); // false

    }

}
