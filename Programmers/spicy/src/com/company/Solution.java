package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public int solution(int[] scoville, int K) {
        int newMixed;
        int cnt = 0;
        List<Integer> mixed = new LinkedList(Arrays.asList(scoville));
        Collections.sort(mixed);

        while(K > mixed.get(0) && mixed.size() > 1) {
            newMixed = mixed.get(0) + mixed.get(1) * 2;
            mixed.remove(0);
            mixed.remove(0);
            for (int i=0; i<mixed.size(); i++) {
                if (newMixed < mixed.get(i)) {
                    mixed.add(i, newMixed);
                    break;
                }
            }
            cnt += 1;
        }
        if (K > mixed.get(0)) {
            return -1;
        }
        return cnt;
    }
}
