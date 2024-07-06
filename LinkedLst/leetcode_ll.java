package LinkedLst;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class leetcode_ll {

    static boolean isLocalMaxMin(ListNode head, ListNode prev) {

        if ((prev.val > head.val && head.next.val > head.val) || (prev.val < head.val && head.next.val < head.val))
            return true;

        return false;
    }

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode cn = head.next;
        ListNode prev = head;

        ArrayList<Integer> index = new ArrayList<>();
        int count = 1;
        while (cn.next != null) {

            if (isLocalMaxMin(cn, prev)) {
                index.add(count);
            }

            count++;
            cn = cn.next;
            prev = prev.next;
        }

        if (index.isEmpty())
            return new int[] { -1, -1 };
        if (index.size() == 1) {
            return new int[] { 1, 1 };
        }

        int max = index.get(index.size() - 1) - index.get(0);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < index.size() - 1; i++) {
            min = Math.min(min, index.get(i + 1) - index.get(i));
        }

        return new int[] { min, max };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListNode head = null;
        ListNode cn = head;

        int n = sc.nextInt();

        while (n-- != 0) {
            int val = sc.nextInt();
            if (head == null) {
                head = new ListNode(val);
                cn = head;
            } else {
                ListNode newNode = new ListNode(val);
                cn.next = newNode;
                cn = cn.next;
            }
        }

        int[] ans = nodesBetweenCriticalPoints(head);

        System.out.println(Arrays.toString(ans));

        sc.close();
    }

}
