package NiuKe;

import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Deque;

public class BISHI2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String command = in.next();
            if (command.equals("push")) {
                stack.push(in.nextInt());
            } else if (command.equals("pop")) {
                if (stack.isEmpty()) {
                    System.out.print("Empty");
                } else {
                    stack.pop();
                }
            } else if (command.equals("query")) {
                if (stack.isEmpty()) {
                    System.out.print("Empty");
                } else {
                    System.out.println(stack.peek());
                }
            } else if (command.equals("size")) {
                System.out.println(stack.size());
            }
        }
    }
}
