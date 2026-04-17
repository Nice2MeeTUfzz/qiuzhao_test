package 古茗;

import java.util.Arrays;

public class 字符串全排列 {
    public void nextPermutation(int[] nums) {
        if (nums.length == 0) {
            return;
        }

        int n = nums.length;

        // 从后向前遍历，找出第一个递增序列
        int j = n - 1;
        int i = n - 2;
        while (i >= 0 && j >= 0) {
            if (nums[i] < nums[j]) {
                break;
            } else {
                i--;
                j--;
            }
        }
        if (i >= 0) {
            int k = n - 1;
            // 从i+1到end找第一个比nums[i]大的数
            for (; k > i; k--) {
                if (nums[k] > nums[i]) {
                    break;
                }
            }

            int temp = nums[i];
            nums[i] = nums[k];
            nums[k] = temp;
        }


        // 将i+1及以后的数按照递增排列,这个序列为降序，将其转为升序
        i++;
        for (int l = n - 1; i < l; i++, l--) {
            int tmp = nums[i];
            nums[i] = nums[l];
            nums[l] = tmp;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(Arrays.toString(nums));
        sb.append("]");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        字符串全排列 a = new 字符串全排列();
        a.nextPermutation(new int[]{1, 2, 3, 4, 6, 5});
    }
}
