package leetcode;

import java.util.Arrays;

public class 合并两个有序数组 {
    public static int[] combine(int arr[], int brr[]) {
        int temp[] = new int[arr.length + brr.length];
        int i = 0, j = 0, k = 0;
        while (i < arr.length && j < brr.length) {
            if (arr[i] <= brr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = brr[j++];
            }
        }
        while (i < arr.length) {
            temp[k++] = arr[i++];
        }
        while (j < brr.length) {
            temp[k++] = brr[j++];
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(combine(new int[]{1, 2, 5, 8}, new int[]{3, 4, 6, 7})));
    }
}
