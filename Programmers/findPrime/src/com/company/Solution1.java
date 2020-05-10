package com.company;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {
    public int solution(String numbers) {
        int[] numbList = new int[numbers.length()];
        for (int i=0; i<numbers.length(); i++) {
            numbList[i] = Integer.parseInt(String.valueOf(numbers.charAt(i)));
        }

        for (int i=0; i<numbList.length; i++) {
            for (int j=0; j<numbList.length-i-1; j++) {
                if (numbList[j] > numbList[j+1]) {
                    int temp = numbList[j];
                    numbList[j] = numbList[j+1];
                    numbList[j+1] = temp;
                }
            }
        }

        Set<Integer> primeList = new HashSet<>();
        for (int i=1; i<=numbList.length; i++) {
            perm(numbList, 0, i, primeList);
        }

        return primeList.size();
    }

    private void perm(int[] arr, int depth, int k, Set<Integer> primeList) {
        if (depth == k) {
            returnNumber(arr, k, primeList);
            return;
        }

        for (int i=depth; i<arr.length; i++) {
            swap(arr, i, depth);
            perm(arr, depth+1, k, primeList);
            swap(arr, i, depth);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void returnNumber(int[] arr, int k, Set primeList) {
        int resultNumber = 0;
        for (int i=0; i<k; i++) {
            resultNumber += arr[i] * Math.pow(10, k-1-i);
        }

        prime(primeList, resultNumber);
    }

    private void prime(Set primeList, int resultNumber) {
        boolean isPrime = true;
        if (resultNumber <= 1) {
            return;
        }

        for (int j=2; j<= Math.sqrt(resultNumber); j++) {
            if (resultNumber % j == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            primeList.add(resultNumber);
        }
    }
}
