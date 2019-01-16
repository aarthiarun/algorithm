package org.practise.algorithm.basics;

/**
 * Shortest Palindrome
 *
 * Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it.
 * Find and return the shortest palindrome you can find by performing this transformation.
 *
 * Example 1:
 *
 * Input: "aacecaaa"
 * Output: "aaacecaaa"
 * Example 2:
 *
 * Input: "abcd"
 * Output: "dcbabcd"
 *
 */
public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        String temp = s + '#' + reversed;
        int[] LIS = new int[temp.length()];
        fillLIS(temp.toCharArray(), LIS);
        return new StringBuilder(s.substring(LIS[LIS.length - 1])).reverse().toString() + s;
    }

    private void fillLIS(char[] word, int[] LIS) {
        LIS[0] = 0;
        for (int i = 1; i < word.length; i++) {
            int t = LIS[i - 1];
            while (t > 0 && word[t] != word[i]) {
                t = LIS[t - 1];
            }

            if (word[t] == word[i]) {
                t++;
            }

            LIS[i] = t;
        }
    }
}
