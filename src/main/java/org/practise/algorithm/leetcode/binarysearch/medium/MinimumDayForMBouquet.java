package org.practise.algorithm.leetcode.binarysearch.medium;

public class MinimumDayForMBouquet {
    public int minDays(int[] bloomDay, int m, int k) {
        if ((m * k) > bloomDay.length) {
            return -1;
        }
        int min = bloomDay[0], max = bloomDay[0];
        for (int day: bloomDay) {
            min = Math.min(min, day);
            max = Math.max(max, day);
        }
        int result = -1;
        while (min <= max) {
            int mid = (min + max)/2;
            if (checkBouquetPossible(bloomDay, mid, m, k)) {
                result = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return result;
    }

    private boolean checkBouquetPossible(int[] bloomDay, int day, int m, int k) {
        int bouquet = 0;
        int consecutiveBloom = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (day < bloomDay[i]) {
                consecutiveBloom = 0;
                continue;
            }
            consecutiveBloom++;
            if (consecutiveBloom == k) {
                bouquet++;
                consecutiveBloom = 0;
            }
            if (bouquet >= m) {
                break;
            }
        }
        return bouquet >= m;
    }
}
