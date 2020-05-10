package com.company;

import java.util.*;

public class Solution {
    public String solution(String number, int k) {
        List<Integer> removed = new ArrayList<>();

        for (int i=0; i<number.length(); i++) {
            if (removed.size() == k) {
                break;
            }
            if (k-removed.size() >= number.length() - (i+1)) {
                removed.add(i);
            }
            if (number.charAt(i) == '9') {
                continue;
            }
            int end = i+k-removed.size()+1;

            String sub = number.substring(i, end);
            char max = getMaxBelow10(sub);

            if (number.charAt(i) != max) {
                removed.add(i);
            }
        }

        StringBuilder str = new StringBuilder();

        for (int i=0; i<number.length(); i++) {
            if (!removed.contains(i)) {
                str.append(number.charAt(i));
            }
        }
        return str.toString();
    }

    public char getMaxBelow10(String str) {
        char[] max = {'9', '8', '7', '6', '5', '4', '3', '2', '1', '0'};
        for (int i=0; i<max.length; i++) {
            if (0 <= Arrays.asList(str.split("")).indexOf(String.valueOf(max[i]))) {
                return max[i];
            }
        }
        return '9';
    }
}
