package com.company;

public class Main {

    public static void main(String[] args) {
	    int brown1 = 10;
	    int red1 = 2;
        int brown2 = 24;
        int red2 = 24;
	    for (int e : new Solution().solution(brown1, red1)) {
            System.out.print(e + " ");
        }

        for (int e : new Solution().solution(brown2, red2)) {
            System.out.print(e + " ");
        }
    }
}
