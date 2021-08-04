package xyz.gzzh.java.senior.day11;

@MyAnnotation(value = "i am class")
public class Person {
    @MyAnnotation(value = "i am field")
    private Long id;
    String name;
    public int age;

    private final static String KEY = "静态变量_key";

    public Person() {
    }

    public Person(Long id) {
        this.id = id;
    }

    Person(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @MyAnnotation(value = "i am method")
    private String privateMethod(String name) {
        return name + " " + id;
    }

    public String publicMethod(String name) {
        return name + 2;
    }

    String defaultMethod(String name) {
        return name + 3;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
