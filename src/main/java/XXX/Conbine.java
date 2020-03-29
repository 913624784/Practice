package XXX;

import java.util.Arrays;

public class Conbine {
    public static int[] combine(int a[], int b[]) {
        int result[] = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }
        while (i < a.length) {
            result[k++] = a[i++];
        }
        while (j < b.length) {
            result[k++] = b[j++];
        }
        return result;
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 5, 8, 11};
        int b[] = {11, 22, 33, 54, 58, 61};
        for (int t : combine(a, b)) {
            System.out.print(t + ",");
        }
        System.out.println(Arrays.toString(combine(new int[]{1, 2, 5, 8}, new int[]{3, 4, 6, 7})));
    }
}
