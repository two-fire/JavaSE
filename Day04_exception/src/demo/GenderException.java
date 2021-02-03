package demo;

/**
 * @Author : LiuYan
 * @create 2021/2/3 10:35
 *
 * 自定义异常：
 *   在Java的API中提供了丰富异常类，但有时候不满足需求，就需要自定义。
 *   步骤：
 *      1. 继承Exception类
 *      2. 自定义实现构造方法
 *      3. 需要使用的时候，使用throw new自定义异常的名称
 *   什么时候需要自定义异常？
 *      一般情况下不需要，但在公司要求明确，或者要求异常格式规范统一的时候是要自己实现的
 */
public class GenderException extends Exception {
    public GenderException() {
        System.out.println("性别异常");
    }

    public GenderException(String msg) {
        System.out.println(msg);
    }
}
