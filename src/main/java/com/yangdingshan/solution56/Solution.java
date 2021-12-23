package com.yangdingshan.solution56;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: yangdingshan
 * @Date: 2021/12/23 16:25
 * @Description:
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] merge = solution.merge(intervals);
        System.out.println(merge);
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        Deque<int[]> merged = new LinkedList<>();
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (merged.isEmpty() || merged.peek()[1] < left) {
                merged.push(new int[]{left, right});
            } else {
                merged.peek()[1] = Math.max(merged.peek()[1], right);
            }
        }
        //Collections.reverse((List<?>) merged);
        return merged.toArray(new int[merged.size()][]);
    }
}
