package com.leetCodeTasks;

/**
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 *
 * Example 1:
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 */
public class PalindromeNumber_2 {

    public static void main(String[] args) {

        int x = 1000021;
        System.out.println(isPalindrome(x));
    }

    public static boolean isPalindrome(int x) {
        boolean answer = false;
        if (x < 0) return false;
        if (x < 10) return true;
        String temp = String.valueOf(x);
        for (int i = 0; i < temp.length() / 2; i++) {
            if (temp.charAt(i) == temp.charAt(temp.length() - i - 1)) {
                answer = true;
            } else {
                return false;
            }
        }
        return answer;
    }
}
