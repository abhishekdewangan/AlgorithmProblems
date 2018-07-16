package dynamic_programming;

import java.util.HashMap;
import java.util.Scanner;

public class ChangeDP {

    private static int getChange(int m, HashMap<Integer, Integer> valueMap) {
        //write your code here
        if (m ==0) {
            valueMap.put(m, 0);
            return 0;
        }
        // 1 3 4
        int[] coins = {1, 3, 4};
        int count = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (m >= coin) {
                int value;
                if (valueMap.containsKey(m-coin)) {
                    value = valueMap.get(m-coin);
                }else {
                    value = getChange(m-coin, valueMap);
                    valueMap.put(m-coin, value);
                }
                value = value + 1;
                if ( count > value) {
                    count = value;
                }
            }
        }
        valueMap.put(m, count);
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m, new HashMap<>()));
    }
}

