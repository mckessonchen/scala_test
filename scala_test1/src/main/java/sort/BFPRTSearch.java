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
        for (int n = 0; n < arr.length; n++) {
            System.out.println("第" + n + "大数为：" + BFPRT(arr, 0, arr.length - 1, n));
        }
    }

    private static int BFPRT(int[] arr, int low, int high, int n) {
        int num = findMid(arr, low, high);// 寻找中位数的中位数
        return 0;
    }

    private static int findMid(int[] arr, int low, int high) {
        if (low == high) return arr[low];
        int i = 0;
        int n = 0;
        for (i = low; i < high - 5; i += 5) {
            insertSort(arr, i, i + 4);
            n = i - low;
            swap(arr, low + n / 5, i + 2);
        }
        int num = high - i + 1;
        if (num > 0) {
            insertSort(arr, i, high);
            n = i - low;
            swap(arr,low + n / 5, i + num /2);
        }
        n /= 5;
        if (n == 1) return arr[low];
        return findMid(arr, low, low + n);
    }

    private static void swap(int[] arr, int i, int i1) {
        int temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
    }

    private static void insertSort(int[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            if (arr[i - 1] > arr[i]) {
                int temp = arr[i];
                int j = i;
                while (j > low && arr[j - 1] > temp) {
                    arr[j] = arr[j - 1];
                    j--;
                }
                arr[j] = temp;
            }
        }
    }
}
