package com.yangdingshan.solution23;

/**
 * @Author: yangdingshan
 * @Date: 2021/11/15 15:44
 * @Description:
 */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution = new Solution1();

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode l1 = null;
        for (ListNode l : lists) {
            l1 = mergeTwoLists(l1, l);
        }
        return l1;
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode head = new ListNode();
        ListNode tail = head, aPre = l1, bPre = l2;
        while (aPre != null && bPre !=null) {
            if (aPre.val < bPre.val) {
                tail.next = aPre;
                aPre = aPre.next;
            } else {
                tail.next = bPre;
                bPre = bPre.next;
            }
            tail = tail.next;
        }
        tail.next = aPre != null ? aPre : bPre;
        return head.next;
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
    }
}
