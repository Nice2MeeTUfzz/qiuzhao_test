import java.util.Scanner;

// 8位LED控制器
public class 华为od {
    public static void main(String[] args) {
        int led = 0;
        Scanner sc = new Scanner(System.in);
        String o = sc.nextLine();
        o = o.substring(1,o.length()-1);
        char[] chars = o.toCharArray();
        for (int i = 0; i < chars.length; i = i + 2) {
            char op = chars[i];
            int bitIndex = chars[i + 1] - '0';
            if (op == 'L') {
                led = (led | (1 << bitIndex));
            } else if (op == 'D') {
                led = (led & ~(1 << bitIndex));
            } else if (op == 'T') {
                led ^= (1 << bitIndex);
            }
        }
        System.out.println(led);
    }
}
