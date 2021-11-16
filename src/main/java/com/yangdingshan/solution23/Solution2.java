package com.yangdingshan.solution23;

/**
 * @Author: yangdingshan
 * @Date: 2021/11/15 15:44
 * @Description:
 */
public class Solution2 {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        ListNode[] lists = new ListNode[3];
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        lists[0] = node1;
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;
        lists[1] = node4;
        ListNode node7 = new ListNode(2);
        node7.next = new ListNode(6);
        lists[2] = node7;
        ListNode listNode = solution.mergeKLists(lists);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);

    }

    public ListNode merge(ListNode[] lists, int l, int r) {
       if (l == r) {
           return lists[l];
       }
       if (l > r) {
           return null;
       }
       int mid = (l + r) >> 1;
       return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
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
