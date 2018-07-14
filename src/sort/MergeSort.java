package sort;

import java.util.Arrays;

/**
 * Created by praveendewangan on 14/07/18.
 */
public class MergeSort {
    private int[] arr;

    public MergeSort(int[] arr) {
        this.arr = arr;
    }

    public void sort() {
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int start, int end) {
        if (start >= end) return;

        int mid = start + ((end - start) / 2);

        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        merge(arr, start, mid, end);
    }

    private void merge(int[] arr, int start, int mid, int end) {
        int left = mid - start + 1;
        int right = end - mid;

        int[] leftArray = new int[left];
        int[] rightArray = new int[right];

        for (int i = 0; i < left; i++) {
            leftArray[i] = arr[start + i];
        }

        for (int j = 0; j < right; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        int leftStart = 0;
        int rightStart = 0;
        int startArrayIndex = start;

        while (leftStart < left && rightStart < right) {
            if (leftArray[leftStart] <= rightArray[rightStart]) {
                arr[startArrayIndex] = leftArray[leftStart];
                leftStart++;
            } else {
                arr[startArrayIndex] = rightArray[rightStart];
                rightStart++;
            }
            startArrayIndex ++;
        }
        while (leftStart < left) {
            arr[startArrayIndex] = leftArray[leftStart];
            leftStart++;
            startArrayIndex++;
        }
        while (rightStart < right) {
            arr[startArrayIndex] = rightArray[rightStart];
            rightStart++;
            startArrayIndex++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {7,6,5,4,3,2,1};
        MergeSort sort = new MergeSort(arr);
        sort.sort();

        Arrays.stream(arr).forEach(data -> System.out.print(" "+data));
    }
}
