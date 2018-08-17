package leetcode;

public class 求两数的和为一个目标值 {
    public static int[] target(int arr[],int target){
        int i=0,j=arr.length-1;
        while (i<j){
            int num=arr[i]+arr[j];
            if (num==target){
                return new int[]{i+1,j+1};
            }else if (num>target){
                j--;
            }else {
                i++;
            }
        }
        return null;
    }
}
