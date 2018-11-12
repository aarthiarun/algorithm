package org.practise.algorithm.leetcode.dynamicprogramming.hard;

import java.util.Arrays;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * Example:
 *
 * Input: "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class PalindromePartitioningII {
    public int minCut(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] cut = new int[n];
        boolean[][] pal = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            int min = i;
            for(int j = 0; j <= i; j++) {
                if(c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
                }
            }
            cut[i] = min;
        }
        return cut[n - 1];
    }

//    O(N^3) solution
//
//    public int minCut(String s) {
//        if (s == null || s.isEmpty()) return 0;
//        int N = s.length();
//
//        int[][] dp = new int[N][N];
//        for (int[] arr: dp) {
//            Arrays.fill(arr, Integer.MAX_VALUE);
//        }
//
//        for (int len = 0; len < N ; len++) {
//            for (int i = 0; i + len < N; i++) {
//                final int j = i + len;
//                if (isPalindrome(s, i, j)) {
//                    dp[i][j] = 0;
//                } else {
//                    for (int k = i; k < j; k++)
//                        dp[i][j] = Math.min( 1 + dp[i][k] + dp[k + 1][j], dp[i][j]);
//                }
//            }
//        }
//        return dp[0][N - 1];
//    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
