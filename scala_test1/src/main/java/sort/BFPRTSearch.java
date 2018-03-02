package sort;

/**
 * Created by chenteng on 2018/2/27.
 * <p>
 * 把快排的pviot取值为中位数的中位数
 * <p>
 * TOP-k 问题
 */

public class BFPRTSearch {
    public static void main(String[] args) {
        int arr[] = {1, 3, 6, 4, 21, 7, 9, 8,2,15,34,77,32,22,33};
        for (int n = 1; n <= arr.length; n++) {
            System.out.println("第" + n + "大数为：" + BFPRT(arr, 0, arr.length - 1, arr.length - n + 1));
        }
    }

    private static int BFPRT(int[] arr, int left, int right, int k) {
        int pivot = findMid(arr, left, right);
        int pivotIndex = findIndex(arr, left, right, pivot);
        int divideIndex = partition(arr, left, right, pivotIndex);

        int num = divideIndex - left + 1;
        if (k == num) return arr[divideIndex];
        if (k > num) return BFPRT(arr, divideIndex + 1, right, k - num);
        else return BFPRT(arr, left, divideIndex - 1, k);
    }

    private static int partition(int[] arr, int left, int right, int pivotIndex) {
        int i = left;
        int j = right;
        swap(arr, pivotIndex, i);
        int temp = arr[i];
        for (; i < j; ) {
            for (; i < j && arr[j] >= temp; ) j--;
            arr[i] = arr[j];
            for (; i < j && arr[i] <= temp; ) i++;
            arr[j] = arr[i];
        }
        arr[i] = temp;
        return i;
    }


    private static int findIndex(int[] arr, int left, int right, int pivot) {
        for (int i = left; i <= right; i++) {
            if (arr[i] == pivot)
                return i;
        }
        return -1;
    }

    private static int findMid(int[] arr, int left, int right) {
        if (left == right) return arr[left];
        int i = 0;
        int n = 0;
        for (i = left; i < right - 5; i += 5) {
            insertSort(arr, i, i + 4);
            n = i - left;
            swap(arr, left + n / 5, i + 2);
        }
        int num = right - i + 1;
        if (num > 0) {
            insertSort(arr, i, i + num - 1);
            n = i - left;
            swap(arr, left + n / 5, i + num / 2);
        }
        n /= 5;
        if (n == 1) return arr[left];
        return findMid(arr, left, left + n);
    }

    private static void swap(int[] arr, int i, int mid) {
        int temp = arr[i];
        arr[i] = arr[mid];
        arr[mid] = temp;
    }

    private static void insertSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < arr[i - 1]) {
                int temp = arr[i];
                int j = i;
                while (j >= 0 && arr[j - 1] > temp) {
                    arr[j] = arr[j - 1];
                    j--;
                }
                arr[j] = temp;
            }
        }
    }
}