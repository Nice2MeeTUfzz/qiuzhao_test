package 宇信科技1004;

import java.util.*;

public class BISHI1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String str = sc.next();
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < str.length() - k + 1; ) {
            String cur = str.substring(i, i + k);
            if (result(cur)) {
                map.put(cur, map.getOrDefault(cur, 0) + 1);
                i += k;
            }
            else
                i++;
        }

        int result = 0;
        for (String key : map.keySet()) {
            result = Math.max(result, map.get(key));
        }
        System.out.println(result);
    }
    private static boolean result(String str) {
        for (int i =1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }
}
