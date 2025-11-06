package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class 和为K的子数组560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int curSum = 0;
        int count = 0;

        for (int num: nums) {
            curSum += num;
            if (map.containsKey(curSum - k)) {
                count += map.get(curSum - k);
            }
            map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        和为K的子数组560 solution = new 和为K的子数组560();
        System.out.println(solution.subarraySum(nums, k));
    }
}
