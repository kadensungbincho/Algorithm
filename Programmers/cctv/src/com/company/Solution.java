package com.company;

import java.util.*;

public class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        ArrayList<int[]> remainRoutes = new ArrayList<>(Arrays.asList(routes));
        while (!remainRoutes.isEmpty()) {
            int point = getMaxPoint(remainRoutes);
            Iterator<int[]> i = remainRoutes.iterator();
            while (i.hasNext()) {
                int[] route = i.next();
                if (route[0] <= point && point <= route[1]) {
                    i.remove();
                }
            }
            answer++;
        }
        return answer;
    }

    private static int getMaxPoint(List<int[]> routes) {
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int[] route : routes) {
            for (int i=route[0]; i<=route[1]; i++) {
                cnt.put(i, cnt.getOrDefault(i, 0)+1);
            }
        }
        Map.Entry<Integer, Integer> maxEntry = null;

        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        return maxEntry.getKey();
    }
}
