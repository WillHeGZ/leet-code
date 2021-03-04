package xyz.gzzh.leetcode.learning;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/*
* CAS
*   compare and swap
*   对比并交换
*
*   ABA问题
*
* */
public class AtomicIntegerDemo {
    private static class User {
        private String name;
        private Integer age;

        public User() {
        }

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(3);

        boolean b = atomicInteger.compareAndSet(3, 4);
        System.out.println("boolean : " + b + ",value : " + atomicInteger.get());
        b = atomicInteger.compareAndSet(3, 4);
        System.out.println("boolean : " + b + ",value : " + atomicInteger.get());

        int andIncrement = atomicInteger.getAndIncrement();
        System.out.println("value : " + andIncrement + " ; get value : " + atomicInteger.get());
        int i = atomicInteger.incrementAndGet();
        System.out.println("value : " + i + " ; get value : " + atomicInteger.get());

        User zs = new User("zs", 11);
        User ls = new User("ls", 12);
        AtomicStampedReference<User> atomicReference = new AtomicStampedReference<>(zs, 1);

        boolean b1 = atomicReference.compareAndSet(zs, ls, 1, 2);

        System.out.println("boolean value : " + b1 + " ; user : " + atomicReference.getReference().toString() + " ; stamp : " + atomicReference.getStamp());
    }
}
