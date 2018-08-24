package leetcode;

public class 二分查找 {
   public  int search(int arr[],int target){
       int i=0,j=arr.length-1;
       while (i<=j){
           int mid=i+(j-i)/2;
           if (arr[mid]==target)
               return mid;
           else if (arr[mid]>target)
               j=mid-1;
           else
               i=mid+1;

       }
       return -1;
   }
   public static int search2(int arr[],int target){
       int i=0,j=arr.length;
       while (i<j){
           int mid=i+(j-i)/2;
           if (arr[mid]>=target)
               j=mid;
           else
               i=mid+1;
       }
       return i;
   }
}
