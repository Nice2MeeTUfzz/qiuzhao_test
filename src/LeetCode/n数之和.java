package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class n数之和 {
    public List<List<Integer>> nSum(int[] nums, int n, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 2) {
            int left = start, right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    res.add(new ArrayList<>(Arrays.asList(nums[left], nums[right])));
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    left++;
                    right--;
                }
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                List<List<Integer>> tmp = nSum(nums, n - 1, i + 1, target - nums[i]);
                for (List s : tmp) {
                    s.add(nums[i]);
                    res.add(s);
                }
                while (i<nums.length-1 && nums[i]==nums[i+1]) i++;
            }
        }
        return res;
    }
}
