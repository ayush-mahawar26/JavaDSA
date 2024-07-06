package Arrays.Algorithm.Sorting;

import java.util.Arrays;

public class MergeSort {

    // Recursive Probelem
    // return type Array

    static int[] mergeArray(int[] l, int[] r) {
        int lp = 0;
        int rp = 0;
        int currentPlace = 0;
        int[] finalArr = new int[l.length + r.length];

        while (lp <= (l.length - 1) && rp <= r.length - 1) {
            if (l[lp] < r[rp]) {
                finalArr[currentPlace] = l[lp];
                lp++;
            } else {
                finalArr[currentPlace] = r[rp];
                rp++;
            }
            currentPlace++;
        }

        while (lp < l.length) {
            finalArr[currentPlace] = l[lp];
            lp++;
            currentPlace++;
        }

        while (rp < r.length) {
            finalArr[currentPlace] = r[rp];
            rp++;
            currentPlace++;
        }

        return finalArr;
    }

    public static int[] sortMerge(int a[]) {
        if (a.length == 1) {
            return a;
        }

        int mid = a.length / 2;

        int[] left = sortMerge(Arrays.copyOfRange(a, 0, mid));
        int[] right = sortMerge(Arrays.copyOfRange(a, mid, a.length));

        return mergeArray(left, right);

    }

    public static void main(String[] args) {
        int[] a = { 1, 5, -2, 4, 8, 9, 6 };

        System.out.println(Arrays.toString(sortMerge(a)));

    }

}
