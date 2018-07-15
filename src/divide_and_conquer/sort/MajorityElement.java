package divide_and_conquer.sort;

import java.util.*;
import java.io.*;

public class MajorityElement {
    private  static  boolean isMajority = false;
    private static int getMajorityElement(int[] arr, int left, int right, int totalSize) {
        if (left > right) return 0;

        int lb = left;
        int ub = right;
        int i = left;
        int pivot = arr[left];
        int count = 0;

        while (i <= ub) {
            int diff = pivot - arr[i];
            if (diff > 0) {
                int temp = arr[i];
                arr[i] = arr[lb];
                arr[lb] = temp;

                i++;
                lb++;
            } else if (diff == 0) {
                i++;
                count++;
            } else {
                int temp = arr[i];
                arr[i] = arr[ub];
                arr[ub] = temp;

                ub--;
            }
        }

        if ((lb-1-left) > (totalSize/2)) {
            getMajorityElement(arr, left, lb -1, totalSize);
        }

        if ( (right - ub + 1) > (totalSize/2)) {
            getMajorityElement(arr, ub + 1, right, totalSize);
        }

        if (count > (totalSize /2)) {
            isMajority = true;
            return 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        getMajorityElement(a, 0, a.length -1, a.length);
        if (isMajority) {
            System.out.println(1);
        } else {
            System.out.println(0);
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
