package EigthSort;


import java.util.Arrays;

public class QuickSort {
    private static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void sort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        int i = left;
        int j = right;
        int mid = arr[left];//假定第一个元素是中轴值
        while (i != j) {//当两个下标没遇到
            while (i < j && arr[j] >= mid) {//中轴右边的值大于中轴值 往左走
                j--;
            }
            while (i < j && arr[i] <= mid) {//中轴左边的值小于中轴值 往右走
                i++;
            }
            if (i < j) {//比较下标
                swap(arr, i, j);
            }
        }
        swap(arr, left, i);
        sort(arr, left, i - 1);//将左边的也排序
        sort(arr, j + 1, right);//将右边的也排序
        System.out.println(Arrays.toString(arr));
    }


    public static void main(String[] args) {
        int a[] = {1, 5, 3, 6, 7, 1, 2, 5};
        sort(a, 0, a.length - 1);
        for (int b : a)
            System.out.print(b + " ");
    }
}
