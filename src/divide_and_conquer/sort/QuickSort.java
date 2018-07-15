package divide_and_conquer.sort;

import java.util.Arrays;

/**
 * Created by praveendewangan on 13/07/18.
 */
public class QuickSort {
    int[] arr;

    public QuickSort(int[] arr) {
        this.arr = arr;
    }

    public void basicSort(int[] arr) {
        basicQuickSort(arr, 0, arr.length - 1);
    }

    // will also handle and duplicate element
    public void advanceSort(int[] arr) {
        advanceQuickSort(arr, 0, arr.length-1);
    }

    private void basicQuickSort(int[] arr, int start, int end) {
        if (start >= end) return;

        // @Var partitionIndex will contain correct position of pivot
        // and left to pivot will be always less or equal
        // right to pivot always be greater
        int partitionIndex = basicQuickPartition(arr, start, end);

        basicQuickSort(arr, start, partitionIndex - 1);

        basicQuickSort(arr, partitionIndex + 1, end);

    }

    private int basicQuickPartition(int[] arr, int start, int end) {
        int front = start;
        int pivot = arr[start];
        for (int index = start + 1; index <= end; index++) {
            if (arr[index] <= pivot) {
                front++;
                int temp = arr[front];
                arr[front] = arr[index];
                arr[index] = temp;
            }
        }
        // swap index with pivot index
        int temp = arr[front];
        arr[front] = arr[start];
        arr[start] = temp;
        return front;
    }

    private void advanceQuickSort(int[] arr, int start, int end) {
        if (start >= end) return;

        Integer lb = start;
        Integer ub = end;

        int[] props = advanceQuickPartition(arr, start, end, lb, ub);

        advanceQuickSort(arr,start, props[0]-1);
        advanceQuickSort(arr,props[1]+1, end);
    }

    private int[] advanceQuickPartition(int[] arr, int start, int end, Integer lb, Integer ub) {

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

    public static void main(String[] args) {
        int[] arr = {4, 7, 4, 1, 9, 4, 5, 7, 3, 2, 4,5};
        QuickSort quickSort = new QuickSort(arr);
        quickSort.advanceSort(arr);

        Arrays.stream(arr).forEach(data -> System.out.print(" " + data));
    }

}
