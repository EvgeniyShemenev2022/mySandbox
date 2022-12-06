package com.leetCodeTasks;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters.
 */
public class LongestCommonPrefix_4 {

    public static void main(String[] args) {

        String[] strs = new String[]{"flower", "flow", "flight"};
        String[] strs1 = new String[]{"dog", "dracecar", "dcar"};
        String[] strs2 = new String[]{"", ""};

        System.out.println(longestCommonPrefix(strs2));
    }

    public static String longestCommonPrefix(String[] strs) {

        // соответственно условиям задачи
        if (strs.length == 1) return strs[0];

        char[] prefix = new char[200];

        int count = 0;
        boolean wordEnd = true;

        while (wordEnd) {
            char temp = '\0';
            for (String elem : strs) {
                // проверяем длину каждого слова
                if (elem.length() < 1) return "";
                if (elem.length() < count + 1) {
                    wordEnd = false;
                    break;
                }
                // ищем совпадения букв
                if (temp == '\0') {
                    temp = elem.charAt(count);
                } else if (temp != elem.charAt(count)) {
                    wordEnd = false;
                }
            }
            // чтобы прерваный цикл не успел записать в массив крайнюю букву
            if (wordEnd) {
                prefix[count] = temp;
                count++;
            }
        }
        String answer = String.valueOf(prefix).substring(0, count);
        if (answer.length() < 1) return "";

        return answer;
    }
}