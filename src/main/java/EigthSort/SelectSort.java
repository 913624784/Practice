package EigthSort;

import java.util.Arrays;

public class SelectSort {
    //时间复杂度都是n^2 不稳定
    public static void sort(int array[]) {
        int count = 0;
        //从无序区间挑选出最小值，挑选n-1次
        for (int i = 0; i < array.length - 1; i++) {
            //i下标左边是有序的 右边（包括i）是无序的
            //最小值下标默认是无序区间第一个元素的下标
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {//如果前者大于后者 交换
                    int t = array[i];
                    array[i] = array[j];
                    array[j] = t;
                    System.out.println("Sorting:  " + Arrays.toString(array) + ",比较次数:" + (++count));
                }
            }
        }
    }

    public static void main(String[] args) {
        int a[] = {1, 5, 3, 6, 7, 1, 2, 5};
        sort(a);
    }
}
