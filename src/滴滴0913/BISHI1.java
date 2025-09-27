package 滴滴0913;

import java.util.*;

/**
 * <a href="https://codefun2000.com/p/P3662">...</a>
 */

public class BISHI1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int m = sc.nextInt();
        HashMap<Character, Set<Character>> map = new HashMap<>();
        sc.nextLine();
        String s = sc.nextLine();
        for (int i = 0; i < m; i++) {
            String str = sc.nextLine().trim();
            char ch1 = str.charAt(0);
            char ch2 = str.charAt(2);
            map.computeIfAbsent(ch1, k -> new HashSet<>()).add(ch2);
            map.computeIfAbsent(ch2, k -> new HashSet<>()).add(ch1);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            Set<Character> currentChars = new HashSet<>();
            for (int j = i; j < n; j++) {
                char newChar = s.charAt(j);
                boolean hasConflict = false;
                for (char ch : currentChars) {
                    if (map.getOrDefault(ch, new HashSet<>()).contains(newChar)) {
                        hasConflict = true;
                        break;
                    }
                }
                if (hasConflict) {
                    break;
                }
                currentChars.add(newChar);
                count++;
            }
        }
        System.out.println(count);
    }
}
