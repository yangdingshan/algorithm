package com.yangdingshan.solution199;

import com.yangdingshan.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @Author: yangdingshan
 * @Date: 2021/11/15 11:01
 * @Description:
 */
public class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Queue<TreeNode> offer = new LinkedList<TreeNode>();
        Queue<Integer> depth = new LinkedList<Integer>();
        Map<Integer, Integer> rightValue = new HashMap<Integer, Integer>(16);
        offer.offer(root);
        depth.offer(0);
        while (!offer.isEmpty()) {
            TreeNode node = offer.poll();
            Integer dep = depth.poll();
            rightValue.put(dep, node.val);
            if (node.left != null) {
                offer.offer(node.left);
                depth.offer(dep + 1);
            }
            if (node.right != null) {
                offer.offer(node.right);
                depth.offer(dep + 1);
            }
        }
        return rightValue.values().stream().collect(Collectors.toList());
    }

    public List<Integer> rightSideView1(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Map<Integer, Integer> rightValue = new HashMap<Integer, Integer>(16);
        Deque<TreeNode> dequeNode = new ArrayDeque<>();
        Deque<Integer> dequeDepth = new ArrayDeque<>();
        dequeNode.push(root);
        dequeDepth.push(0);
        while (!dequeNode.isEmpty()) {
            TreeNode node = dequeNode.pop();
            Integer depth = dequeDepth.pop();
            if (!rightValue.containsKey(depth)) {
                rightValue.put(depth, node.val);
            }
            if (node.left != null) {
                dequeNode.push(node.left);
                dequeDepth.push(depth + 1);
            }
            if (node.right != null) {
                dequeNode.push(node.right);
                dequeDepth.push(depth + 1);
            }
        }
        return new ArrayList<>(rightValue.values());
    }

}
