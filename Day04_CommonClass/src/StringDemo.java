/**
 * @Author : LiuYan
 * @create 2021/2/3 15:38
 *
 *
 * 注意：常量池在1.7之后，放置在了堆空间之中
 *     字符串的使用：
 *          1. 创建
 *              String str = "abc";
 *              String str2 = new String("abc");
 *              第一种使用比较多。
 *          2. 字符串的本质
 *              字符串本质是字符数组或者叫字符序列
 *              String类是一个final类。所以不可以被继承
 *               使用equals方法比较的是字符数组的每一个位置的值
 */
public class StringDemo {
    public static void main(String[] args) {
        String str = "abc";
        String str2 = new String("abc");
        System.out.println(str == str2); // false 地址空间的比较
        System.out.println(str.equals(str2)); // true
        str2 = str2.intern();
        System.out.println(str == str2); // true
        String str3 = "abc";
        System.out.println(str == str3); // true
        String str4 = new String(new char[]{'a','b','c'});
        System.out.println(str == str4); // false
        System.out.println(str4 == str2); // false

        System.out.println(str.charAt(0)); // a
        // 本质是数组的复制过程
        System.out.println(str.concat("cde")); // abccde
        System.out.println(str);
        str = "abcdefghi";
        System.out.println(str);
        System.out.println(str.lastIndexOf("b",2));
        System.out.println(str.substring(1));
        // 左闭右开
        System.out.println(str.substring(2,4));

        System.out.println("----------");

        String a = "abc";
        String b = "def";
        String c = "abcdef";
//        String d = (a+b).intern(); // c==d ? true
        String d = a+b;
        String e = "abc"+"def";
        /**
         * String重写了hashcode()方法，String类型的hash值是根据字符串的内容来决定的，
         * 并不是内存地址，只要两个String类型的字符串内容一致，那么两者的hashcode就相同。
         */
        System.out.println(d.hashCode());
        System.out.println((a+b).hashCode());
        System.out.println(d==(a+b)); // false a+b此时又会重新new出一个String
        System.out.println((a+b).intern()==c); // true
        System.out.println(d.intern()==c); // true
        System.out.println(c==d); // false
        System.out.println(e==c); // true

        // 返回的是4个对象
        String f = "a" + "b" + "c";
        String a1 ="a";
        String a2 ="b";
        String a3 ="c";
        String f1 = a1+a2+a3;
        System.out.println();
        
    }


}
