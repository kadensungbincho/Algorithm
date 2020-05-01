package com.company;

public class Main {

    public static void main(String[] args) {
        int[] prices = new int[] {1, 2, 3, 2, 3};
        for (int e : new Solution().solution(prices)) {
            System.out.print(e + " ");
        }
    }
}
