package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class Solution1 {
    public boolean solution(String[] phoneBook) {
        Arrays.sort(phoneBook, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        for(int i=0; i<phoneBook.length; i++) {
            for(int j=i; j<phoneBook.length; j++) {
                if(phoneBook[j].startsWith(phoneBook[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
