package xyz.gzzh.java.senior.day11;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {

    @Test
    public void test1() throws Exception {
        Class<Person> clazz1 = Person.class;
        Class<? extends Person> clazz2 = new Person(1L).getClass();
        Class<?> clazz = Class.forName("xyz.gzzh.java.senior.day11.Person");

        for (Annotation annotation : clazz.getDeclaredAnnotations()) {
            System.out.println(annotation);
        }

        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Person person = (Person) constructor.newInstance();
        System.out.println(person);
        person = (Person) clazz.newInstance();
        System.out.println(person);
        Constructor<?> constructor1 = clazz.getDeclaredConstructor(Long.class, String.class, int.class);
        constructor1.setAccessible(true);
        person = (Person) constructor1.newInstance(12L, "Tom", 34);
        System.out.println(person);
        Field id = clazz.getDeclaredField("id");
        id.setAccessible(true);
        id.set(person, new Long(12));
        for (Annotation annotation : id.getDeclaredAnnotations()) {
            System.out.println(annotation);
        }
        System.out.println(id.getDeclaredAnnotation(MyAnnotation.class));
        System.out.println(id.get(person));
        System.out.println(person);

        //属性
        Field age = clazz.getDeclaredField("age");
        age.setAccessible(true);
        age.setInt(person, 1);
        System.out.println(age.getInt(person));
        System.out.println(person);

        Field key = clazz.getDeclaredField("KEY");
        key.setAccessible(true);
        System.out.println(key.get(null));

        Method privateMethod = clazz.getDeclaredMethod("privateMethod", String.class);
        privateMethod.setAccessible(true);
        String returnStr = (String) privateMethod.invoke(person, "私人方法");
        System.out.println(returnStr);
        for (Annotation annotation : privateMethod.getDeclaredAnnotations()) {
            System.out.println(annotation);
        }
    }
}
