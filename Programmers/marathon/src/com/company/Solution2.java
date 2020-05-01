package com.company;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> targets = new HashMap<String, Integer>();
        for(int i=0; i<completion.length; i++) {
            if(targets.containsKey(completion[i])) {
                targets.put(completion[i], targets.get(completion[i]) + 1);
            } else {
                targets.put(completion[i], 1);
            }
        }
        for(int i=0; i<participant.length; i++) {
            if(targets.containsKey(participant[i])) {
                if(targets.get(participant[i]) > 0) {
                    targets.put(participant[i], targets.get(participant[i]) - 1);
                } else {
                    return participant[i];
                }
            } else {
                return participant[i];
            }
        }

        throw new IllegalArgumentException("No unaccomplished participant");
    }
}
