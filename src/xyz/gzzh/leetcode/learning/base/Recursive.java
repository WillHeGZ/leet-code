package xyz.gzzh.leetcode.learning.base;

public class Recursive {
    public static void main(String[] args) {
        Node node = new Node("1", new Node("2", new Node("3", null)));


        String s = takeNode(node);
        System.out.println(s);
    }

    private static String takeNode(Node node) {
        String nodeString = node.getValue();
        if (node.getNext() != null) {
            nodeString = nodeString + "," + takeNode(node.getNext());
        }

        return nodeString;
    }

    static class Node {
        private String value;
        private Node next;

        public Node() {
        }

        public Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
