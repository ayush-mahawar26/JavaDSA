package Arrays.Algorithm;

import java.util.*;

public class AddAndRemove {

    static int[] twoSum(int nums[], int target) {

        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int find = target - nums[i];
            if (mp.containsKey(find)) {
                return new int[] { i, mp.get(find) };
            } else {
                mp.put(nums[i], i);
            }
        }

        return new int[] { 0, 0 };
    }

    // Duplicate zeros
    static void rightShift(int[] a, int s) {
        int j = s + 1;
        for (int i = j; i < a.length; i++) {
            int temp = a[s];
            a[s] = a[i];
            a[i] = temp;
        }
    }

    static void duplicateZero(int arr[]) {
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] == 0) {
                rightShift(arr, i + 1);
                arr[i + 1] = 0;
                i += 1;
            }
            if (i == arr.length - 3) {
                if (arr[i + 1] == 0) {
                    arr[i + 2] = 0;
                    return;
                }
            }
        }

    }

    // Merge two Sorted Array
    static void merge(int a[], int b[], int m, int n) {
        int i = 0;
        int j = 0;
        int ind = 0;

        int[] res = new int[m + n];

        while (i <= m - 1 && j <= n - 1) {
            if (a[i] < b[j]) {
                res[ind] = a[i];
                i++;
            } else if (b[j] <= a[i]) {
                res[ind] = b[j];
                j++;
            }

            ind++;
        }

        while (i <= m - 1) {
            res[ind] = a[i];
            i++;
            ind++;
        }

        while (j <= n - 1) {
            res[ind] = b[j];
            j++;
            ind++;
        }

        for (int s = 0; s < m + n; s++) {
            a[s] = res[s];
        }
    }

    // removing element
    static int removingEle(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int i = 0;
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;

    }

    static boolean palindrome(int x) {
        if (x < 0) {
            return false;
        }

        int num = x;
        int ans = 0;
        while (num > 0) {
            int ld = num % 10;
            ans = (ans * 10) + ld;
            num = num / 10;
        }

        if (ans == x) {
            return true;
        }

        return false;
    }

    // Using - Two Pointer
    static void reverseArray(int a[]) {
        int m = a.length / 2;

        for (int i = 0; i < m; i++) {
            int temp = a[i];
            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = temp;
        }
    }

    static int[] sqOfSorted(int a[]) {
        int i = 0;
        int j = a.length - 1;
        int[] res = new int[a.length];
        int ind = 0;

        while (i <= j) {
            if (a[i] * a[i] > a[j] * a[j]) {
                res[ind] = a[i] * a[i];
                i++;
            } else {
                res[ind] = a[j] * a[j];
                j--;
            }

            ind++;
        }
        reverseArray(res);
        return res;
    }

    static int[] sortEvenOdd(int[] nums) {

        if (nums.length == 1 || nums.length == 2) {
            return nums;
        }
        int even[];
        if (nums.length % 2 != 0) {
            even = new int[nums.length / 2 + 1];
        } else {

            even = new int[nums.length / 2];
        }
        int[] odd = new int[nums.length / 2];

        int ei = 0;
        int oi = 0;

        for (int i = 0; i < nums.length; i += 2) {
            even[ei] = nums[i];
            ei++;

            if (i == nums.length - 1) {
                break;
            }

            odd[oi] = nums[i + 1];
            oi++;
        }

        Arrays.sort(even);
        Arrays.sort(odd);

        int trk = 0;
        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = even[trk];
            if (i == nums.length - 1) {
                break;
            }
            nums[i + 1] = odd[trk];

            trk++;

        }

        return nums;

    }

    static int maxOperation(int[] a, int k) {
        int count = 0;

        ArrayList<Integer> check = new ArrayList<>();

        for (int i : a) {
            int find = k - i;
            if (check.contains(find)) {
                count++;
                check.remove(new Integer(find));
            } else {
                check.add(i);
            }
        }

        return count;

    }

    public static void main(String[] args) {
        int[] a = { 2, 2, 2, 3, 1, 1, 4, 1 };
        // int[] b ,= {2,,5,,6} ;
        // // duplicateZero(a);
        // merge(a, b, 3, 3);
        // System.out.println(Arrays.toString(a));
        // System.out.println(removingEle(a));

        // System.out.println(Arrays.toString(sortEvenOdd(a)));
        // System.out.println(Arrays.toString(twoSum(a,17 )));

        // System.out.println(palindrome(141));
        System.out.println(maxOperation(a, 4));
    }
}
