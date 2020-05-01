package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {
    public int solution(int bridgeLength, int weight, int[] truckWeights) {
        int time = 0;
        Queue<Truck> bridge = new LinkedList<>();
        int truckNumber = truckWeights.length;
        int lastEnterTruckIndex = 0;
        int currentBridgeWeight = 0;

        while (lastEnterTruckIndex < truckNumber) {
            time++;

            if(!bridge.isEmpty()) {
                Truck frontTruck = bridge.peek();
                if(time - frontTruck.enterTime == bridgeLength) {
                    currentBridgeWeight -= bridge.poll().weight;
                }
            }

            int compareTruck = truckWeights[lastEnterTruckIndex];
            if(currentBridgeWeight + compareTruck <= weight) {
                bridge.offer(new Truck(compareTruck, time));
                lastEnterTruckIndex++;
                currentBridgeWeight += compareTruck;
            }
        }

        time += bridgeLength;

        return time;
    }
}

class Truck {
    public int weight;
    public int enterTime;

    public Truck(int weight, int enterTime) {
        this.weight = weight;
        this.enterTime = enterTime;
    }
}
