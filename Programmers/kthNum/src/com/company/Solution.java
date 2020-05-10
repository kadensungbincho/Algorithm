package com.company;

import java.util.Arrays;

public class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int i, j, k;
        int[] result = new int[commands.length];

        for (int c=0; c<commands.length; c++) {
            i = commands[c][0]-1; j = commands[c][1]-1; k = commands[c][2]-1;

            int[] sliced = new int[j-i+1];

            for (int n=i; n<j+1; n++) {
                sliced[n-i] = array[n];
            }

            Arrays.sort(sliced);

            result[c] = sliced[k];
        }
        return result;
    }
}
