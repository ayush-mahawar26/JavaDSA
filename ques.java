import java.util.*;

public class ques {

    static boolean isPrime(int num) {
        boolean flag = false;
        for (int i = 2; i <= num / 2; ++i) {
            if (num % i == 0) {
                flag = true;
                break;
            }
        }

        if (!flag)
            return true;
        return false;
    }

    static boolean isArraySorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= arr[i - 1])
                return false;
        }

        return true;
    }

    static boolean isPossible(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int ele = arr[i];
            for (int j = ele; j > 0; j--) {
                if (isPrime(j)) {
                    if (i == 0) {
                        ele -= j;
                        arr[i] = ele;
                        break;
                    } else {
                        if (ele - j > arr[i - 1]) {
                            ele -= j;
                            arr[i] = ele;
                            break;
                        }
                    }

                }
            }
        }

        return isArraySorted(arr);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = { 10, 9, 13, 9 };
        System.out.println(isPossible(arr));

        sc.close();

    }
}
