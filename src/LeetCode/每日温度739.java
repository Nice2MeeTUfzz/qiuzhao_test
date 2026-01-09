package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class 每日温度739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] ans = new int[len];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            if (!deque.isEmpty() && temperatures[i] > temperatures[deque.peek()]) {
                int tarIndex = deque.pop();
                ans[tarIndex] = i - tarIndex;
            }
            deque.push(i);
        }
        return ans;
    }
}
