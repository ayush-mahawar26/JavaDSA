import java.util.*;

class Task implements Comparable<Task> {
    int occ;
    int etime;

    Task(int occ, int etime) {
        this.occ = occ;
        this.etime = etime;
    }

    @Override
    public int compareTo(Task that) {
        return that.occ - this.occ;
    }

}

public class leetcode {

    // interval
    public static boolean isOverlapping(int[] interval, int[] newInterval) {
        if (interval[1] >= newInterval[0] && interval[0] <= newInterval[1])
            return true;
        else if ((interval[0] <= newInterval[0] && interval[1] >= newInterval[1])
                || (interval[0] >= newInterval[0] && interval[1] <= newInterval[1]))
            return true;

        return false;
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0)
            return new int[][] { newInterval };
        ArrayList<int[]> ansArr = new ArrayList<>();
        int ci = 0;

        boolean done = false;
        for (int[] interval : intervals) {

            // for current interval less than new interval
            if (interval[1] < newInterval[0]) {
                ansArr.add(interval);
            }

            // for whole inside
            else if (isOverlapping(interval, newInterval)) {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                if (done) {
                    ansArr.add(interval);
                    continue;
                }
                ansArr.add(newInterval);
                ansArr.add(interval);
                done = true;

            }
        }

        if (!done) {
            ansArr.add(newInterval);
        }
        int[][] ans = new int[ansArr.size()][2];

        for (int[] i : ansArr) {
            ans[ci++] = i;
        }

        for (int[] i : ans) {
            System.out.println(Arrays.toString(i));
        }

