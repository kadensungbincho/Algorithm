package com.company;

import java.util.Arrays;

public class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        for(int i=0; i < participant.length; i++) {
            if (participant[i] != completion[i]) {
                return participant[i];
            }
        }
        return completion[completion.length - 1];
        // take too long or too much resource
    }
}
