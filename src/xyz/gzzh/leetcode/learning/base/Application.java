package xyz.gzzh.leetcode.learning.base;

public class Application {

    public static void main(String[] args) {
        Student s1 = new Student();
        Person s2 = new Student();

        Person s3 = new Person();

        s1.run();
        s1.go();;

        s2.run();
        ((Student) s2).go();

        System.out.println(s1 instanceof Student);
        System.out.println(s1 instanceof Person);
        System.out.println(s1 instanceof Object);


        ((Student)s3).run();
    }
}
