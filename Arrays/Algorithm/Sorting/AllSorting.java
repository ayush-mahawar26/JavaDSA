package Arrays.Algorithm.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IllegalFormatWidthException;

import javafx.scene.shape.QuadCurveBuilder;

public class AllSorting {

    static int[] bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }

    static int[] selectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int min = Integer.MAX_VALUE;
            int pos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    pos = j;
                }
            }

            if (arr[i] > arr[pos]) {
                int temp = arr[i];
                arr[i] = arr[pos];
                arr[pos] = temp;
            }
        }
        return arr;
    }

    static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }

        return arr;
    }

    // Merge Sort

    static int[] mergeArr(int[] l, int[] r) {
        int[] ansArr = new int[l.length + r.length];
        int ptr = 0;
        int lptr = 0;
        int rptr = 0;

        while (lptr != l.length && rptr != r.length) {
            if (l[lptr] > r[rptr]) {
                ansArr[ptr] = r[rptr];
                ptr++;
                rptr++;
            }

            else if (l[lptr] < r[rptr]) {
                ansArr[ptr] = l[lptr];
                ptr++;
                lptr++;
            }

            else {
                ansArr[ptr] = l[lptr];
                lptr++;
                ptr++;
                ansArr[ptr] = r[rptr];
                rptr++;
                ptr++;
            }
        }

        if (lptr == l.length) {
            for (int i = rptr; i < r.length; i++) {
                ansArr[ptr] = r[i];
                ptr++;
            }
        }

        if (rptr == r.length) {
            for (int i = lptr; i < l.length; i++) {
                ansArr[ptr] = l[i];
                ptr++;
            }
        }

        return ansArr;
    }

    static int[] mergeSort(int arr[]) {
        if (arr.length == 1)
            return arr;
        int size = arr.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, size));
        int[] right = mergeSort(Arrays.copyOfRange(arr, size, arr.length));

        return mergeArr(left, right);
    }

    // Quick Sort
    static void quickSort(int[] arr, int s, int e) {
        if (s >= e || s < 0 || e > arr.length) {
            return;
        }

        int lw = s;
        int hi = e;
        int md = (s + e) / 2;
        int pivot = arr[md];

        while (lw <= hi) {
            while (arr[lw] < pivot)
                lw++;
            while (arr[hi] > pivot)
                hi--;

            if (lw <= hi) {
                int temp = arr[lw];
                arr[lw] = arr[hi];
                arr[hi] = temp;
                lw++;
                hi--;
            }
        }

        quickSort(arr, s, hi);
        quickSort(arr, lw, e);

    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, 5, 1, 7 };
        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }
}
