package sort;

import java.util.*;

//Inversion Count for an array indicates – how far (or close) the array is from being sorted.
// If array is already sorted then inversion count is 0. If array is sorted in reverse order
// that inversion count is the maximum.
//Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j

public class Inversions {

    private static long getNumberOfInversions(int[] a, int left, int right) {
        long numberOfInversions = 0;
        if (right <= left) {
            return numberOfInversions;
        }
        int mid =  left + ((right - left) / 2);
        numberOfInversions += getNumberOfInversions(a, left, mid);
        numberOfInversions += getNumberOfInversions(a, mid+1, right);
        //write your code here
        numberOfInversions += mergeInversion(a, left, mid, right);
        return numberOfInversions;
    }

    private  static long mergeInversion(int[] arr, int left, int mid, int right) {
        int leftArrSize = mid - left + 1;
        int rightArrSize = right - mid;
        int[] leftArr = new int[leftArrSize];
        int[] rightArr = new int[rightArrSize];

        int count = 0;

        for (int i = 0; i< leftArrSize ; i++) {
            leftArr[i] = arr[left+i];
        }

        for (int i = 0; i < rightArrSize; i++) {
            rightArr[i] = arr[mid+1+i];
        }

        int tempStart = left;
        int leftPtr = 0;
        int rightPtr = 0;

        while ( leftPtr < leftArrSize && rightPtr < rightArrSize) {
            if (leftArr[leftPtr] <= rightArr[rightPtr]) {
                arr[tempStart] = leftArr[leftPtr];
                leftPtr++;
            } else {
                // adding 1 for current leftPtr which is greater then rightPtr
                // if leftPtr is greater then rightPtr also next left ptr will also greater then rightPtr
                // that's why calculating total num remaining left ptr from current left ptr
                count = count + 1 + (leftArrSize - 1 - leftPtr);
                arr[tempStart] = rightArr[rightPtr];
                rightPtr++;
            }
            tempStart++;
        }

        while (leftPtr < leftArrSize) {
            arr[tempStart] = leftArr[leftPtr];
            leftPtr++;
            tempStart++;
        }

        while (rightPtr < rightArrSize) {
            arr[tempStart] = rightArr[rightPtr];
            rightPtr++;
            tempStart++;
        }

        return  count;
    }

    public static void main(String[] args) {
       /* Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }*/
       int a[] = {2,4,1,3,5};
        System.out.println(getNumberOfInversions(a,  0,a.length -1));
        System.out.println();
        Arrays.stream(a).forEach(data -> System.out.print("  "+data));
    }
}

