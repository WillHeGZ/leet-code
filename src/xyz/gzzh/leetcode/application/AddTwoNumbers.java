package xyz.gzzh.leetcode.application;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(4, new ListNode(5, new ListNode(6, null)));

        ListNode l2 = new ListNode(7, new ListNode(8, new ListNode(9, null)));

        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println(listNode);

    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            throw new RuntimeException("l1 or l2 must be not null");
        }

        ListNode result = null;
        ListNode tail = null;
        int in = 0;

        while (l1 != null || l2 != null) {
            int n1 = 0;
            int n2 = 0;

            if (l1 != null) {
                n1 = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                n2 = l2.val;
                l2 = l2.next;
            }

            int sum = n1 + n2 + in;
            int thisNodeVal = sum % 10;
            in = sum / 10;

            if (result == null) {
                result = tail = new ListNode(thisNodeVal);
            } else {
                tail = tail.next = new ListNode(thisNodeVal);
            }
        }

        if (in > 0) {
            tail.next = new ListNode(in);
        }

        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}
