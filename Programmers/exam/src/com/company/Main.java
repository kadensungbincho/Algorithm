package com.company;

public class Main {

    public static void main(String[] args) {
	    int[] answers = {1, 2, 3, 4, 5};
        int[] answers1 = {1, 3, 2, 4, 2};
        for (int n : new Solution().solution(answers1)) {
            System.out.print(n + " ");
        }
    }
}
