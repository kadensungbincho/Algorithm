package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class Solution1 {
    public String solution(int[] numbers) {
        Integer[] array = new Integer[numbers.length];
        for (int i=0; i<numbers.length; i++) {
            array[i] = numbers[i];
        }

        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1.toString();
                String s2 = o2.toString();
                return ((s2+s1)).compareTo(s1+s2);
            }
        });

        String answer = "";
        for (int i=0; i<array.length; i++) {
            answer += String.valueOf(array[i]);
        }

        if("0".equals(answer.substring(0, 1)))
            return "0";
        return answer;
    }
}
