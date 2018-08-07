import org.junit.Test;

import java.util.Arrays;

public class EightSort {
    public void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    int array[] = {1, 23, 56, 78, 98, 76, 4, 100, 24};

    @Test
    public void testsort() {
        System.out.println("排序前：" + Arrays.toString(array));

//        selectsort(array);
//        maopaosort(array);
//        insertsort(array);
//        shellsort(array);
//        jishusort(array);
//        heapsort(array);
//        mergesort(array);
//        quicksort(array,0,array.length-1);
//        System.out.println("快排：" + Arrays.toString(array));
    }

    /**
     * 选择排序，默认第一个值是已经排好的，设置min 保存当前最小值下标
     * 通过循环对后一个数比较，替换min的值，在第一层循环替换min 和 i
     * 对应的元素
     *
     * @param arr
     */
    public void selectsort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            swap(arr, min, i);
        }
        System.out.println("选择：" + Arrays.toString(arr));
    }

    /**
     * 冒泡排序，优化方法，设置一个boolean，通过while循环，如果有交换，
     * 就把boolean设为true，否则不动
     *
     * @param arr
     */
    public void maopaosort(int arr[]) {
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        swap(arr, j, j + 1);
                        flag = true;
                    }
                }
            }
        }
        System.out.println("冒泡：" + Arrays.toString(arr));
    }

    /**
     * 插入排序，默认第一个数是排好序的，下标从1开始，逐个和前面的值比较
     * 交换
     *
     * @param arr
     */
    public void insertsort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && (arr[j] < arr[j - 1]); j--) {
                swap(arr, j, j - 1);
            }
        }
        System.out.println("插入：" + Arrays.toString(arr));
    }

    /**
     * 希尔排序，通过不断交换相邻h的元素，直到h为1时排序结束，获得一个h
     * 的增量序列,初始h为1，每次3*h+1
     *
     * @param arr
     */
    public void shellsort(int arr[]) {
        int h = 1;
        while (h < arr.length / 3) {
            h = 3 * h + 1;  // 1, 4, 13, 40, ...
        }
        while (h >= 1) {
            for (int i = h; i < arr.length; i++) {
                for (int j = i; j >= h && arr[j] < arr[j - h]; j -= h) {
                    swap(arr, j, j - h);
                }
            }
            h = h / 3;
        }
        System.out.println("希尔：" + Arrays.toString(arr));
    }

    /**
     * 设定两个下标，设定切分单元mid，使mid左边的数比arr[mid]小，mid右边
     * 的数比arr[mid]大，归并两个数组，设定两个下标分别往左往右走，相遇大
     * 的交换
     *
     * @param arr
     * @param left
     * @param right
     */
    public void quicksort(int arr[], int left, int right) {
        if (left > right) {
            return;
        }
        int i = left;
        int j = right;
        int mid = arr[left];
        while (i != j) {
            while (i < j && arr[j] >= mid) {
                j--;
            }
            while (i < j && arr[i] <= mid) {
                i++;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, left, i);
        quicksort(arr, left, i - 1);
        quicksort(arr, j + 1, right);

    }


    public void mergesort(int arr[],int left,int right) {

        System.out.println("归并：" + Arrays.toString(arr));
    }

    public void jishusort(int arr[]) {

        System.out.println("基数：" + Arrays.toString(arr));
    }

    public void heapsort(int arr[]) {

        System.out.println("堆排：" + Arrays.toString(arr));
    }


}
