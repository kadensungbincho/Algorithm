package com.company;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        int remove;
        PriorityQueue<Integer> priorityQueueMax = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> priorityQueueMin = new PriorityQueue<>();

        for (String operation : operations) {
            String[] split = operation.split(" ");

            if (split[0].equals("I")) {
                priorityQueueMax.add(Integer.parseInt(split[1]));
                priorityQueueMin.add(Integer.parseInt(split[1]));
            }

            if (split[0].equals("D")) {
                if (!priorityQueueMax.isEmpty()) {
                    if (split[1].equals("1")) {
                        remove = priorityQueueMax.poll();
                        priorityQueueMin.remove(remove);
                    } else {
                        remove = priorityQueueMin.poll();
                        priorityQueueMax.remove(remove);
                    }
                }
            }
        }
        if (!priorityQueueMax.isEmpty()) {
            answer[0] = priorityQueueMax.peek();
            answer[1] = priorityQueueMin.peek();
        }
        return answer;
    }
}
