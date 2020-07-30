package com.company;

import java.util.Arrays;

public class Solution {
    public int solution(int[] weight) {
        int answer = 1;
        int remain;
        boolean divided;

        Arrays.sort(weight);
        reverse(weight);

        while(true) {
            divided = false;
            remain = answer;
            for (int i : weight) {
                if (i <= remain) {
                    remain -= i;
                }
                if (remain == 0) {
                    divided = true;
                    break;
                }
            }
            if (divided) {
                answer++;
            } else {
                return answer;
            }
        }
    }

    public static void reverse(int[] input) {
        int last = input.length - 1;
        int middle = input.length / 2;
        for (int i = 0; i <= middle; i++) {
            int temp = input[i];
            input[i] = input[last - i];
            input[last - i] = temp;
        }
    }
}
