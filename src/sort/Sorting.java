package sort;

import java.io.*;
import java.util.*;

public class Sorting {
    private static Random random = new Random();

    private static void advanceQuickSort(int[] arr, int start, int end) {
        if (start >= end) return;

        int k = random.nextInt(end - start + 1) + start;
        int t = arr[start];
        arr[start] = arr[k];
        arr[k] = t;

        Integer lb = start;
        Integer ub = end;

        int[] props = advanceQuickPartition(arr, start, end, lb, ub);

        advanceQuickSort(arr,start, props[0]-1);
        advanceQuickSort(arr,props[1]+1, end);
    }

    private static  int[] advanceQuickPartition(int[] arr, int start, int end, Integer lb, Integer ub) {

        int pivotValue = arr[start];
        int i = start;
        while (i <= ub) {
            int diff = pivotValue - arr[i];
            // case1: if arr[i] < pivot :
            // will exchange arr[i] and arr[lb] and increment lb and i as well so all the small element
            // will come left to pivot
            if (diff > 0) {
                int temp = arr[i];
                arr[i] = arr[lb];
                arr[lb] = temp;
                i++;
                lb++;
            } else if (diff == 0) {
                // will just increment i
                i++;
            } else {
                // will exchange element from ub to i'th position
                // so that on Right side only grater then pivot element will be there
                // and we decrement the ub as well
                int temp = arr[ub];
                arr[ub] = arr[i];
                arr[i] = temp;
                ub--;
            }
        }
        return new int[]{lb, ub, i };
    }

    private static void randomizedQuickSort(int[] arr, int start, int end) {
        if (start >= end) return;

        Integer lb = start;
        Integer ub = end;

        int[] props = advanceQuickPartition(arr, start, end, lb, ub);

        advanceQuickSort(arr,start, props[0]-1);
        advanceQuickSort(arr,props[1]+1, end);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

