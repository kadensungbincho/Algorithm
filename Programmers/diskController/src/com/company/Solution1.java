package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution1 {
    public int solution(int[][] jobs) {
        int executableInserted = 0;
        int curTime = 0;
        int curJobRemainTime = 0;
        int waitTime = 0;
        int[] executingJob = null;
        Queue<int[]> executableJobsQ = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        while (executableInserted < jobs.length || !executableJobsQ.isEmpty() || curJobRemainTime > 0) {
            while (executableInserted < jobs.length) {
                if (jobs[executableInserted][0] <= curTime) {
                    executableJobsQ.add(jobs[executableInserted]);
                    executableInserted++;
                } else {
                    break;
                }
            }

            if (curJobRemainTime == 0) {
                if (!executableJobsQ.isEmpty()){
                    executingJob = executableJobsQ.poll();
                    curJobRemainTime = executingJob[1];
                }
            }

            if (curJobRemainTime > 0) {
                curJobRemainTime--;
            }
            curTime++;

            if (curJobRemainTime == 0 && executingJob != null) {
                waitTime += curTime - executingJob[0];
                executingJob = null;
            }

        }

        return waitTime/jobs.length;
    }
}
