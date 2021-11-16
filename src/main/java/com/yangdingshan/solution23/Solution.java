package com.yangdingshan.solution23;

/**
 * @Author: yangdingshan
 * @Date: 2021/11/15 15:44
 * @Description:
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

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
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
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
