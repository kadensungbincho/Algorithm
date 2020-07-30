package com.company;


import java.util.Arrays;
import java.util.Comparator;

public class Solution2 {
    public int solution(int[][] routes) {
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int cur = routes[0][1];
        int answer = 1;

        for (int i=1; i<routes.length; i++) {
            if (routes[i][0] <= cur) {
                cur = Math.min(routes[i][1], cur);
            } else {
                cur = routes[i][1];
                answer++;
            }
        }
        return answer;
    }
}
