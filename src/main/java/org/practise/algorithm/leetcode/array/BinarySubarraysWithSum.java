package org.practise.algorithm.leetcode.array;

/**
 *
 * 930. Binary Subarrays With Sum
 *
 In an array A of 0s and 1s, how many non-empty subarrays have sum S?



 Example 1:

 Input: A = [1,0,1,0,1], S = 2
 Output: 4
 Explanation:
 The 4 subarrays are bolded below:
 [1,0,1,0,1]
 [1,0,1,0,1]
 [1,0,1,0,1]
 [1,0,1,0,1]


 Note:

 A.length <= 30000
 0 <= S <= A.length
 A[i] is either 0 or 1.
 *
 */
public class BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] a, int S) {
        int n = a.length;
        int[] cum = new int[n+1];
        for(int i = 0;i < n;i++)cum[i+1] = cum[i] + a[i];

        int ret = 0;
        int[] f = new int[30003];
        for(int i = 0;i <= n;i++){
            if(cum[i]-S >= 0)ret += f[cum[i]-S];
            f[cum[i]]++;
        }
        return ret;
    }
}
