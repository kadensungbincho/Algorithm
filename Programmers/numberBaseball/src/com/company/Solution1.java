package com.company;

import java.util.Stack;

public class Solution1 {
    public static int solution(int[][] baseball) {
        Stack<String> stack = new Stack<>();
        for (int i=1; i<10; i++) {
            for (int j=1; j<10; j++) {
                for (int k=1; k<10; k++) {
                    if (i != j && j != k && i != k) {
                        stack.add(String.valueOf(i * 100 + j * 10 + k));
                    }
                }
            }
        }

        Stack<String> tmp = new Stack<>();

        while(!stack.isEmpty()) {
            String num = stack.pop();
            for (int i=0; i<baseball.length; i++) {
                int strike = strike(num, String.valueOf(baseball[i][0]));
                int ball = ball(num, String.valueOf(baseball[i][0])) - strike;
                if (strike != baseball[i][1] || ball != baseball[i][2]) {
                    break;
                }

                if (i == baseball.length -1) {
                    tmp.add(num);
                }
            }
        }
        return tmp.size();
    }

    public static int strike(String num, String target) {
        int cnt = 0;
        for (int i=0; i<target.length(); i++) {
            cnt = num.charAt(i) == target.charAt(i) ? cnt+1 : cnt;
        }
        return cnt;
    }

    public static int ball(String num, String target) {
        int cnt = 0;
        for (int i=0; i<target.length(); i++) {
            cnt = num.contains(String.valueOf(target.charAt(i))) ? cnt+1 : cnt;
        }
        return cnt;
    }
}
