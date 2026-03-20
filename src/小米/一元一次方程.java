package 小米;

import java.util.Scanner;

// <https://codefun2000.com/p/P3888>
public class 一元一次方程 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        // 获取方程中未知数的值
        char variable = ' ';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                variable = c;
                break;
            }
        }
        // 从=号切割
        String[] dirs = s.split("=");
        String leftStr = dirs[0];
        String rightStr = dirs[1];
        double[] left = parseSide(leftStr, variable);
        double[] right = parseSide(rightStr, variable);
        double finalXs = left[0] - right[0];
        double finalCs = right[1] - left[1];
        double result = finalCs / finalXs;
        System.out.printf("%.3f", result);
    }

    /**
     * 解析单侧表达式
     * 返回数组: [未知数系数之和, 常数之和]
     * 2a-9
     * -a+4
     */
    private static double[] parseSide(String s, char varName) {
        double xsSum = 0.0;
        double csSum = 0.0;
        int i = 0;
        int n = s.length();
        while (i < n) {
            int sign = 1;
            char c = s.charAt(i);
            if (c == '-') {
                sign = -1;
                i++;
            } else if (c == '+') {
                i++;
            }
            // 取系数
            StringBuilder number = new StringBuilder();
            boolean isXs = false; // 判断是不是未知数系数
            while (i < n && Character.isDigit(s.charAt(i))) {
                number.append(s.charAt(i));
                i++;
            }
            if (i < n && s.charAt(i) == varName) {
                isXs = true;
                i++;
            }

            double val;
            if (number.isEmpty()) {
                val = 1.0;
            } else {
                val = Double.parseDouble(number.toString());
            }

            if (isXs) {
                xsSum += sign * val;
            } else {
                csSum += sign * val;
            }
        }
        return new double[]{xsSum, csSum};
    }

}
