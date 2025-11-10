package LeetCode;

import java.util.*;
public class 轮转数组189 {
    public static void main(String[] args) {
        轮转数组189 solution = new 轮转数组189();
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        solution.rotate(nums, 3);
    }

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] newNums = new int[len];
        for (int i = 0; i < len; i++) {
            newNums[(i + k) % len] = nums[i];
        }
        System.arraycopy(newNums, 0,nums, 0, len);
    }
}
