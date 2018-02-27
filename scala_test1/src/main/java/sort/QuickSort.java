package sort;

import java.util.Arrays;

/**
 * Created by chenteng on 2018/2/27.
 */

public class QuickSort {
    public static void main(String[] args) {
//        System.out.println(findPviot(15, 10, 5));
        int arr[] = {1, 3, 6, 4, 21, 7, 9, 8};
        qsort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void qsort(int[] arr, int low, int high) {
        if (low < high) {
            int pviot = partition(arr, low, high);
            qsort(arr, low, pviot - 1);
            qsort(arr, pviot + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pviot = arr[low];
        System.out.println("pviot :" + pviot);
        while (low < high) {
            while (low < high && arr[high] > pviot) high--;
            arr[low] = arr[high];
            while (low < high && arr[low] < pviot) low++;
            arr[high] = arr[low];
        }
        arr[low] = pviot;
//        System.out.println(low);
        return low;
    }

}
