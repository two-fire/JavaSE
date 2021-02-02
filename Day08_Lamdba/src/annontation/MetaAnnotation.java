package annontation;

import java.lang.annotation.*;

public class MetaAnnotation {
    @MyAnnotation(age = 12,id = 3,likes = {"book","lol","movie"})
    public void test(){};
}
// Target用来描述注解的使用范围,类、方法、变量、包等类型
@Target({ElementType.METHOD,ElementType.TYPE})
// Retention表示当前注解适用于什么环境，是源码级别还是类级别还是运行时环境，一般都是运行时环境
@Retention(RetentionPolicy.SOURCE)
// 表示该注解是否显示在javadoc中
@Documented
// 表示该注解是否能否能够被继承
@Inherited
@interface MyAnnotation{

    // 定义的方式看起来像方法，但Retention表示当前注解适用于什么环境，是源码级别还是类级别还是运行时环境，一般都是运行时环境是实际上使用在：使用注解的时候，填写的参数的名称，默认名称是value
    // 当我们在自定义注解中填写的所有方法，都需要在使用注解的时候添加值，很麻烦，因此包含默认值
    String name() default "zhangs";
    int age();
    int id();
    String[] likes();
}