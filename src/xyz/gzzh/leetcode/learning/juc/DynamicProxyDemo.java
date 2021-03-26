package xyz.gzzh.leetcode.learning.juc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface IPrinter {
    void print();
}

class Printer implements IPrinter {

    @Override
    public void print() {
        System.out.println("打印了");
    }
}

class PrinterProxy implements IPrinter {
    private IPrinter printer;

    public PrinterProxy(IPrinter printer) {
        this.printer = printer;
    }

    @Override
    public void print() {
        printer.print();
    }
}

class ProxyHandler implements InvocationHandler {

    private Object targetObject;//被代理的对象

    //将被代理的对象传入获得它的类加载器和实现接口作为Proxy.newProxyInstance方法的参数。
    public Object newProxyInstance(Object targetObject) {
        this.targetObject = targetObject;
        //targetObject.getClass().getClassLoader()：被代理对象的类加载器
        //targetObject.getClass().getInterfaces()：被代理对象的实现接口
        //this 当前对象，该对象实现了InvocationHandler接口所以有invoke方法，通过invoke方法可以调用被代理对象的方法
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("记录日志");
        return method.invoke(targetObject, args);
    }
}

public class DynamicProxyDemo {
    public static void main(String[] args) {
        //静态代理
        PrinterProxy printerProxy = new PrinterProxy(new Printer());
        printerProxy.print();

        //动态代理
        ProxyHandler proxyHandler = new ProxyHandler();
        IPrinter printer = (IPrinter) proxyHandler.newProxyInstance(new Printer());
        printer.print();
    }
}
