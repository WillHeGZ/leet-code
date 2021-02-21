package xyz.gzzh.leetcode.application;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(4, new ListNode(5, new ListNode(6, null)));

        ListNode l2 = new ListNode(7, new ListNode(8, new ListNode(9, null)));

        addTwoNumbers(l1, l2);

    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            throw new RuntimeException("l1 or l2 must be not null");
        }

        String dataOne = "";
        while (l1 != null) {
            dataOne = dataOne.concat(String.valueOf(l1.val));
            l1 = l1.next;
        }

        String dataTwo = "";

        while (l2 != null) {
            dataTwo = dataTwo.concat(String.valueOf(l2.val));
            l2 = l2.next;
        }

        System.out.println(dataOne + "  " + dataTwo);
        return null;
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

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
