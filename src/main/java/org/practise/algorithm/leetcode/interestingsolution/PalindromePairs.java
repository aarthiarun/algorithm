package org.practise.algorithm.leetcode.interestingsolution;

import java.util.*;

/**
 *
 * 336. Palindrome Pairs
 *
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list,
 * so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
 *
 * Example 1:
 *
 * Input: ["abcd","dcba","lls","s","sssll"]
 * Output: [[0,1],[1,0],[3,2],[2,4]]
 * Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
 * Example 2:
 *
 * Input: ["bat","tab","cat"]
 * Output: [[0,1],[1,0]]
 * Explanation: The palindromes are ["battab","tabbat"]
 */
public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            int l = 0, r = 0;
            String word = words[i];
            while (l <= r) {
                Integer j = map.get(new StringBuilder(word.substring(l, r)).reverse().toString());
                if (j != null && j != i && isPalindrome(word.substring(l == 0 ? r : 0, l == 0 ? word.length() : l))) {
                    result.add(Arrays.asList(l == 0? new Integer[]{i, j} : new Integer[]{j, i}));
                }
                if (r < word.length()) r++;
                else l++;
            }
        }

        return result;
    }


    private boolean isPalindrome(String word) {
        int left = 0, right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left++) != word.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
