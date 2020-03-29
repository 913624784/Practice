public class Test {
    public void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void maopao(int arr[]) {
        boolean b = true;
        while (b) {
            b = false;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        swap(arr, i, j);
                        b = true;
                    }
                }
            }
        }
    }

    public void select(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            swap(arr, min, i);
        }
    }

    public void insert(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    public void shell(int arr[]) {
        int h = 1;
        while (h <= arr.length / 3) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            for (int i = h; i < arr.length; i++) {
                for (int j = i; j >= h && arr[j] < arr[j - h]; j -= h) {
                    swap(arr, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    public void quick(int arr[], int left, int right) {
        int i = left;
        int j = right;
        int mid = arr[left];
        while (i != j) {
            while (i < j && arr[j] <= mid) {
                j--;
            }
            while (i < j && arr[i] >= mid) {
                i++;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, left, i);
        quick(arr, left, i - 1);
        quick(arr, j + 1, right);
    }

    public void merge(int arr[], int left, int mid, int right, int temp[]) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        t = 0;
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }

    public void mergesort(int arr[], int left, int right, int temp[]) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergesort(arr, left, mid, temp);
            mergesort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    public int search(int arr[], int target) {
        int i = 0, j = arr.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] > target)
                j = mid - 1;
            else
                i = mid + 1;
        }
        return -1;
    }

    public int search2(int arr[], int target) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (arr[mid] <= target)
                return mid;
            else
                i = mid + 1;
        }
        return i;
    }

}
