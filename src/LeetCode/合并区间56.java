package LeetCode;

import java.util.*;
public class 合并区间56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][0];
        List<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for(int[] interval : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        合并区间56 solution = new 合并区间56();
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {7, 8}};
        solution.merge(intervals);
    }
}
