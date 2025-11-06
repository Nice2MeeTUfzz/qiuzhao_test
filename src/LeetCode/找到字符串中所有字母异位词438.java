package LeetCode;

import java.util.*;

public class 找到字符串中所有字母异位词438 {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        if (sLen < pLen) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int[] window = new int[26];
        int[] need = new int[26];

        for (int i =0;i<pLen;i++) {
            need[p.charAt(i) - 'a']++;
            window[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(need,window)) {
            res.add(0);
        }

        for (int i = pLen; i < sLen; i++) {
            window[s.charAt(i)-'a']++;
            window[s.charAt(i - pLen) - 'a']--;
            if (Arrays.equals(need,window)) {
                res.add(i - pLen + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        找到字符串中所有字母异位词438 solution = new 找到字符串中所有字母异位词438();
        System.out.println(solution.findAnagrams(s, p));
    }
}
