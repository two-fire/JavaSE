package why;

import java.util.ArrayList;

/**
 * 为啥要使用lambda表达式？
 *  下面案例没有用，有重复代码，需要优化。见why2
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("张三",14,67));
        list.add(new Student("李四",13,89));
        list.add(new Student("王五",15,97));
        list.add(new Student("zhaoliu",12,63));
        list.add(new Student("maqi",17,75));
        // 查找年龄大于14的学生
        findByAge(list);
        System.out.println("----------");
        //查找分收大于75的学色
        findByScore(list);
    }
    public static void findByAge(ArrayList<Student> students) {
        ArrayList<Student> list = new ArrayList<>();
        for (Student stu:students) {
            if (stu.getAge() > 14) {
                list.add(stu);
            }
        }
        for (Student stu :
                list) {
            System.out.println(stu);
        }
    }
    public static void findByScore(ArrayList<Student> students) {
        ArrayList<Student> list = new ArrayList<>();
        for (Student stu:students) {
            if (stu.getScore() > 75) {
                list.add(stu);
            }
        }
        for (Student stu :
                list) {
            System.out.println(stu);
        }
    }
}
