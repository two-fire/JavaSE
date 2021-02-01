package lambda;

/**
 * 自定义函数接口
 */
@FunctionalInterface
public interface StudentDao {

    void insert(Student student);
}
