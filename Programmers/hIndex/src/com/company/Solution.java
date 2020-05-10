package com.company;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {
    public int solution(int[] citations) {
        SortedMap<Integer, Integer> hIndex =  new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer s1, Integer s2) {
                return s2 - s1;
            }
        });

        for (int i : citations) {
            hIndex.put(i, hIndex.getOrDefault(i, 0) + 1);
            for (Map.Entry<Integer, Integer> entry : hIndex.entrySet()) {
                if (i > entry.getKey()) {
                    hIndex.put(entry.getKey(), entry.getValue()+1);
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : hIndex.entrySet()) {
            if (entry.getKey() <= entry.getValue()) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
