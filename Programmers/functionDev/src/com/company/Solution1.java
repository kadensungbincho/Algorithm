package com.company;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] schedules = new int[progresses.length];
        for (int i=0; i<progresses.length; i++) {
            schedules[i] = (int)Math.ceil((100 - progresses[i]) / speeds[i]);
        }
        int cnt = 0, cur = schedules[0];
        List<Integer> deploys = new ArrayList<>();
        for (int i=0; i<schedules.length; i++) {
            if (schedules[i] <= cur) {
                cnt += 1;
            } else {
                deploys.add(cnt);
                cur = schedules[i];
                cnt = 1;
            }
        }
        deploys.add(cnt);
        return deploys.stream().mapToInt(i -> i).toArray();
    }
}
