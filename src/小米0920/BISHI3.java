package 小米0920;

import java.util.*;

public class BISHI3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        int current = 1;
        int goC1 = 0;
        int index = 0;
        while (index < n) {
            int x = list[index];
            while (current < x) {
                stack.push(current);
                current++;
            }
            if (current == x) {
                goC1++;
                current++;
                index++;
            }else {
                if (stack.isEmpty() || stack.peek() != x) {
                    System.out.println(-1);
                }
                stack.pop();
                index++;
            }
        }
        if (!stack.isEmpty()) {
            System.out.println(-1);
        }else {
            System.out.println(goC1);
        }
    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] list = new int[n];
//        for (int i = 0; i < n; i++) {
//            list[i] = sc.nextInt();
//        }
//        int index = 0;
//        int goC1 = 0;
//        Stack<Integer> stack = new Stack<>();
//        int d = 2;
//        stack.push(1);
//        while (index < n) {
//            int pop = stack.peek();
//            if (list[index] == pop) {
//                stack.pop();
//                index++;
//                goC1++;
//            }
//            stack.push(d);
//            d++;
//        }
//        while (!stack.isEmpty()) {
//            int pop = stack.peek();
//            if (list[index] == pop) {
//                stack.pop();
//                index++;
//                goC1++;
//            }
//        }
//        System.out.println(goC1);
//    }
}
