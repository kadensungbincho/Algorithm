package com.company;

import java.util.Queue;

public class Solution {
    public int solution(String arrangement) {
        int left = 0;
        int parts = 0;
        String prev = "";
        String[] arr = arrangement.split("");
        for (int i=0; i<arr.length; i++) {
            if (arr[i].equals("(")) {
                left += 1;
            } else {
                left -= 1;
                if (prev.equals("(")) {
                    parts += left;
                } else {
                    parts += 1;
                }
            }
            prev = arr[i];
        }
        return parts;
    }
}
