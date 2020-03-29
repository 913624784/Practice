package EigthSort;

public class HeapSort {
    //时间复杂度都是nlogn 不稳定

    /**
     * 交换索引为i，j的数据
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 如果插入的元素小于父节点 交换 直到大于等于父节点
     *
     * @param arr    存储堆的数组 元素从1开始 0不存有效值
     * @param insert 被插入节点的索引
     */
    //堆的上浮 插入
    public static void swim(int arr[], int insert) {
        int parent = insert / 2;//求出待插入元素父节点的索引
        if (arr[insert] < arr[parent]) {
            swap(arr, insert, parent);
            swim(arr, parent);
        }
    }

    /**
     * 对以arr[parentIndex]为父节点的对下沉
     * 选择左右孩子小的那个 如果不是父节点 交换
     * 继续下沉
     *
     * @param arr
     * @param parentIndex 父节点的索引
     */
    //堆的下沉
    public static void sink(int arr[], int parentIndex) {
        //堆的大小，0位置无有效元素
        int heapsize = arr.length - 1;
        //从父节点，选取左右孩子小的那一个，得到索引
        int minNodeIndex = minIndex(arr, parentIndex, heapsize);
        //如果最小的节点索引不是父节点，则说明最小节点在左右孩子中，交换下沉
        if (minNodeIndex != parentIndex) {
            swap(arr, minNodeIndex, parentIndex);
            sink(arr, minNodeIndex);
        }
    }

    /**
     * 求三个节点的最小值节点的索引
     *
     * @param arr
     * @param parentIndex 父节点索引
     * @param heapsize    堆大小
     * @return 最小节点索引
     */
    private static int minIndex(int arr[], int parentIndex, int heapsize) {
        int minIndex = parentIndex;//保存最小节点下标，默认父节点最小
        int leftIndex = 2 * parentIndex;//找到左孩子节点下标
        //判断leftIndex没越界，选取父节点和左孩子值较小的下标给minIndex
        if (leftIndex <= heapsize) {
            minIndex = arr[leftIndex] < arr[parentIndex] ? leftIndex : parentIndex;
        }
        int rightIndex = 2 * parentIndex + 1;//找到右孩子节点下标
        if (rightIndex <= heapsize) {
            minIndex = arr[rightIndex] < arr[minIndex] ? rightIndex : minIndex;
        }
        return minIndex;
    }

    /**
     * 将数组变成小根堆 建堆复杂度为n
     *
     * @param arr arr[0]是无效元素
     */
    public static void bulidheap(int arr[]) {
        int heapsize = arr.length - 1;
        //从第一个非叶子节点开始sink
        for (int i = heapsize / 2; i >= 1; i--) {
            sink(arr, i);
        }
    }

    /**
     * 删除堆中最小元素 复杂度为nlogn
     *
     * @param arr
     */
    public static void deletemin(int arr[]) {
        int heapsize = arr.length - 1;
        //交换堆顶与最后一个元素
        swap(arr, 1, heapsize);
        heapsize--;
        sink(arr, 1);
    }

    /**
     * 堆排序 不稳定 nlogn
     *
     * @param arr
     */
    public static void heapsort(int arr[]) {
        int N = arr.length - 1;
        bulidheap(arr);
        for (int i = 1; i < N - 1; i++) {
            deletemin(arr);
        }
    }

    public static void main(String[] args) {
        int a[] = {1, 5, 3, 6, 7, 1, 2, 5};
        heapsort(a);
        for (int b : a)
            System.out.print(b + " ");
    }

}
