package xyz.gzzh.leetcode.learning;

public class Test {
    static {
        System.out.println("静态块");
    }
    public static Test test1 = new Test();
    public static Test test2 = new Test();

    public Test() {
        System.out.println("无参构造函数");
    }

    {
        System.out.println("构造块");
    }

    public static void main(String[] args) {
        Test test = new Test();
    }
}
