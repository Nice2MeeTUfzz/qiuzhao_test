package 小红书824;

import java.util.*;
public class BISHI3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();

        //统计每个字符出现的次数
        int[] count = new int[26];
        for (char c: s.toCharArray()) {
            count[c - 'a']++;
        }
        //记录每个字符使用的次数
        int[] used = new int[26];
        StringBuilder stack = new StringBuilder();
        for (char c: s.toCharArray()) {
            int idx = c - 'a';
            // 如果当前字符已用完，跳过
            if (used[idx] >= count[idx]) {
                continue;
            }
            while (stack.length() > 0) {
                char top = stack.charAt(stack.length() - 1);
                int topidx = top - 'a';
                if (top>c && used[topidx]< count[topidx]) {
                    boolean canPop = true;
                    if (topidx < 25) {
                        if (used[topidx] - 1 > used[topidx + 1]) {
                            canPop = false;
                        }
                    }
                    if (canPop) {
                        stack.deleteCharAt(stack.length() - 1);
                        used[topidx]--;
                    }else {
                        break;
                    }
                }else {
                    break;
                }
            }
            stack.append(c);
            used[idx]++;

            if (idx < 25) {
                while (used[idx] > used[idx + 1]) {
                    stack.deleteCharAt(stack.length() - 1);
                    used[idx]--;
                }
            }
        }
        System.out.println(stack.toString());
    }
}
