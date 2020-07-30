package com.company;

public class Main {

    public static void main(String[] args) {
	    int n1 = 4;
	    int[][] costs1 = {{0,1,1}, {0,2,2}, {1,2,5}, {1,3,1}, {2,3,8}};
	    int n2 = 5;
	    int[][] costs2 = {{0,1,1}, {3,4,1}, {1,2,2}, {2,3,4}};
        int n3 = 4;
        int[][] costs3 = {{0,1,5}, {1,2,3}, {2,3,3}, {3,1,2}, {3,0,4}};

        System.out.println(new Solution1().solution(n1, costs1));
        System.out.println(new Solution1().solution(n2, costs2));
        System.out.println(new Solution1().solution(n3, costs3));
    }
}
