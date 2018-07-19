package dynamic_programming;

import java.util.Scanner;

/**
 * Created by praveendewangan on 17/07/18.
 */
public class TempleOffering {

    public static int optimizeTempleOffering(int[] templeHeight) {
        int sum = 0;
        Height templeOffer[] = new Height[templeHeight.length];

        for (int i = 0 ; i< templeOffer.length ; i++) {
            templeOffer[i] = new Height();
        }

        templeOffer[0].left = 1;
        templeOffer[templeOffer.length -1].right = 1;

        // calculating left height
        for (int i = 1; i < templeHeight.length; i++) {
            if (templeHeight[i] > templeHeight[i - 1]) {
                templeOffer[i].left = templeOffer[i-1].left + 1;
            } else  {
                templeOffer[i].left = 1;
            }
        }

        // calculating right height
        for (int j = templeOffer.length -2 ; j>=0 ; j--) {
            if (templeHeight[j] > templeHeight[j+1]) {
                templeOffer[j].right = templeOffer[j+1].right + 1;
            }
        }


        //calculating final sum
        for (int i = 0; i< templeOffer.length ; i++) {
            sum = templeOffer[i].left > templeOffer[i].right ?
                    templeOffer[i].left + sum : templeOffer[i].right + sum;
        }

        return sum;
    }

    public static class Height {
        int left = -1;
        int right = -2;
    }

    public static int naiveTempleOffering(int[] templeHeight) {
        int sum = 0;
        for (int i = 0 ; i< templeHeight.length ; i++) {
            int left = 0, right = 0;
            for (int j = i-1; j >= 0 ; j--) {
                if (templeHeight[j] < templeHeight[j+1]) {
                   left ++;
                } else {
                    break;
                }
            }

            for (int j = i +1 ; j < templeHeight.length; j++) {
                if (templeHeight[j] < templeHeight[j-1]) {
                    right++;
                } else {
                    break;
                }
            }

            sum = left > right ? left+sum : right+sum;
            sum++;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] templeHeights =  {1,4,3,6,2,1};
        System.out.println("max offering :: "+optimizeTempleOffering(templeHeights));
    }
}
