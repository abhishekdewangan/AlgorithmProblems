package dynamic_programming;

import java.util.*;

/*
* You are given a primitive calculator that can perform the following three operations with the current number
* 𝑥: multiply 𝑥 by 2, multiply 𝑥 by 3, or add 1 to 𝑥.
* Your goal is given a positive integer 𝑛, find the minimum number of operations needed to obtain the number 𝑛
* starting from the number 1.*/
 class PrimitiveCalculator {

    private static List<Integer> dp_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        int [] a = new int[n+1];
        for(int i =1; i< a.length; i++){
            a[i] = a[i-1]+1;
            if (i%2 == 0)
                a[i] = Math.min(1+a[i/2], a[i]);
            if (i%3 == 0)
                a[i] = Math.min(1+a[i/3], a[i]);
        }
        int i = n;
        while (i>1) {
            sequence.add(i);
            if (a[i-1] == a[i]-1)
                i = i-1;
            else if (i%2 == 0 && (a[i/2] == a[i]-1))
                i = i/2;
            else if (i%3 == 0 && (a[i/3] == a[i]-1))
                i = i/3;
        }
        sequence.add(1);
        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = dp_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

