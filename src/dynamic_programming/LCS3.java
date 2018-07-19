package dynamic_programming;

import java.util.*;

public class LCS3 {

    private static int lcs3(int[] a, int[] b, int[] c) {
        //Write your code here
        int[][][] store = new int[a.length+1][b.length+1][c.length+1];

        for (int i = 0 ; i < a.length; i++) {
            int x = i+1;

            for (int j = 0 ; j< b.length; j++) {
                int y = j+1;

                for (int k = 0; k<c.length; k++) {
                    int z = k+1;

                    int left = store[x][y-1][z-1];
                    int left2 = store[x][y][z-1];
                    int left3 = store[x][y-1][z];

                    int top = store[x-1][y][z-1];
                    int top2 = store[x-1][y][z];


                    int edge = store[x-1][y-1][z];

                    int adajacent = store[x-1][y-1][z-1];

                    if (a[i] == b[j] && b[j] == c[k]) {
                        store[x][y][z] = adajacent+1;
                    } else {
                        int leftTop = left >= left2 && left >= left3 ? left : left2 >= left3 ? left2 : left3;
                        int top_new = top >= top2 && top >= edge ? top : top2 >= edge? top2 : edge;
                        int finalTop = leftTop >= top_new && leftTop >= adajacent ?
                                leftTop : top_new >= adajacent ? top_new : adajacent;
                        store[x][y][z] = finalTop;
                    }
                }
            }
        }
        return store[a.length][b.length][c.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c));
    }
}

