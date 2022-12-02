package com.leetCodeTasks;

import java.util.Arrays;

/**
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 * <p>
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */
public class TwoSum_1 {

    public static void main(String[] args) {

        int[] array = new int[]{1, 8, 9, 4, 12, 7, 6, 19, 2};
        int[] array2 = new int[]{-5, 9, 17, 44, 3, 2, 4};
        int[] array3 = new int[]{4, 3, 5};
        System.out.println(Arrays.toString(twoSum(array3, 8)));
    }

    public static int[] twoSum(int[] nums, int target) {

        int[] answer = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j >= 0; j--) {
                if (nums[i] + nums[j] == target && i != j) {
                    answer[0] = i;
                    answer[1] = j;
                    break;
                }
            }
        }
        return answer;
    }
}
