package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        List<Integer> remainLost = Arrays.stream(lost).boxed().collect(Collectors.toList());
        List<Integer> remainReserve = Arrays.stream(reserve).boxed().collect(Collectors.toList());

        Collections.sort(remainLost);
        Collections.sort(remainReserve);

        for (Iterator<Integer> i = remainLost.iterator(); i.hasNext();) {
            int curLost = i.next();
            for (int j=0; j<remainReserve.size(); j++) {
                if (curLost == remainReserve.get(j)) {
                    answer++;
                    remainReserve.remove(j);
                    i.remove();
                    break;
                }
            }
        }

        for (int l : remainLost) {
            for (int i=0; i<remainReserve.size(); i++) {
                if (l-1 == remainReserve.get(i) || l+1 == remainReserve.get(i)) {
                    answer++;
                    remainReserve.remove(i);
                    break;
                }
            }
        }

        return answer;
    }
}
