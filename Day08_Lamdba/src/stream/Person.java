package stream;

public class Person {
    private String name;
    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    /**
     *
     * @param name
     * @return
     */
    public static Person build(String name) {
        Person p = new Person();
        p.setName(name);
        return p;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @SuppressWarnings(value = "all") // 忽略对应的警告信息
    @Deprecated // 当前方法已经过时了
    public void show() {
        System.out.println("show");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {

        Person p = new Person();
        p.show();
    }
}
