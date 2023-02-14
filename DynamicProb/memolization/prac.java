package DynamicProb.memolization;

import java.util.Arrays;

public class prac {

    static int fibboMemo(int[] dp, int num) {
        if (num <= 1)
            return num;

        if (dp[num] != -1) {
            return dp[num];
        }

        return dp[num] = fibboMemo(dp, num - 1) + fibboMemo(dp, num - 2);
    }

    public static void main(String[] args) {
        int n = 4;
        int[] arr = new int[n + 1];
        Arrays.fill(arr, -1);

        System.out.println(fibboMemo(arr, n));
    }
}
