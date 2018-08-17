package leetcode;

import java.util.Arrays;

public class 改变数组元素使所有的数组元素都相等 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int move = 0;
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            move += nums[h] - nums[l];
            l++;
            h--;
        }
        return move;
    }
}
