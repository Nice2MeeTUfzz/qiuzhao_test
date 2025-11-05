package LeetCode;

import java.util.HashMap;
import java.util.HashSet;

public class 无重复字符的最长字串 {
    public static void main(String[] args) {
        无重复字符的最长字串 solution = new 无重复字符的最长字串();
        String s = "abcabcbb";
        int i = solution.lengthOfLongestSubstring(s);
        System.out.println(i);
    }
    public int lengthOfLongestSubstring(String s) {
        char[] ss = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        int res = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            char ch = ss[right];
            while(set.contains(ch)) {
                set.remove(ss[left]);
                left++;
            }
            set.add(ss[right]);
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
