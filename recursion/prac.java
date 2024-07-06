package recursion;

import java.util.*;

public class prac {

    static void wordBreak(String str, String temp, List<String> ans, int ind, List<String> dic) {
        if (ind >= str.length()) {
            ans.add(temp);
            return;
        }

        for (int i = ind; i < str.length(); i++) {

            temp += str.charAt(i);
            wordBreak(str, temp, ans, i + 1, dic);
        }

    }

    static List<String> wbstart(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();

        wordBreak(s, "", ans, 0, wordDict);

        return ans;
    }

    public static void main(String[] args) {

    }
}
