package xyz.gzzh.leetcode.learning;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class Student extends Person {
    public int score;
    private int grade;

    public Student() {
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}

class Person {
    public String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

interface Hello {
    void morning(String name);
}

public class ReflectionDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class studentClass = Student.class;

        System.out.println(studentClass.getField("score"));
        System.out.println(studentClass.getDeclaredField("grade"));
        System.out.println(studentClass.getField("name"));

        Object p = new Person("Xiao Ming");
        Class c = p.getClass();
        Field f = c.getDeclaredField("name");
        Object value = f.get(p);
        System.out.println(value); // "Xiao Ming"

        InvocationHandler invocationHandler =  (Object proxy, Method method, Object[] args1) -> {
            System.out.println(method);
            if (method.getName().equals("morning")) {
                System.out.println("Good morning, " + args1[0]);
            }
            return null;
        };

        Hello hello = (Hello) Proxy.newProxyInstance(
                Hello.class.getClassLoader(), // 传入ClassLoader
                new Class[] { Hello.class }, // 传入要实现的接口
                invocationHandler); // 传入处理调用方法的InvocationHandler
        hello.morning("Bob");
    }
}
