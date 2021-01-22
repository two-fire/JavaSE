package streamtype;

import java.io.Serializable;

/**
 * 如果需要通过io流进行传输，必须要实现以下两点：
 * 1. 实现序列化接口。
 * 2. 类中声明serialVersionUID，值大小无所谓
 * transient：使用它修饰的变量，在进行序列化的时候，不会被序列化
 */
public class Person implements Serializable {
    long serialVersionUID = 1L;
    private int id;
    private  String name;
    transient private String pwd;  // transient瞬时，pwd无法被读取出来

    public Person() {
    }

    public Person(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
