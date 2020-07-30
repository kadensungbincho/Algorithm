package com.company;

public class Main {

    public static void main(String[] args) {
	    int m1 = 6;
	    int n1 = 4;
	    int[][] picture1 = {{1,1,1,0}, {1,2,2,0}, {1,0,0,1}, {0,0,0,1}, {0,0,0,3}, {0,0,0,3}};
        for (int i : new Solution().solution(m1, n1, picture1)) {
            System.out.print(i + " ");
        }
    }

    static class Solution {
        public int[] solution(int m, int n, int[][] picture) {
            boolean[][] availables = new boolean[m][n];
            int cnt = 0;
            int max = 0;

            for (int i=0; i<picture.length; i++) {
                for (int j=0; j<picture[i].length; j++) {
                    if (picture[i][j] != 0) {
                        availables[i][j] = true;
                    } else {
                        availables[i][j] = false;
                    }
                }
            }

            for (int i=0; i<availables.length; i++) {
                for (int j=0; j<availables[i].length; j++) {
                    if (availables[i][j] == true) {
                        cnt++;
                        max = Math.max(max, recursiveFill(picture, availables, i, j, picture[i][j]));
                    }
                }
            }

            return new int[] {cnt, max};
        }

        private int recursiveFill(int[][] picture, boolean[][] availables, int m, int n, int value) {
            if (picture[m][n] == value && availables[m][n]) {
                int upper, lower, left, right;
                availables[m][n] = false;
                upper = m > 0 ? recursiveFill(picture, availables, m-1, n, value) : 0;
                lower = m < picture.length-1 ? recursiveFill(picture, availables, m+1, n, value) : 0;
                left = n > 0 ? recursiveFill(picture, availables, m, n-1, value) : 0;
                right = n < picture[m].length-1 ? recursiveFill(picture, availables, m, n+1, value) : 0;
                return 1 + upper + lower + left + right;
            } else {
                return 0;
            }
        }

    }
}
