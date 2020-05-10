package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int solution(String name) {
        List<Integer> notFirstAndChanged = new ArrayList<>();
        List<String> alphabets = Arrays.asList("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""));

        for (int i=1; i<name.length(); i++) {
            if (name.charAt(i) != 'A') {
                notFirstAndChanged.add(i);
            }
        }
        boolean toLeft = true;
        if (notFirstAndChanged.size() > 0) {
            for (int i=notFirstAndChanged.get(0); i<notFirstAndChanged.size(); i++) {
                boolean leftChanged = notFirstAndChanged.get(i) != 'A';
                boolean rightChanged = notFirstAndChanged.get(notFirstAndChanged.size() -i -1) != 'A';
                if (leftChanged && !rightChanged) {
                    break;
                }
                if (!leftChanged && !rightChanged) {
                    toLeft = true;
                    break;
                }
                if (i >= notFirstAndChanged.size()-i-1) {
                    break;
                }
            }
        }

        int cnt = alphabets.indexOf(String.valueOf(name.charAt(0)));

        while(!notFirstAndChanged.isEmpty()) {
            int idx = toLeft ? notFirstAndChanged.size()-1 : 0;
            int alphabetsIdx = alphabets.indexOf(String.valueOf(name.charAt(notFirstAndChanged.get(idx))));
            cnt += alphabetsIdx <= alphabets.size() -alphabetsIdx ? alphabetsIdx : alphabets.size() -alphabetsIdx;
            notFirstAndChanged.remove(idx);
            cnt++;
        }

        return cnt;
    }
}
