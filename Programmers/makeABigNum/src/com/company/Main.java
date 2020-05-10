package com.company;

public class Main {

    public static void main(String[] args) {
	    String number1 = "1924";
	    int k1 = 2;
	    String number2 = "4177252841";
	    int k2 = 4;
	    String number3 = "1231234";
	    int k3 = 3;
	    String number4 = "1111";
	    int k4 = 2;
	    String number5 = "0000";
	    int k5 = 2;

        System.out.println(new Solution1().solution(number1, k1));
        System.out.println(new Solution1().solution(number2, k2));
        System.out.println(new Solution1().solution(number3, k3));
        System.out.println(new Solution1().solution(number4, k4));
        System.out.println(new Solution1().solution(number5, k5));
    }
}
