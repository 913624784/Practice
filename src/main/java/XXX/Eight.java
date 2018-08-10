package XXX;

import java.util.Arrays;

public class Eight {
    public void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        int arr[]={1,34,5,6,77,89,4,32,3};
        Eight eight=new Eight();
//        eight.quick(arr,0,arr.length-1);
        System.out.println(eight.serach(arr,77));
    }
    public int serach(int arr[],int target){
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            else if (arr[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
    public void quick(int arr[],int left,int right){
        if(left>right){
            return ;
        }
        int i=left;
        int j=right;
        int mid=arr[left];//假定第一个元素是中轴值
        while (i!=j){//当两个下标没遇到
            while (i<j&&arr[j]>=mid){//中轴右边的值大于中轴值 往左走
                j--;
            }
            while (i<j&&arr[i]<=mid){//中轴左边的值小于中轴值 往右走
                i++;
            }
            if(i<j){//比较下标
                swap(arr,i,j);
            }
        }
        swap(arr,left,i);
        quick(arr,left,i-1);//将左边的也排序
        quick(arr,j+1,right);//将右边的也排序
        System.out.println(Arrays.toString(arr));
    }
    public void shell(int arr[]){
        int h=1;
        while (h<arr.length/3){
            h=h*3+1;
        }
        while (h>=1){
            for (int i=1;i<arr.length;i++){
                for (int j=i;j>=h&&arr[j]<arr[j-h];j--){
                    swap(arr,j,j-h);
                }
            }
            h=h/3;
        }
        System.out.println(Arrays.toString(arr));
    }
    public void insert(int arr[]){
        for (int i=1;i<arr.length;i++){
            for (int j=i;j>0&&arr[j]<arr[j-1];j--){
                swap(arr,j,j-1);
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public void select(int arr[]){
        for (int i=0;i<arr.length;i++){
            int min=i;
            for (int j=i+1;j<arr.length;j++){
                if (arr[j]<arr[min])
                    min=j;
            }
            swap(arr,i,min);
        }
        System.out.println(Arrays.toString(arr));
    }
    public void maopao(int arr[]){
        boolean b=true;
        while (b){
            b=false;
            for (int i=0;i<arr.length;i++){
                for (int j=0;j<arr.length-1;j++){
                    if (arr[j]>arr[j+1]){
                        swap(arr,j,j+1);
                        b=true;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
