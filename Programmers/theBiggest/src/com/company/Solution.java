package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String solution(int[] numbers) {
        String[] stringNums = new String[numbers.length];

        for (int i=0; i<numbers.length; i++) {
            stringNums[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(stringNums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        Arrays.sort(stringNums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int i1 = Integer.parseInt(String.valueOf(o1.charAt(0)));
                int i2 = Integer.parseInt(String.valueOf(o2.charAt(0)));
                if (i1 == i2 && (o1.length() > 1 || o2.length() > 1)) {
                    if (o1.length() > 1 && o2.length() > 1) {
                        return compare(o1.substring(1), o2.substring(1));
                    }
                    if (o1.length() > 1) {
                        return compare(o1.substring(1), o2);
                    }
                    if (o2.length() > 1) {
                        return compare(o1, o2.substring(1));
                    }
                }
                return i2 - i1;
            }
        });

        return Integer.toString(Integer.parseInt(String.join("", stringNums)));
    }
}
