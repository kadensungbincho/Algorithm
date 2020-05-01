package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {
    class Doc {
        private boolean mine;
        private int priority;

        public Doc(boolean mine, int priority) {
            this.mine = mine;
            this.priority = priority;
        }
    }

    public int solution(int[] priorities, int location) {
        Queue<Doc> docQ = new LinkedList<>();
        for (int i=0; i<priorities.length; i++) {
            if (i == location) {
                docQ.offer(new Doc(true, priorities[i]));
            } else {
                docQ.offer(new Doc(false, priorities[i]));
            }
        }

        int cnt = 0;

        while(!docQ.isEmpty()) {
            cnt++;
            Doc first = docQ.peek();
            Doc prioriDoc = first;
            for (Doc doc : docQ) {
                if (prioriDoc.priority < doc.priority) {
                    prioriDoc = doc;
                }
            }

            while(prioriDoc != docQ.peek()) {
                first = docQ.poll();
                docQ.add(first);
            }
            if (docQ.poll().mine) {
                return cnt;
            }
        }
        return -1;
    }
}
