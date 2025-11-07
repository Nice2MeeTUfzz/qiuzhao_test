package LeetCode;

public class 最大子数组和53 {
    public int maxSubArray(int[] nums) {
        int pre = 0, max = nums[0];
        for (int x : nums) {
            pre = Math.max(x, pre + x);
            max = Math.max(max, pre);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        最大子数组和53 solution = new 最大子数组和53();
        System.out.println(solution.maxSubArray(nums));
    }
}
