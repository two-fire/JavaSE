package why2;

import why.Student;

import java.util.ArrayList;

/**
 * 扩展性好,但还需要创建对应的子类
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
        getByFilter(list, new AgeFilter());
        System.out.println("----------");
        //查找分收大于75的学色
        getByFilter(list, new ScoreFilter());
    }
    public static void getByFilter(ArrayList<Student> students, StudentFilter filter) {
        ArrayList<Student> list = new ArrayList<>();
        for (Student stu : students) {
            if (filter.compare(stu)) {
                list.add(stu);
            }
        }
        printStudent(list);
    }
    public static void printStudent(ArrayList<Student> students) {
        for (Student stu : students) {
            System.out.println(stu);
        }
    }
}
