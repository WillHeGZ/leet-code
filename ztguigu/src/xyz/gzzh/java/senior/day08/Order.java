package xyz.gzzh.java.senior.day08;

import java.util.ArrayList;
import java.util.List;

public class Order<T> {
    private String name;
    private Integer orderId;

    private T orderT;

    public Order() {
    }

    public Order(String name, Integer orderId, T orderT) {
        this.name = name;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }

    public <E> List<E> copyListFromArray(E[] arr) {
        List<E> list = new ArrayList<>();

        for (E e : arr) {
            list.add(e);
        }

        return list;
    }
}
