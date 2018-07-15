package divide_and_conquer.sort;

import java.util.Random;
import java.util.Scanner;

public class PointsAndSegments {

    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];

        sort(starts, ends, 0, starts.length-1);

        //write your code here
        for (int i = 0 ; i < points.length ; i ++) {
            cnt[i] = findElementUsingWhile(starts, ends, points[i], 0, starts.length-1);
        }
        return cnt;
    }

    /*counting login for counting no occurrences of element in segment range
     * basically using binary divide_and_conquer.search for that but in-place of returning on finding element
      * just incrementing start so that it will look for next segment range... */
    private static int findElementUsingWhile(int[] segmentX, int[] segmentY, int element, int start, int end) {
        int count = 0;
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (element >= segmentX[mid] && element <= segmentY[mid]) {
                count++;
                start++;
            }else if (element < segmentX[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return count;
    }

    private static void sort (int[] arr1, int[] arr2, int start, int end) {
        if (start >= end) return;

        swapRandomNoInRangeWithFirst(arr1, arr2, start, end);

        int partitionPos = partition(arr1, arr2, start, end);

        sort(arr1, arr2,  start, partitionPos -1);
        sort(arr1, arr2, partitionPos + 1, end);

    }

    private static void swapRandomNoInRangeWithFirst(int[] arr1, int[] arr2, int start, int end) {
        int random = new Random().nextInt((end - start) + 1) + start;

        int temp = arr1[random];
        arr1[random] = arr1[start];
        arr1[start] = temp;

        temp = arr2[random];
        arr2[random] = arr2[start];
        arr2[start] = temp;


    }

    private static int partition(int[] arr1, int[] arr2, int start, int end) {
        int pivot = arr1[start];
        int l = start;

        for (int ptr = start + 1; ptr <= end; ptr ++) {

            if (arr1[ptr] <= pivot) {
                l++;

                int temp = arr1[l];
                arr1[l] = arr1[ptr];
                arr1[ptr] = temp;

                temp = arr2[l];
                arr2[l] = arr2[ptr];
                arr2[ptr] = temp;
            }
        }

        int temp = arr1[l];
        arr1[l] = arr1[start];
        arr1[start] = temp;

        temp = arr2[l];
        arr2[l] = arr2[start];
        arr2[start] = temp;

        return  l;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /*
        * 2 4

-4 -2

9 11

14, 2, 30, 9*/
        int n, m;
         n = scanner.nextInt();
         m = scanner.nextInt();
          int[] starts = new int[n];
         int[] ends = new int[n];
         int[] points = new int[m];


        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        long startTime = System.nanoTime();
        //use fastCountSegments
        int[] cnt = fastCountSegments(starts, ends, points);

        for (int x : cnt) {
           System.out.print(x + " ");
        }

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
    }
}

