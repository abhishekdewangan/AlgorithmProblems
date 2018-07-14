package search;

/**
 * Created by praveendewangan on 14/07/18.
 */
public class BinarySearch {
    int[] arr ;

    public BinarySearch(int[] arr) {
        this.arr = arr;
    }

    public int find(int element) {
        return search(0, arr.length -1, element);
    }

    private int search(int start, int end, int element) {
        if (start >= end) {
            return start;
        }

        int mid = start + ((end - start)/2);

        if (arr[mid] == element) {
            return mid;
        }
        if (element < arr[mid]) {
           return search(start, mid -1, element);
        } else {
           return search(mid + 1, end, element);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,5,6,7,8,9};
        BinarySearch binarySearch = new BinarySearch(arr);
        int index = binarySearch.find(3);
        System.out.println(" found index "+ index);
    }
}
