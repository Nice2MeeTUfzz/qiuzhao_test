package 小米0920;

import java.util.*;
public class BISHI1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        for (char c: str.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c: stack) {
            sb.append(c);
        }
        System.out.println(sb);
    }
}
