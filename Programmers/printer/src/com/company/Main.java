package com.company;

public class Main {

    public static void main(String[] args) {
	    int[] case1 = new int[] {2, 1, 3, 2};
	    int location1 = 2;
        int[] case2 = new int[] {1, 1, 9, 1, 1, 1};
        int location2 = 0;
        System.out.println(new Solution1().solution(case2, location2));
    }
}
