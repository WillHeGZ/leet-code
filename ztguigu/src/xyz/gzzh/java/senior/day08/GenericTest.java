package xyz.gzzh.java.senior.day08;

import org.junit.Test;

import java.util.*;

public class GenericTest {

    @Test
    public void test1() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //增强for循环
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    @Test
    public void test2() {
        Map<String, Integer> map = new HashMap<>();

        map.put("key1", 123123);
    }

    @Test
    public void test3() {
        //建议：实例化是指明类的泛型
        Order<Integer> order = new Order();
        order.setOrderT(123);
//        order.setOrderT("12123");


        SubOrder<String> subOrder = new SubOrder<>();
        subOrder.setOrderT("1231231");

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

//        list1 = list2;

        String[] arr = new String[]{"12", "344"};
        List<String> strings = subOrder.copyListFromArray(arr);
        System.out.println(strings);

    }
}
