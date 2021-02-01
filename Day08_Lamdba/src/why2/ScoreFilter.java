package why2;

import why.Student;

public class ScoreFilter implements StudentFilter{
    @Override
    public boolean compare(Student student) {
        return student.getScore() > 75;
    }
}
