package leetcode;

public class 素数 {
    public static void sushu() {
        int j;
        boolean flag;
        for (int i = 2; i < 1000; i++) {
            flag = false;
            for (j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                System.out.print(i + "    ");
            }
        }
    }

    public static void main(String[] args) {
        sushu();
    }
}
