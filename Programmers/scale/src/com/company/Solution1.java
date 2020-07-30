package com.company;

import java.util.Arrays;

public class Solution1 {
    public int solution(int[] weight) {

        Arrays.sort(weight);
        int answer = weight[0];

        for (int i=1; i<weight.length; i++) {
            if (answer+1 < weight[i]) {
                break;
            } else {
                answer += weight[i];
            }
        }
        return answer+1;
    }
}
