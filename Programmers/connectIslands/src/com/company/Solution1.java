package com.company;

import javax.sound.sampled.Line;
import java.util.*;

public class Solution1 {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        Set<Integer> linked = new HashSet<>();
        LinkedList<Distance> distances = new LinkedList<>();

        for (int i=0; i<costs.length; i++) {
            distances.add(new Distance(costs[i][0], costs[i][1], costs[i][2]));
        }

        Collections.sort(distances, new Comparator<Distance>() {
            @Override
            public int compare(Distance o1, Distance o2) {
                return o1.getDistance() - o2.getDistance();
            }
        });

        linked.add(distances.get(0).getI1());
        linked.add(distances.get(0).getI2());
        answer += distances.get(0).getDistance();
        distances.remove(0);

        while (linked.size() < n && !distances.isEmpty()) {
            for (int i=0; i<distances.size(); i++) {
                Distance d = distances.get(i);
                if ((!linked.contains(d.getI1()) && linked.contains(d.getI2())) || (linked.contains(d.getI1()) && !linked.contains(d.getI2()))) {
                    linked.add(d.getI1());
                    linked.add(d.getI2());
                    answer += d.getDistance();
                    distances.remove(i);
                    break;
                }

                if (linked.contains(d.getI1()) && linked.contains(d.getI2())) {
                    distances.remove(i);
                    break;
                }
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
