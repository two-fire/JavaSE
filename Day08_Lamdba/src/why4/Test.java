package why4;

import why.Student;
import why2.StudentFilter;

import java.util.ArrayList;

/**
 * lambda表达式
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("张三", 14, 67));
        list.add(new Student("李四", 13, 89));
        list.add(new Student("王五", 15, 97));
        list.add(new Student("zhaoliu", 12, 63));
        list.add(new Student("maqi", 17, 75));
        getByFilter(list, (e)->e.getAge() > 14);
        System.out.println("--------------");
        getByFilter(list, (e)->e.getScore() > 75);
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
