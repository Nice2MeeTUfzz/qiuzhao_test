package LeetCode;

import java.util.Arrays;

public class 数组中的第K个最大元素215 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
