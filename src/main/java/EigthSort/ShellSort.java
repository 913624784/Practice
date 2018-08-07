package EigthSort;

import java.util.Arrays;

public class ShellSort {
    //平均时间复杂度n^1.3 最好n 最差n^2 不稳定
    //适用于较大规模无序的数据 插入排序的改进版
    /*先分组进行插入排序 按增量分组（下标）默认增量是数组长度的一半（依次减半）
      排序后数组基本有序  */
    /*
      增量序列{1，2，4，8...}最坏情况n^2
      增量序列{1,3,7，...,2^k-1}最坏情况n^1.5
      增量序列{1,5,19,41,109,...}最坏情况n^1.3
    */
    public static void sort(int[] array) {
        int length = array.length;
        //初始增量为数组长度一般 依次减半
        for(int gap=length>>1;gap>0;gap/=2){
            //依次对每个组进行插入排序
            for(int i=gap;i<length;i++){
                int temp=array[i];//待插元素
                int j;
                for(j=i-1;j>=0&&temp<array[j];j--){
                    array[j+1]=array[j];//比待插元素大的向后移
                }
                //将待插元素插入正确位置
                array[j+1]=temp;
            }
        }
        for(int b:array)
            System.out.print(b+" ");
    }
    /**
     * 希尔排序
     *
     * 1. 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；（一般初次取数组半长，之后每次再减半，直到增量为1）
     * 2. 按增量序列个数k，对序列进行k 趟排序；
     * 3. 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。
     *    仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
     * @param arr  待排序数组
     */
    public static void shellSort(int[] arr){
        int gap = arr.length / 2;
        for (; gap > 0; gap /= 2) {      //不断缩小gap，直到1为止
            for (int j = 0; (j+gap) < arr.length; j++){     //使用当前gap进行组内插入排序
                for(int k = 0; (k+gap)< arr.length; k += gap){
                    if(arr[k] > arr[k+gap]) {
                        int temp = arr[k+gap];      //交换操作
                        arr[k+gap] = arr[k];
                        arr[k] = temp;
                        System.out.println("    Sorting:  " + Arrays.toString(arr));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int a[]={1,5,3,6,7,1,2,5};
        shellSort(a);
        sort(a);
    }
}
