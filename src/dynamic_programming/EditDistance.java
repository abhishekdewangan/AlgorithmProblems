package dynamic_programming;

import java.util.*;

class EditDistance {
  public static int EditDistance(String s, String t) {
    //write your code here
    char[] arr1 = s.toCharArray();
    char[] arr2 = t.toCharArray();
    int [][] matrix = new int[s.length()+1][t.length()+1];
    for (int i = 0; i < s.length()+1; i++) {
      matrix[i][0] = i;
    }
    for (int j =0; j < t.length()+1; j++) {
      matrix[0][j] = j;
    }

    for (int i = 1 ; i< arr1.length ; i++) {
       for (int j = 1; j< arr2.length; j++) {
         int left = matrix[i-1][j-1];
         int top = matrix[i][j-1];
         int adjacent = matrix[i-1][j-1];
         int min = left < top && left < adjacent ? left : adjacent < top ? adjacent : top;
         if (arr1[i] != arr2[j]) {
           min = min +1;
         }
         matrix[i][j] = min;
       }
    }
    return matrix[arr1.length-1][arr2.length-1];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
