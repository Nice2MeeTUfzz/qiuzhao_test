package 古茗;

public class 最大子数组和 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int maxRe = nums[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1] + nums[i]);
            if (dp[i] > maxRe) {
                maxRe = dp[i];
            }
        }
        return maxRe;
    }
}
