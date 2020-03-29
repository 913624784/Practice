package EigthSort;

import java.util.Arrays;

public class GuluguluSort {//n^2时间复杂度

    public static void sort(int arr[]) {
        boolean flag = true;
        while (flag) {
            flag = false;
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length - 1; j++) {
                    if (arr[j] > arr[j + 1]) {//如果前者比后者大 交换
                        arr[j] ^= arr[j + 1];
                        arr[j + 1] ^= arr[j];
                        arr[j] ^= arr[j + 1];
                        flag = true;
                        System.out.println(Arrays.toString(arr) + ",比较次数：" + (++count));
                    }
                }
            }
        }
    }

    public static void sort1(int arr[]) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] ^= arr[j + 1];
                    arr[j + 1] ^= arr[j];
                    arr[j] ^= arr[j + 1];
                    System.out.println(Arrays.toString(arr) + ",未优化比较次数：" + (++count));
                }
            }
        }
    }

    public static void main(String[] args) {
        int a[] = {1, 5, 3, 6, 7, 1, 2, 5};
        sort(a);
        sort1(a);
    }
}
