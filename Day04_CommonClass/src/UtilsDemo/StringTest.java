package UtilsDemo;

/**
 * @Author : LiuYan
 * @create 2021/2/4 8:43
 */
public class StringTest {
    public static void main(String[] args) {
        String s = "abcdef";
        System.out.println(StringUtils.isBlank(s)); // false
        System.out.println(StringUtils.isEmpty(" ")); // true
        CharSequence s1 = new String(" ");
        System.out.println(StringUtils.isEmpty(s1));// false
        System.out.println(StringUtils.isEmpty("","  ")); // true
        String s2 = StringUtils.nullStrToEmpty(null);
        System.out.println(s2.length()); // 0
        System.out.println(StringUtils.capitalizeFirstLetter("a1d a")); // A1d a
        System.out.println(StringUtils.utf8Encode("啊"));// %E5%95%8A
        System.out.println(StringUtils.htmlEscapeCharsToString("&lt;")); // <
        System.out.println(StringUtils.fullWidthToHalfWidth("a，b")); // a,b
        System.out.println(StringUtils.halfWidthToFullWidth("a,b")); // a，b
        System.out.println(StringUtils.replaceBlanktihuan("a b\tc")); // abc
        System.out.println(StringUtils.replace("accd",'c','e')); // aeed
        for (String s3 : StringUtils.split("abbd", 'b')) {
            System.out.print(s3+" ");
        } // a  d
        System.out.println();
        System.out.println(StringUtils.removeChar("avvc",'v')); // ac
        System.out.println(StringUtils.removeChar("avvc",3)); // avv
        System.out.println(StringUtils.removeChar("avvc",3,'c')); // avv
        System.out.println(StringUtils.filterBlank(" "));
        System.out.println(StringUtils.toUpperCase("abc",0,1)); // Abc
        System.out.println(StringUtils.startsWithIgnoreCase(" abc"," ab")); // true
        System.out.println(StringUtils.checkLength("abc",2,"ee")); // abee
        System.out.println(StringUtils.checkLength("abc",2)); // abe...
        System.out.println(StringUtils.htmlRemoveTag("<br/>he")); // he
    }
}
