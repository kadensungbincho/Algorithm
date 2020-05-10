package com.company;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int solution(int[][] jobs) {
        int time = 0;
        int working = 0;
        int index = 0;
        int sum = 0;
        int[] executingJob = new int[] {0, 0};
        int[] waitTime = new int[jobs.length];
        Queue<int[]> jobsQ = new LinkedList<>();
        Queue<int[]> executableJobsQ = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        for (int[] job : jobs) {
            jobsQ.add(job);
        }

        while (!jobsQ.isEmpty() || !executableJobsQ.isEmpty() || working != 0) {
            if (!jobsQ.isEmpty()) {
                if (time == jobsQ.peek()[0]) {
                    executableJobsQ.add(jobsQ.poll());
                }
            }

            if (working == 0) {
                if (!executableJobsQ.isEmpty()) {
                    executingJob = executableJobsQ.poll();
                    working = executingJob[1];
                }
            }
            if (working > 0) {
                working--;
            }

            time++;

            if (working == 0) {
                waitTime[index] = time - executingJob[0];
                index++;
            }
        }

        for (int value : waitTime) {
            System.out.print(value + " ");
            sum += value;
        }
        return (int)sum/waitTime.length;
    }
}
