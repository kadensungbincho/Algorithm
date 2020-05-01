package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int took = 1;
        List<Integer> remainTruckWeights = Arrays.stream(truck_weights).boxed().collect(Collectors.toList());
        List<int []> passing = new ArrayList<>();
        Collections.sort(remainTruckWeights);

        while(remainTruckWeights.size() > 0 || passing.size() > 0) {
            for(int i=0; i<remainTruckWeights.size(); i++) {
                if(passing.stream().mapToInt(a -> a[0]).sum() + remainTruckWeights.get(i) < weight) {
                    passing.add(new int[] {remainTruckWeights.get(i), bridge_length});
                    remainTruckWeights.remove(i);
                    break;
                }
            }
            for(int i=0; i<passing.size(); i++) {
                passing.get(i)[1] -= 1;
            }
            for(int i=0; i<passing.size(); i++) {
                if(passing.get(i)[1] == 0) {
                    passing.remove(i);
                    break;
                }
            }
            took++;
        }
        return took;
    }
}
