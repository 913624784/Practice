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
        System.out.println(Arrays.toString(arr));
        Eight eight=new Eight();
//        eight.sort(arr,0,arr.length-1,new int[arr.length]);
        eight.heapSort(arr);
        System.out.println(Arrays.toString(arr));
//        eight.quick(arr,0,arr.length-1);
//        System.out.println(eight.serach(arr,6));
    }
    public  void heapSort(int[] a) {
        int i;
        for (i = a.length / 2 - 1; i >= 0; i--) {// 构建一个大顶堆
            heap(a, i, a.length - 1);
        }
        for (i = a.length - 1; i >= 0; i--) {// 将堆顶记录和当前未经排序子序列的最后一个记录交换
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            heap(a, 0, i - 1);// 将a中前i-1个记录重新调整为大顶堆
        }
    }
    public void heap(int[] a, int i, int len){
        int temp, j;
        temp = a[i];
        for (j = 2 * i; j < len; j *= 2) {// 沿关键字较大的孩子结点向下筛选
            if (j < len && a[j] < a[j + 1])
                ++j; // j为关键字中较大记录的下标
            if (temp >= a[j])
                break;
            a[i] = a[j];
            i = j;
        }
        a[i] = temp;
    }

    public void sort(int[] arr,int left,int right,int []temp){
        if(left<right){
            int mid = (left+right)/2;
            sort(arr,left,mid,temp);
            sort(arr,mid+1,right,temp);
            merge(arr,left,mid,right,temp);
        }
    }
    public void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;
        int j = mid+1;
        int t = 0;
        while (i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        while(i<=mid){
            temp[t++] = arr[i++];
        }
        while(j<=right){
            temp[t++] = arr[j++];
        }
        t = 0;
        while(left <= right){
            arr[left++] = temp[t++];
        }
    }
    public int serach(int arr[],int target){
        int l = 0, h = arr.length - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (arr[m] == target) {
                return m;
            } else if (arr[m] > target) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
    public void quick(int arr[],int left,int right){
        if (left>right){
            return;
        }
        int i=left;
        int j=right;
        int mid=arr[left];
        while (i!=j){
            while (i<j&&arr[j]>=mid){
                j--;
            }
            while (i<j&&arr[i]<=mid){
                i++;
            }
            if (i<j){
                swap(arr,i,j);
            }
        }
        swap(arr,left,i);
        quick(arr,left,i-1);
        quick(arr,j+1,right);
        System.out.println(Arrays.toString(arr));
    }
    public void shell(int arr[]) {
        int h = 1;
        while (h <= arr.length / 3){
            h = h * 3 + 1;
        }
        while (h>=1){
            for (int i=1;i<arr.length;i++){
                for (int j=i;j>=h&&arr[j]<arr[j-1];j--){
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
                if (arr[min] > arr[j]){
                    min=j;
                }
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
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}
