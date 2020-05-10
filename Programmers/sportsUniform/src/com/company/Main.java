package com.company;

public class Main {

    public static void main(String[] args) {
	    int n1 = 5;
	    int[] lost1 = {2, 4};
	    int[] reserve1 = {1, 3, 5};
	    int n2 = 3;
	    int[] lost2 = {3};
	    int[] reserve2 = {1};
        int n3 = 5;
        int[] lost3 = {3, 5};
        int[] reserve3 = {2, 4};
        int n4 = 5;
        int[] lost4 = {1, 2};
        int[] reserve4 = {2, 3};

//        System.out.println(new Solution().solution(n1, lost1, reserve1));
//        System.out.println(new Solution().solution(n2, lost2, reserve2));
//        System.out.println(new Solution().solution(n3, lost3, reserve3));
        System.out.println(new Solution().solution(n4, lost4, reserve4));
    }
}
