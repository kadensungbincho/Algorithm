package com.company;

public class Main {

    public static void main(String[] args) {
//        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
//        int[] plays = {500, 600, 150, 800, 2500};
        String[] genres = {"classic", "classic", "classic", "pop", "jazz", "jazz"};
        int[] plays = {500, 150, 800, 2500, 2100, 1000};
        for (int i : new Solution().solution(genres, plays)) {
            System.out.print(i + " ");
        }
    }
}
