package com.company;

public class Solution {
    public int[] solution(int[] prices) {
        int cnt;
        int[] result = new int[prices.length];
        for (int i=0; i<prices.length; i++) {
            cnt = 0;
            for (int j=i+1; j<prices.length; j++) {
                cnt += 1;

                if (prices[i] > prices[j]) {
                    result[i] = cnt;
                    break;
                }

                if (j == prices.length - 1) {
                    result[i] = cnt;
                }
            }
        }
        return result;
    }
}
