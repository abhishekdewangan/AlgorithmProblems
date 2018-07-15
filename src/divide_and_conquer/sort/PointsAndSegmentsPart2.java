package divide_and_conquer.sort;

import java.util.*;

public class PointsAndSegmentsPart2 {

    private static int[] fastCountSegments(RangeValue[] rangeValues, int[] values) {
        int[] countResults = new int[values.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (RangeValue value : rangeValues) {
            switch (value.valueType) {
                case "Left":
                    count++;
                    break;
                case "Right":
                    count--;
                    break;
                default:
                    map.put(value.value, count);
                    break;
            }
        }
        for (int i = 0 ; i < values.length ; i++) {
            countResults[i] = map.get(values[i]);
        }
        return countResults;
    }

    private static void sort (RangeValue[] arr, int start, int end) {
        if (start >= end) return;

        swapRandomNoInRangeWithFirst(arr, start, end);

        int partitionPos = partition(arr, start, end);

        sort(arr,  start, partitionPos -1);
        sort(arr, partitionPos + 1, end);

    }

    private static void swapRandomNoInRangeWithFirst(RangeValue[] arr, int start, int end) {
        int random = new Random().nextInt((end - start) + 1) + start;
        swap(arr[start], arr[random]);
    }

    private static void swap(RangeValue val1, RangeValue val2) {
        int tempValue = val1.value;
        String type = val1.valueType;
        val1.value = val2.value;
        val1.valueType = val2.valueType;
        val2.value = tempValue;
        val2.valueType = type;
    }

    private static int partition(RangeValue[] arr, int start, int end) {
        int pivot = arr[start].value;
        int l = start;

        for (int ptr = start + 1; ptr <= end; ptr ++) {

            if (arr[ptr].value < pivot) {
                l++;
                swap(arr[l], arr[ptr]);
            }
        }

       swap(arr[start], arr[l]);

        return  l;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//1413850
//1185598
        int n, m;
         n = scanner.nextInt();
         m = scanner.nextInt();
         int values[] = new int[m];
         RangeValue[] array = new RangeValue[n+n+m];
        int index = 0;

        for (int i = 0; i < n; i++) {
            RangeValue rangeValueStart = new RangeValue(scanner.nextInt(), "Left");
            array[index] = rangeValueStart;
            index ++;

            RangeValue rangeValueEnd = new RangeValue(scanner.nextInt(), "Right");
            array[index] = rangeValueEnd;
            index ++;
        }
        for (int i = 0; i < m; i++) {
            RangeValue rangeValueStart = new RangeValue(scanner.nextInt(), "Value");
            array[index] = rangeValueStart;
            values[i] = rangeValueStart.value;
            index ++;
        }
        long startTime = System.nanoTime();


        sort(array, 0, array.length-1);

       // Arrays.stream(array).forEach(data -> System.out.println(data.toString()));
        //use fastCountSegments
        int[] cnt = fastCountSegments(array, values);

        for (int x : cnt) {
           System.out.print(x + " ");
        }

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
    }

    public static class RangeValue {
        int value;
        String valueType;

        public RangeValue(int value, String valueType) {
            this.value = value;
            this.valueType = valueType;
        }

        @Override
        public String toString() {
            return  "value=" + value +", valueType='" + valueType;
        }
    }
}

