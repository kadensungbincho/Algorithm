package com.company;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int solution(int[][] baseball) {
        return 1;
    }

    public int[] getPossibleNums(int[] result) {
        return new int[] {1};
    }

    public String[] replaceX(String str, char x, char n) {
        if (str.length() != 3) {
            throw new IllegalArgumentException("Only 3 length string supported");
        }

        List<String> result = new ArrayList<>();

        for (int i=0; i<str.length(); i++) {
            char buf[] = new char[str.length()];
            boolean replaced = false;
            for (int j=0; j<str.length(); j++) {
                if (str.charAt(i) == x & j >= i & replaced == false) {
                    buf[j] = n;
                    replaced = true;
                } else {
                    buf[j] = str.charAt(j);
                }
            }
            if (replaced) {
                result.add(new String(buf));
            }
        }
        return result.toArray(new String[0]);
    }

    public String[] replaceX(String str, char x) {
        int cnt = 0;

        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == x) {
                cnt++;
            }
        }

        if (cnt == 0) {
            return new String[] {str};
        }

        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == x) {
                cnt++;
            }
        }

        return new String[] {"123"};
    }
}
