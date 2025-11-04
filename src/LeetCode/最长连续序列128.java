package LeetCode;

import java.util.*;
public class 最长连续序列128 {
    public static void main(String[] args) {
        最长连续序列128 solution = new 最长连续序列128();
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        int re = solution.longestConsecutive(nums);
        System.out.println(re);
    }
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longestStreak = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum+=1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}
