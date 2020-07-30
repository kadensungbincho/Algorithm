package com.company;
import java.util.Stack;


public class Main {

    public static void main(String[] args) {
        int[][] board1 = {{0,0,0,0,0}, {0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1}};
        int[] moves1 = {1, 5, 3, 5, 1, 2, 1, 4};
        System.out.println(new Solution().solution(board1, moves1));
    }

    static class Solution {
        public int solution(int[][] board, int[] moves) {
            Stack<Integer> stack = new Stack<>();
            int answer = 0;
            for (int m : moves) {
                for (int i=0; i<board.length; i++) {
                    if (board[i][m-1] != 0) {
                        if (!stack.isEmpty()){
                            if (stack.peek() == board[i][m-1]) {
                                answer++;
                                stack.pop();
                            } else {
                                stack.add(board[i][m-1]);
                            }
                        } else {
                            stack.add(board[i][m-1]);
                        }
                        board[i][m-1] = 0;
                        break;
                    }
                }
            }
            return answer*2;
        }
    }
}
