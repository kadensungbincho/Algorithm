package com.company;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution1 {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        Queue<Integer> pQueue = new PriorityQueue<>(Comparator.reverseOrder());

        int index = 0;
        for (int i=0; i<k; i++) {
            if(index < dates.length && i == dates[index]) {
                pQueue.add(supplies[index++]);
            }

            if(stock == 0) {
                stock += pQueue.poll();
                answer++;
            }
            stock -= 1;
        }
        return answer;
    }
}
