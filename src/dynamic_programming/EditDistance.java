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

      for (int i = 0; i < arr1.length; i++) {
          int x = i+1;

          for (int j = 0; j < arr2.length; j++) {
                int y = j+1;
              int top = matrix[x - 1][y];
              int left = matrix[x][y - 1];
              int adjacent = matrix[x - 1][y - 1];

              int min = left < top && left < adjacent ? left : adjacent < top ? adjacent : top;

              if (arr1[i] != arr2[j]) {
                  min++;
              } else {
                  min = adjacent;
              }
              matrix[x][y] = min;
          }
      }
    return matrix[arr1.length][arr2.length];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
