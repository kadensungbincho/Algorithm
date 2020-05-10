package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int[] solution(int[] answers) {
        int[] case1 = {1, 2, 3, 4, 5};
        int[] case2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] case3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[][] cases = {case1, case2, case3};
        List<Integer> scores = new ArrayList<>();
        List<Integer> loc = new ArrayList<>();

        int correct;

        for (int[] _case : cases) {
            correct = 0;
            for (int a=0; a<answers.length; a++) {
                if (answers[a] == _case[a % _case.length]) {
                    correct++;
                }
            }
            scores.add(correct);
        }

        int max = Collections.max(scores);
        for (int i=0; i<scores.size(); i++) {
            if (scores.get(i) == max) {
                loc.add(i+1);
            }
        }
        return loc.stream().mapToInt(i -> i).toArray();
    }
}
