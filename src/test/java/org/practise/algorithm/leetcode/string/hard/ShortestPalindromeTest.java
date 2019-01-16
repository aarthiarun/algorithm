package org.practise.algorithm.leetcode.string.hard;

import org.practise.algorithm.basics.ShortestPalindrome;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShortestPalindromeTest {
    private ShortestPalindrome obj = new ShortestPalindrome();

    @Test
    public void testShortestPalindrome() {
        Assert.assertEquals(obj.shortestPalindrome("aacecaaa"), "aaacecaaa");
        Assert.assertEquals(obj.shortestPalindrome("abcd"), "dcbabcd");
        Assert.assertEquals(obj.shortestPalindrome("babbbabbaba"), "ababbabbbabbaba");
    }
}