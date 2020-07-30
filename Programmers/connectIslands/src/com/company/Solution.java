package com.company;

import java.util.*;

public class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        Set<Integer> linked = new HashSet<>();
        PriorityQueue<Distance> pq = new PriorityQueue<>(costs.length, new Comparator<Distance>() {
            @Override
            public int compare(Distance o1, Distance o2) {
                return o1.getDistance() - o2.getDistance();
            }
        });
        for (int i=0; i<costs.length; i++) {
            pq.offer(new Distance(costs[i][0], costs[i][1], costs[i][2]));
        }

        linked.add(pq.peek().getI1());
        linked.add(pq.peek().getI2());
        answer += pq.peek().getDistance();
        pq.poll();

        while (linked.size() < n && !pq.isEmpty()) {
            Distance d = pq.poll();
            System.out.println(d.getI1() + "" + d.getI2() + " " + d.getDistance() + " " + linked.toString() + " " + answer);
            if ((!linked.contains(d.getI1()) && linked.contains(d.getI2())) || (linked.contains(d.getI1()) && !linked.contains(d.getI2()))) {
                linked.add(d.getI1());
                linked.add(d.getI2());
                answer += d.getDistance();
            } else {

            }
        }
        return answer;
    }

    private class Distance {
        private int i1, i2, distance;

        public Distance(int i1, int i2, int distance) {
            this.i1 = i1;
            this.i2 = i2;
            this.distance = distance;
        }

        public int getI1() {
            return i1;
        }

        public int getI2() {
            return i2;
        }

        public int getDistance() {
            return distance;
        }
    }
}
