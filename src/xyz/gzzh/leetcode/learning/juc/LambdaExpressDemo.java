package xyz.gzzh.leetcode.learning.juc;

@FunctionalInterface
interface Foo {
    //    public void sayHello();
    public int add(int x, int y);

    public default int mul(int x, int y) {
        return x * y;
    }

    public default int mu2(int y) {
        return y;
    }

    public static int div(int x, int y) {
        return x / y;
    }
}

/*
 * 1 拷贝小括号，写死右箭头，落地大括号
 * 2 @FunctionalInterface
 * 3    多个default
 * 4    多个static
 * */
public class LambdaExpressDemo {
    public static void main(String[] args) {
        /*Foo foo = new Foo() {
            @Override
            public void sayHello() {
                System.out.println("jjjjj");
            }
        };

        foo.sayHello();*/

//        Foo foo = () -> {System.out.println("dddddd");};
        Foo foo = (int x, int y) -> {
            return x + y;
        };

        System.out.println(foo.add(1, 2));

        System.out.println(foo.mul(1, 2));

        System.out.println(Foo.div(1, 2));

    }
}
