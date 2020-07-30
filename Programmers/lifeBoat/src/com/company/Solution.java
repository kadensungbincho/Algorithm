package com.company;

import java.util.Arrays;

public class Solution {
    public int solution(int[] people, int limit) {
        int cnt = 0;
        int i = 0;
        int j = people.length - 1;

        Arrays.sort(people);

        while(i <= j) {
            if (i == j) {
                cnt++;
                break;
            }
            cnt++;
            if (people[i] + people[j] > limit) {
                j--;
            } else {
                i++;
                j--;
            }
        }

        return cnt;
    }
}
