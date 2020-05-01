package com.company;

public class Main {

    public static void main(String[] args) {
        int[] scoville = new int[] {1, 1, 1, 1, 1, 2, 3, 4, 2, 3, 9, 10, 12};
        int K = 7;
        System.out.println(new Solution().solution(scoville, K));
    }
}
