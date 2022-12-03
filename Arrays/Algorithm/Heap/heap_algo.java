package Arrays.Algorithm.Heap;

import java.util.Arrays;

public class heap_algo {

    // static int[] deleteNode(int arr[]){
    // arr[1] = arr[arr.length-1] ;

    // }

    static void sortHeap(int heap[]) {
        int[] sorted = new int[heap.length];
        int ptr = 0;

        while (heap.length != 0) {
            sorted[ptr] = heap[0];

        }
    }

    static void heapify(int arr[], int n, int i) {
        int largest = i;
        int lc = 2 * i;
        int rc = (2 * i) + 1;

        if (lc < n && arr[lc] > arr[largest]) {
            largest = lc;
        }
        if (rc < n && arr[rc] > arr[largest]) {
            largest = rc;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    static void buildHeap(int arr[]) {
        int len = arr.length;

        for (int i = ((len / 2)); i > 0; i--) {
            heapify(arr, len, i);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 0, 1, 5, 4, 26, 9, 2, 30, 14, 41 };

        buildHeap(arr);
        System.out.println(Arrays.toString(arr));
    }
}
