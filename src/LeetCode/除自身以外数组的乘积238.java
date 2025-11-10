package LeetCode;

import java.util.*;

public class 除自身以外数组的乘积238 {
    public static void main(String[] args) {
        除自身以外数组的乘积238 solution = new 除自身以外数组的乘积238();
        int[] nums = new int[]{1, 2, 3, 4};
        solution.productExceptSelf(nums);
    }

    public int[] productExceptSelf(int[] nums) {

        int len = nums.length + 1;
        int[] L = new int[len];
        int[] R = new int[len];

        L[0] = 1;
        R[len - 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            L[i + 1] = L[i] * nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            R[i] = R[i+1] * nums[i];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = L[i] * R[i + 1];
        }
        return res;
    }
}
