package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public int solution(String numbers) {
        List<List<String>> totSet = new LinkedList<>();
        Set<String> result = new HashSet<>();
        int cnt = 0;

        for (int i=1; i<=numbers.length(); i++) {
            totSet.addAll(combination(Arrays.asList(numbers.split("")), i));
        }

        for (List<String> _set : totSet) {
            result.addAll(permutationString(String.join("", _set)));
        }
        System.out.println(result.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toSet()));
        for (int i : result.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toSet())) {
            if (isPrime(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    public static <T> List<List<T>> combination(List<T> values, int size) {

        if (0 == size) {
            return Collections.singletonList(Collections.<T> emptyList());
        }

        if (values.isEmpty()) {
            return Collections.emptyList();
        }

        List<List<T>> combination = new LinkedList<List<T>>();

        T actual = values.iterator().next();

        List<T> subSet = new LinkedList<>(values);
        subSet.remove(actual);

        List<List<T>> subSetCombination = combination(subSet, size - 1);

        for (List<T> set : subSetCombination) {
            List<T> newSet = new LinkedList<T>(set);
            newSet.add(0, actual);
            combination.add(newSet);
        }

        combination.addAll(combination(subSet, size));

        return combination;
    }

    public static Set<String> permutationString(String str) {
        Set<String> perm = new HashSet<>();
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            perm.add("");
            return perm;
        }

        char initial = str.charAt(0);
        String rem = str.substring(1);
        Set<String> words = permutationString(rem);
        for (String strNew : words) {
            for (int i=0; i<=strNew.length(); i++) {
                perm.add(charInsert(strNew, initial, i));
            }
        }
        return perm;
    }

    public static String charInsert(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }

    public boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        int sqrt = (int) Math.sqrt(number);
        for (int i = 2; i < sqrt; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
