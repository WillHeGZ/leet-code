package xyz.gzzh.leetcode.application;

/*
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * */
public class MergeTwoLists {
    private static class ListNode {
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

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = null;
        while (l1 != null) {
            int l1Value = l1.val;

            while (l2 != null) {
                int l2Value = l2.val;
                int l2NextValue = l2.next.val;

                if (l1Value >= l2Value && l1Value <= l2NextValue) {
                    l2.setNext(new ListNode(l1Value, l2.next));
                }

                l2 = l2.next;
            }

            l1 = l1.next;
        }

        return l2;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));

        ListNode result = mergeTwoLists(l1, l2);

        while (result.next != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
