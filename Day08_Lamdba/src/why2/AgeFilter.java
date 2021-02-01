package why2;

import why.Student;

public class AgeFilter implements StudentFilter{
    @Override
    public boolean compare(Student student) {
        return student.getAge() > 14;
    }
}
