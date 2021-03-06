package sort;

import java.util.Arrays;

/**
 * Created by chenteng on 2018/2/26.
 */

public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {1, 3, 6, 4, 21, 7, 9, 8};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {

        //构建大堆顶
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustBigHeap(arr, i, arr.length);
        }

        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, 0, j);
            adjustBigHeap(arr, 0, j);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void adjustBigHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1])
                k = k + 1;
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }

}
