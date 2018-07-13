package sort;

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

    public void advanceSort(int[] arr) {

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
        return  front;
    }

    public static void main(String[] args) {
        int[] arr = {4,7,4,1,9,5,7,3,2,5};
        QuickSort quickSort = new QuickSort(arr);
        quickSort.basicSort(arr);

        Arrays.stream(arr).forEach(data -> System.out.println(" "+data));
    }

}
