package dynamic_programming;

import java.util.*;

public class LCS2 {

    private static int lcs2(int[] a, int[] b) {
        //Write your code here
        int[][] store = new int[a.length+1][b.length+1];

        for (int i = 0 ; i < a.length; i++) {
            int x = i+1;
            for (int j=0; j< b.length; j++) {
                int y = j+1;
                int left = store[x][y-1];
                int top = store[x-1][y];
                int adjacent = store[x-1][y-1];

                int max = left >= top && left >= adjacent ? left : top >= adjacent ? top : adjacent;
                if (a[i] == b[j]) {
                    max= adjacent + 1;
                }

                store[x][y] = max;
            }
        }

        return store[a.length][b.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
    }
}

