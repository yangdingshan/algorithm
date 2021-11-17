package com.yangdingshan.solution143;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangdingshan
 * @Date: 2021/11/17 14:34
 * @Description:
 */
public class Solution {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Solution solution = new Solution();
        solution.reorderList2(node1);
        while (node1 != null) {
            System.out.println(node1.val);
            node1 = node1.next;
        }

    }

    public void reorderList2(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    private void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_temp;
        ListNode l2_temp;
        while (l1 != null && l2 != null) {
            l1_temp = l1.next;
            l2_temp = l2.next;

            l1.next = l2;
            l1 = l1_temp;

            l2.next = l1;
            l2 = l2_temp;
        }

    }

    private ListNode reverseList(ListNode l2) {
        ListNode pre = null;
        ListNode cuur = l2;
        while (cuur != null) {
            ListNode temp = cuur.next;
            cuur.next = pre;
            pre = cuur;
            cuur = temp;
        }
        return pre;
    }

    private ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode last = head;
        while (last.next != null && last.next.next != null) {
            slow = slow.next;
            last = last.next.next;
        }
        return slow;
    }


    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
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
