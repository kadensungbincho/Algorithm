package com.company;

public class Solution {
    public int[] solution(int brown, int red) {
        double base = (brown + 4) / 2;
        double medium = base / 2;
        double plusMinus = Math.sqrt((double)base * base - 4 * (brown + red)) / 2;
        return new int[] {(int)(medium + plusMinus), (int)(medium - plusMinus)};
    }
}
