public class J_1SelectInDoubleArray {
    public static boolean Find(int[][] array, int target) {
        int row = 0;
        int col = array[0].length - 1;
        while (row <= array.length - 1 && col >= 0) {
            if (target == array[row][col]) {
                return true;
            } else if (target > array[row][col])
                row++;
            else
                col--;
        }
        return false;

    }

    public static void main(String[] args) {
        int array[][] = {{1, 2, 3, 4, 8}, {2, 3, 4, 5, 6}, {3, 4, 5, 6, 54}, {4, 5, 6, 7, 5}};
        System.out.println(Find(array, 5));
    }
}
