package xyz.gzzh.leetcode.learning.datastructure;

import java.util.ArrayList;
import java.util.List;

import static xyz.gzzh.leetcode.learning.datastructure.SingleLinkedList.reverseNode;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList<String> singleLinkedList = new SingleLinkedList();

        SingleLinkedList.Node node1 = new SingleLinkedList.Node(1, "aaa");

        SingleLinkedList.Node node2 = new SingleLinkedList.Node(2, "bbb");
        SingleLinkedList.Node node3 = new SingleLinkedList.Node(3, "ccc");

        SingleLinkedList.Node node4 = new SingleLinkedList.Node(4, "ddd");

        singleLinkedList.addByOrder(node1);
        singleLinkedList.addByOrder(node4);
        singleLinkedList.addByOrder(node2);
        singleLinkedList.addByOrder(node4);
        singleLinkedList.addByOrder(node3);
        singleLinkedList.addByOrder(node3);

        singleLinkedList.delete(node1);

        SingleLinkedList.Node node2Update = new SingleLinkedList.Node(2, "asdfasdf");
        singleLinkedList.update(node2Update);

        System.out.println("原单链表");
        singleLinkedList.list();

        SingleLinkedList.Node node = reverseNode(singleLinkedList.getHead());
        System.out.println("反转后");
        System.out.println(node.toString());

        List<String> list = new ArrayList<>();
        list.add("");

    }
}


class SingleLinkedList<E> {
    private Node<E> head = new Node(0, null);

    public Node<E> getHead() {
        return head;
    }

    public static SingleLinkedList.Node reverseNode(SingleLinkedList.Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }


        return null;
    }

    public void addTail(Node<E> node) {
        Node temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }

            temp = temp.next;
        }

        temp.next = node;
    }

    public void addByOrder(Node node) {
        Node temp = head;

        while (true) {
            if (temp.next == null) {
                temp.next = node;
                break;
            }

            if (temp.next.no == node.no) {
                System.out.println("已存在");
                break;
            } else if (temp.next.no > node.no) {
                node.next = temp.next;
                temp.next = node;
                break;
            }

            temp = temp.next;
        }
    }

    public void delete(Node node) {
        Node temp = head;

        while (true) {
            if (temp.next == null) {
                break;
            }

            if (temp.next.no == node.no) {
                temp.next = temp.next.next;
                break;
            }

            temp = temp.next;
        }
    }

    public void update(Node node) {
        Node temp = head;

        while (true) {
            if (temp.next == null) {
                break;
            }

            if (temp.next.no == node.no) {
                temp.next.data = node.data;
                break;
            }

            temp = temp.next;
        }
    }

    public void list() {
        Node temp = head;

        while (true) {
            if (temp.next == null) {
                break;
            }

            temp = temp.next;
            System.out.println(temp);
        }
    }

    static class Node<E> {
        private int no;
        private E data;
        private Node next;

        public Node(int no, E data) {
            this.no = no;
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "no=" + no +
                    ", data=" + data +
                    '}';
        }
    }
}
