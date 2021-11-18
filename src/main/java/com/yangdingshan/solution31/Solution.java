package com.yangdingshan.solution31;

/**
 * @Author: yangdingshan
 * @Date: 2021/11/18 14:22
 * @Description:
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {3,2,1};
        Solution solution = new Solution();
        solution.nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int i = nums.length  - 1;
        while (i > 0) {
            if (nums[i] > nums[i-1]) {
                break;
            }
            i--;
        }


        if (i != 0) {
            int j = nums.length - 1;
            while (j > i) {
                if (nums[j] > nums[i-1]) {
                    break;
                }
                j--;
            }
            swap(nums, i-1, j);

        }
        reverse(nums, i, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int i1) {
        while (i<i1) {
            swap(nums, i, i1);
            i++;
            i1--;
        }

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
