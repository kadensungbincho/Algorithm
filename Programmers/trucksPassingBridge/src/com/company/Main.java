package com.company;

public class Main {

    public static void main(String[] args) {
	    int bridgeLength = 2;
	    int weight = 10;
	    int[] truckWeights = new int[] {7, 7, 7, 4, 5, 6};

        System.out.println(new Solution1().solution(bridgeLength, weight, truckWeights));
    }
}
