package recursion;

import java.util.*;

public class subsequences {

    static void printAllSubsequence(int[] arr, List<Integer> subs, int ind, List<List<Integer>> ans) {
        if (ind > arr.length - 1) {
            System.out.println(subs);
            return;
        }

        subs.add(arr[ind]);
        printAllSubsequence(arr, subs, ind + 1, ans);
        subs.remove(subs.size() - 1);
        printAllSubsequence(arr, subs, ind + 1, ans);

    }

    static void binarySubsequence(String str, int len, ArrayList<String> lstr) {
        if (len <= 0) {
            lstr.add(str);
            // System.out.println(str);
            return;
        }

        // nottake
        binarySubsequence(str + "0", len - 1, lstr);
        // take
        if (str.length() == 0 || str.charAt(str.length() - 1) != '1') {
            binarySubsequence(str + "1", len - 1, lstr);
        }

    }

    static void generateParanthesis(int open, int close, String str, int n, ArrayList<String> ans) {

        if (open == n && close == n) {
            ans.add(str);
            return;
        }

        if (open < n) {
            // open brancket
            generateParanthesis(open + 1, close, str + "(", n, ans);
        }

        if (close < open) {
            generateParanthesis(open, close + 1, str + ")", n, ans);
        }

    }

    static void distinctString(String str, Set<List<Character>> ans, int ind, List<Character> temp) {

        if (ind >= str.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        // take it
        temp.add(str.charAt(ind));
        distinctString(str, ans, ind + 1, temp);
        // nottake

        if (temp.size() != 0)
            temp.remove(temp.size() - 1);

        distinctString(str, ans, ind + 1, temp);

    }

    static void distinctStringByString(String str, Set<String> ans, int ind, String temp) {

        if (ind >= str.length()) {
            if (!temp.isEmpty())
                ans.add(temp);
            return;
        }

        // take it
        temp += str.charAt(ind);
        distinctStringByString(str, ans, ind + 1, temp);
        // nottake

        if (temp.length() != 0)
            temp = temp.substring(0, temp.length() - 1);

        distinctStringByString(str, ans, ind + 1, temp);

    }

    static void subArraySumWithK(int[] a, int ind, long k, long sum, List<Integer> temp, List<List<Integer>> ans) {

        if (ind >= a.length) {
            Collections.sort(temp);

            if (sum == k) {
                ans.add(new ArrayList<>(temp));
            }

            return;
        }

        if (sum == k) {
            Collections.sort(temp);
            if (!ans.contains(temp)) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        // take it
        temp.add(a[ind]);
        subArraySumWithK(a, ind + 1, k, sum + a[ind], temp, ans);
        if (temp.size() != 0)
            temp.remove(temp.size() - 1);
        subArraySumWithK(a, ind + 1, k, sum, temp, ans);

    }

    static void getSum(List<List<Integer>> ans, int[] arr, List<Integer> temp, int ind, int target) {

        if (ind == arr.length) {
            if (target == 0) {
                // Collections.sort(temp);
                if (!ans.contains(temp))
                    ans.add(new ArrayList<>(temp));
            }
            return;
        }

        if (arr[ind] <= target) {
            // take it
            temp.add(arr[ind]);
            getSum(ans, arr, temp, ind + 1, target - arr[ind]);
            if (temp.size() > 0)
                temp.remove(temp.size() - 1);
        }

        getSum(ans, arr, temp, ind + 1, target);

    }

    static void subs(int[] arr, int ind, ArrayList<Integer> ans, int sum) {

        if (ind >= arr.length) {
            if (!ans.contains(sum)) {
                ans.add(sum);
            }
            return;
        }

        // take it
        subs(arr, ind + 1, ans, sum + arr[ind]);
        // nottake
        subs(arr, ind + 1, ans, sum);

    }

    static void subset2(int[] arr, int ind, ArrayList<Integer> ds, ArrayList<ArrayList<Integer>> ans) {
        if (ind >= arr.length) {
            if (ans.contains(ds) == false)
                ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i < arr.length; i++) {
            ds.add(arr[i]);
            subset2(arr, i + 1, ds, ans);
            ds.remove(ds.size() - 1);
        }

        subset2(arr, ind + 1, ds, ans);

    }

    static void comb(int n, int sum, int k, List<Integer> temp, List<List<Integer>> ans) {
        if (k == 0) {
            if (sum == 0) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        if (n > 9)
            return;

        // take
        temp.add(n);
        comb(n + 1, sum - n, k - 1, temp, ans);

        System.out.println(temp);
        if (temp.isEmpty() == false)
            temp.remove(temp.size() - 1);

        comb(n + 1, sum, k, temp, ans);

    }

    public static void main(String[] args) {

        List<List<Integer>> ans = new ArrayList<>();

        comb(1, 45, 9, new ArrayList<>(), ans);

        System.out.println(ans);

    }

}
