package com.company;

import java.util.PriorityQueue;

public class Solution1 {
    public int solution(int[] scovile, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int s : scovile) {
            heap.offer(s);
        }

        while (heap.peek() <= K) {
            if (heap.size() == 1) {
                return -1;
            }
            int a = heap.poll();
            int b = heap.poll();

            int result = a + (b * 2);

            heap.offer(result);
            answer++;
        }
        return answer;
    }
}
