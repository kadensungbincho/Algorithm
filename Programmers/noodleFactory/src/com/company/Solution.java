package com.company;

public class Solution {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int prevDates = 0;
        int cnt = 0;
        int[] stockAtStart = new int[dates.length];
        for (int i=0; i<dates.length; i++) {
            stockAtStart[i] = stock;
            stock -= (dates[i] - prevDates);
            stock += supplies[i];
            cnt++;
        }
        stock -= (k - dates[dates.length - 1]);

    }
}
