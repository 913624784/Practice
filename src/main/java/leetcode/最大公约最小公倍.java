package leetcode;

public class 最大公约最小公倍 {
    int gongyue(int a, int b) {
        return b == 0 ? a : gongyue(b, a% b);
    }
    int gongbei(int a, int b) {
        return a * b / gongyue(a, b);
    }

}
