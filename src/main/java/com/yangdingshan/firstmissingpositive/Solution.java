package com.yangdingshan.firstmissingpositive;

import java.util.Arrays;

/**
 * @Author: yangdingshan
 * @Date: 2022/12/29 11:31
 * @Description:
 */
public class Solution {

    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int first = 1;
        for (int num : nums) {
            if (num <= 0) {
                continue;
            }
            if (num > first) {
                break;
            }
            if (num == first) {
                first++;
            }
        }
        return first;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,8,9,11,12};
        System.out.println(new Solution().firstMissingPositive(nums));
    }

}
