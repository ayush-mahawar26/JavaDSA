import java.util.*;

public class ques {
    static int minimum(int[] arr) {
        Map<Integer, Integer> ans = new HashMap<>();

        for (int i : arr) {
            ans.put(i, ans.getOrDefault(i, 0) + 1);
        }
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> i : ans.entrySet()) {
            min = Math.min(i.getValue(), min);
        }

        return min;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = { 2, 3, 1, 2, 2, 2, 3, 2, 2, 3, 1 };

        System.out.println(minimum(arr));

        sc.close();

    }
}