        return ans;
    }

    // frquency of element
    public static int frquence(int[] nums) {

        int[] occ = new int[101];
        Arrays.fill(occ, 0);

        for (int i : nums) {
            occ[i] += 1;
        }

        Arrays.sort(occ);
        int ans = occ[100];

        // System.out.println(Arrays.toString(occ));
        for (int i = 99; i >= 0; i--) {
            if (occ[i] == occ[i + 1]) {
                ans += occ[i];
            } else {
                break;
            }
        }

        System.out.println(ans);

        return ans;

    }

    public static String gopro(String yesss) {
        System.out.println(yesss);
        return "yesss";
    }

    // compress the string
    public static int compressString(char[] chars) {
        if (chars.length == 1)
            return 1;
        String str = "" + chars[0];
        int count = 1;
        int pt = 1;

        while (pt < chars.length) {
            char prev = chars[pt - 1];
            if (chars[pt] == prev) {
                count++;
            } else {
                if (count > 1) {
                    str += Integer.toString(count);
                    count = 1;
                }
                str += chars[pt];
            }

            pt++;
        }

        if (count > 1) {
            str += Integer.toString(count);
        }
        System.out.println(str);

        return str.length();

    }

    // reverse word
    public static String reverseWord(String str) {
        String nstr = "";
        str = str.trim();
        str = " " + str;

        int pt = str.length() - 1;
        int lpt = str.length();

        while (pt >= 0) {
            char ch = str.charAt(pt);
            if (ch != ' ') {
                pt--;
            } else {
                if (str.charAt(pt + 1) == ' ') {
                    pt--;
                    lpt--;
                } else {
                    nstr += str.substring(pt + 1, lpt).trim() + " ";
                    lpt = pt;
                    pt--;
                }
            }
        }

        return nstr.trim();
    }

    public static String stringSort(String order, String s) {

        String ans = "";

        int l1 = order.length();
        int l2 = s.length();

        int[][] track = new int[1][l1];
        Arrays.fill(track[0], 0);

        String common = "";

        for (int i = 0; i < l2; i++) {
            char ch = s.charAt(i);
            if (order.indexOf(ch) >= 0) {
                int ind = order.indexOf(ch);
                track[0][ind] += 1;
                common += ch;
            }
        }

        System.out.println(Arrays.toString(track[0]));

        for (int i = 0; i < order.length(); i++) {
            int occ = track[0][i];
            char ch = order.charAt(i);

            for (int j = 0; j < occ; j++) {
                ans += ch;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (common.contains(ch + "") == false) {
                ans += ch;
            }
        }
        System.out.println(ans);

        return ans;
    }

    public static int pivotInteger(int n) {
        int tsum = (n * (n + 1)) / 2;
        int bsum = 0;

        int x = n;

        while (x > 0) {
            if (tsum == bsum)
                return x;
            tsum -= x;
            bsum += x;

            if (Math.abs(tsum - bsum) == x) {
                return x;
            }

            x -= 1;
        }

        return -1;
    }

    static int minTime(char[] tasks, int n) {
        HashMap<Character, Integer> hm = new HashMap<>();

        for (char ch : tasks) {
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Task> pq = new PriorityQueue<>();

        for (Map.Entry<Character, Integer> ele : hm.entrySet()) {
            pq.offer(new Task(ele.getKey(), 0));
        }

        Queue<Task> queue = new LinkedList<>();
        int time = 0;

        while (!queue.isEmpty() || !pq.isEmpty()) {
            time++;
            if (!pq.isEmpty()) {
                Task topTask = pq.poll();
                topTask.occ--;
                if (topTask.occ > 0) {
                    topTask.etime = time + n;
                    queue.add(topTask);
                }
            }

            if (!queue.isEmpty() && queue.peek().etime == time) {
                pq.offer(queue.poll());
            }
        }

        return time;
    }

    static int firstMissingPositive(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (arr[i] <= 0)
                arr[i] = len + 1;
        }

        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < len; i++) {
            if (Math.abs(arr[i]) <= len && arr[Math.abs(arr[i]) - 1] >= 0) {
                arr[Math.abs(arr[i]) - 1] = -arr[Math.abs(arr[i]) - 1];
            }
        }

        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < len; i++) {
            if (arr[i] > 0)
                return i + 1;
        }
        return len + 1;
    }

    static int maxSubarray(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int ans = 0;

        HashMap<Integer, Integer> mp = new HashMap<>();

        while (j < nums.length) {

            int ele = nums[j];
            mp.put(ele, mp.getOrDefault(ele, 0) + 1);

            while (mp.get(ele) > k && i < j) {
                int fele = nums[i];
                mp.put(fele, mp.get(fele) - 1);
                i++;
            }

            ans = Math.max(ans, j - i + 1);
            j++;
        }

        return ans;
    }

    static int countSubaarray(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int count = 0;
        Map<Integer, Integer> mp = new HashMap<>();

        while (j < nums.length) {
            mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);
            while (mp.size() > k && i <= j) {
                mp.put(nums[i], mp.get(nums[i]) - 1);
                if (mp.get(nums[i]) == 0)
                    mp.remove(nums[i]);
                i++;
            }
            count += j - i + 1;
            j++;
        }

        return count;
    }

    static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> hm = new HashMap<>();

        if (s.length() != t.length())
            return false;

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (!hm.containsKey(c1) && !hm.containsKey(c2)) {
                hm.put(c1, c2);
            } else {
                if (hm.containsKey(c1)) {
                    char val = hm.get(c1);
                    if (Character.valueOf(val).compareTo(Character.valueOf(c2)) != 0)
                        return false;
                } else if (hm.containsKey(c2)) {
                    char val = hm.get(c2);
                    if (Character.valueOf(val).compareTo(Character.valueOf(c1)) != 0)
                        return false;
                }
            }
        }
        System.out.println(hm);
        return true;

    }

    static int max(int[] nums) {
        int mx = -1;
        for (int i : nums) {
            mx = Math.max(mx, Math.abs(i));
        }

        return mx;
    }

    static int findMaxk(int[] nums) {
        int mx = max(nums);
        int[] pos = new int[mx + 1];
        int[] neg = new int[mx + 1];

        for (int i : nums) {
            if (i > 0) {
                pos[i] = 1;
            } else {
                neg[-1 * i] = 1;
            }
        }
        System.out.println(Arrays.toString(pos));
        System.out.println(Arrays.toString(neg));
        for (int i = pos.length - 1; i >= 0; i--) {
            if (pos[i] == 1 && neg[i] == 1)
                return i;
        }

        return -1;
    }

    static String myAtoi(String s, int si, int ei) {
        if (s.charAt(ei) == ' ' && si == ei) {
            return myAtoi(s, si + 1, ei + 1);
        } else if ((s.charAt(ei) == '-' && si == ei) || (s.charAt(ei) >= '0' && s.charAt(ei) <= '9')) {
            return myAtoi(s, si, ei + 1);
        }

        return s.substring(si, ei);
    }

    static double pow(double x, int n) {
        if (n == -1)
            return 1 / x;
        if (n == 1)
            return x;

        if (n < 0) {
            return (1 / x) * pow(x, n + 1);
        } else {
            return x * pow(x, n - 1);

        }

    }

    static int[] singleNumber(int[] nums) {
        int[] ans = new int[2];
        int i = 0;

        Arrays.sort(nums);

        int ind = 0;
        while (ind <= nums.length - 1) {
            if (ind == nums.length - 1) {
                ans[i] = nums[ind];
            }

            int n1 = nums[ind];
            int n2 = nums[ind + 1];
            if (n1 != n2) {
                ans[i] = n1;
                ind++;
                i++;
            } else {
                ind += 2;
            }

        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }

    static int check(int a, int b) {
        return (a * a) + (b * b);
    }

    static boolean sqr(int c) {
        int a = 0;
        int b = c - 1;

        while (a < b) {
            int mid = (int) Math.floor(((double) b - (double) (b - a) / 2));
            if (check(a, b) == c)
                return true;
            else if (check(a, b) > c)
                b = mid;
            else
                a = mid;
        }

        return false;
    }

    static List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ans.add(new ArrayList<>());
        }

        // reverse

        for (int[] i : edges) {
            int temp = i[0];
            i[0] = i[1];
            i[1] = temp;
        }

        for (int i[] : edges)
            System.out.println(Arrays.toString(i));

        for (int i = 0; i < edges.length; i++) {
            int key = edges[i][0];
            int val = edges[i][1];

            if (ans.get(key).contains(val) == false)
                ans.get(key).add(val);
            for (int j = 0; j < edges.length; j++) {
                if (edges[j][0] == val) {
                    if (ans.get(key).contains(edges[j][1]) == false) {
                        ans.get(key).add(edges[j][1]);
                    }
                }
            }
        }

        for (List<Integer> i : ans) {
            Collections.sort(i);
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[][] edges = { { 0, 3 }, { 5, 0 }, { 2, 3 }, { 4, 3 }, { 5, 3 }, { 1, 3 }, { 2, 5 }, { 0, 1 }, { 4, 5 },
                { 4, 2 }, { 4, 0 }, { 2, 1 }, { 5, 1 } };

        System.out.println(getAncestors(8, edges));
        sc.close();

    }
}
