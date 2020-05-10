package com.company;

public class Main {

    public static void main(String[] args) {
        // Test replaceX
//        String case1 = "1xx";
//        for (String e : new Solution().replaceX(case1, 'x', '2')) {
//            System.out.print(e + " ");
//        }

        int[][] case2 = new int[][] {{123, 1,1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
        System.out.println(new Solution1().solution(case2));
    }
}
