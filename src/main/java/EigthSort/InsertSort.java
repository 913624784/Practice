package EigthSort;

import java.util.Arrays;

public class InsertSort {
    //平均时间复杂度n^2 最好n 最坏n^2 稳定
    //适用于小规模数据和有序程度较高的数据
    public static void sort(int array[]) {
        //假定第一个元素是有序的，从第二个位置开始
        int count=0;
        for(int i=1;i<array.length;i++){
            int insert=array[i];//先把要插入的数保存下来
            int j;
            for(j=i-1;j>=0&&array[j]>insert;j--){//如果前一个元素大于后一个元素
                array[j+1]=array[j];//把大的元素向后移

            }
            //将待插元素插入正确位置
            array[j+1]=insert;
            System.out.println(Arrays.toString(array)+",比较次数："+(++count));
        }
    }
    /**
     * 插入排序
     *
     * 1. 从第一个元素开始，该元素可以认为已经被排序
     * 2. 取出下一个元素，在已经排序的元素序列中从后向前扫描
     * 3. 如果该元素（已排序）大于新元素，将该元素移到下一位置
     * 4. 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
     * 5. 将新元素插入到该位置后
     * 6. 重复步骤2~5
     * @param arr  待排序数组
     */
    public static void insertionSort(int[] arr){
        int count=0;
        for( int i=0; i<arr.length-1; i++ ) {//从第一个元素开始
            for( int j=i+1; j>0; j-- ) {//要插入的元素
                if( arr[j-1] <= arr[j] ) {//后者比前者大break 直到遇到比当前元素小的就交换
                    break;
                }
                //交换操作
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                System.out.println("Sorting:  " + Arrays.toString(arr)+",比较次数:"+(++count));
            }
        }
    }
    public static void main(String[] args) {
        int a[]={1,5,3,6,7,1,2,5};

        insertionSort(a);
//        sort(a);
    }
}
