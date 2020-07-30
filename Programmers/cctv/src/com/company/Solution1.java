package com.company;

import java.util.*;

public class Solution1 {
    private HashMap<Integer, Integer> cnt = new HashMap<>();

    public int solution(int[][] routes) {
        int answer = 0;
        ArrayList<int[]> remainRoutes = new ArrayList<>(Arrays.asList(routes));

        setCnt(remainRoutes);

        while (!remainRoutes.isEmpty()) {
            int point = getKeyWithMaxValue();
            Iterator<int[]> i = remainRoutes.iterator();
            while (i.hasNext()) {
                int[] route = i.next();
                if (route[0] <= point && point <= route[1]) {
                    subtractCnt(route[0], route[1]);
                    i.remove();
                }
            }
            answer++;
        }
        return answer;
    }

    private void setCnt(List<int[]> routes) {
        for (int[] route : routes) {
            for (int i=route[0]; i<=route[1]; i++) {
                cnt.put(i, cnt.getOrDefault(i, 0)+1);
            }
        }
    }

    private int getKeyWithMaxValue() {
        Map.Entry<Integer, Integer> maxEntry = null;

        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        return maxEntry.getKey();
    }

    private void subtractCnt(int start, int end) {
        for (int i=start; i<= end; i++) {
            cnt.put(i, cnt.get(i)-1);
        }
    }

}
