package com.company;

public class Main {

    public static void main(String[] args) {
        int[] progresses = new int[] {93, 30, 55};
        int[] speeds = new int[] {1, 30, 5};
        for (int e : new Solution1().solution(progresses, speeds)) {
            System.out.print(e + " ");
        }
    }
}
