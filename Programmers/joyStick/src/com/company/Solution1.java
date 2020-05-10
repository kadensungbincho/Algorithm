package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
    public int solution(String name) {
        List<Integer> notFirstCharAndChanged = new ArrayList<>();
        List<String> alphabets = Arrays.asList("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""));

        for (int i=1; i<name.length(); i++) {
            if (name.charAt(i) != 'A') {
                notFirstCharAndChanged.add(i);
            }
        }
        boolean toLeft = true;
        if (notFirstCharAndChanged.size() > 0) {
            for (int i=notFirstCharAndChanged.get(0); i<notFirstCharAndChanged.size(); i++) {
                boolean leftChanged = name.charAt(notFirstCharAndChanged.get(i)) != 'A';
                boolean rightChanged = name.charAt(notFirstCharAndChanged.get(notFirstCharAndChanged.size() -i -1)) != 'A';
                if (leftChanged && !rightChanged) {
                    toLeft = false;
                    break;
                }
                if (!leftChanged && rightChanged) {
                    break;
                }
                if (i >= notFirstCharAndChanged.size()-i-1) {
                    break;
                }
            }
        }

        int cnt = alphabets.indexOf(String.valueOf(name.charAt(0)));
        int alphabetsIdx, changedIdx, nameCur = 0;

        while(!notFirstCharAndChanged.isEmpty()) {
            changedIdx = toLeft ? notFirstCharAndChanged.size()-1 : 0;
            if (toLeft) {
                if (notFirstCharAndChanged.get(changedIdx) <= nameCur) {
                    cnt += nameCur - notFirstCharAndChanged.get(changedIdx);
                } else {
                    cnt += name.length() - notFirstCharAndChanged.get(changedIdx) + nameCur;
                }
            } else {
                if (notFirstCharAndChanged.get(changedIdx) < nameCur) {
                    cnt += name.length() - nameCur + notFirstCharAndChanged.get(0);
                } else {
                    cnt +=  notFirstCharAndChanged.get(changedIdx) - nameCur;
                }
            }
            nameCur = notFirstCharAndChanged.get(changedIdx);
            alphabetsIdx = alphabets.indexOf(String.valueOf(name.charAt(nameCur)));
            cnt += Math.min(alphabetsIdx, alphabets.size() -alphabetsIdx);
            notFirstCharAndChanged.remove(changedIdx);
            if (!notFirstCharAndChanged.isEmpty()) {
                int toLeftDistance = nameCur - notFirstCharAndChanged.get(notFirstCharAndChanged.size()-1);
                int toRightDistance = name.length() - nameCur + notFirstCharAndChanged.get(0);
                if (toLeftDistance <= toRightDistance) {
                    toLeft = true;
                } else {
                    toLeft = false;
                }
            }
        }

        return cnt;
    }
}
