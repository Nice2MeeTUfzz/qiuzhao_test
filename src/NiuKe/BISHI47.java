package NiuKe;

import java.util.*;

public class BISHI47 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            String c = sc.next();
            char[] s = c.toCharArray();
            int length = s.length;
            for (int i = 0; i < length; i++) {
                int max = s[i] - '0';
                int max_index = i;
                for (int j = i; j < Math.min(length, i+10); j++) {
                    int current_val = (s[j] - '0') - (j - i);
                    if (current_val > max) {
                        max = current_val;
                        max_index = j;
                    }
                }
                int temp_pos = max_index;
                while (temp_pos > i) {
                    char temp = s[temp_pos];
                    s[temp_pos] = s[temp_pos - 1];
                    s[temp_pos - 1] = temp;
                    temp_pos--;
                }
                s[i] = (char) (max + '0');
            }
            System.out.println(new String(s));
        }
    }
}
