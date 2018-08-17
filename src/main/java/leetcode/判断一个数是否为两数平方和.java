package leetcode;

public class 判断一个数是否为两数平方和 {
    public boolean sqrt(int target){
        int i=0,j=(int)Math.sqrt(target);
        while (i<=j){
            int num=i*i+j*j;
            if (num==target){
                return true;
            }else if (num>target){
                i++;
            }else {
                j--;
            }
        }
        return false;
    }
}
