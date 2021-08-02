package xyz.gzzh.java.senior.day10;

import org.junit.Test;

import java.io.*;

public class ObjectStreamTest {
    @Test
    public void test1() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.dat"));

        oos.writeObject(new String("海盗"));
        oos.writeObject(new Person("何先生",21));
        oos.flush();
        oos.close();
    }

    @Test
    public void test2() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.dat"));

        String s = (String)ois.readObject();
        System.out.println(s);
        Person person = (Person)ois.readObject();
        System.out.println(person);
    }
}
