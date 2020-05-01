package com.company;

public class Main {

    public static void main(String[] args) {
        String[] participants = {"kaden", "kaden", "cho", "sungbin", "jiae"};
        String[] completions = {"kaden", "kaden", "cho", "sungbin"};
        System.out.println(new Solution2().solution(participants, completions));
    }
}
