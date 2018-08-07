package jianzhioffer;

public class 跳台阶 {
    public static int JumpFloor(int target) {
        if (target <= 2)
            return target;
        int first = 1, second = 2, third = 0;
        for (int i = 3; i <= target; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }

    public static void main(String[] args) {
        System.out.println(JumpFloor(6));
    }
}
