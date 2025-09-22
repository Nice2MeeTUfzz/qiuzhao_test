package 同盾科技0921;

import java.util.*;

/*
3,30,34,5,9
当前缀相同时，后一位为0的在前
把所有数拼接起来组成一个数，打印最小的一个
笔试A了90%
 */
public class BISHI2 {
    public static void main(String[] args) {
        //这个可以A 100%，使用一个自定义比较器
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(",");
        Arrays.sort(split, (a, b) -> (a + b).compareTo(b + a));
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("0")) {
                start++;
            }
        }
        for (int i = start; i < split.length; i++) {
            sb.append(split[i]);
        }
        System.out.println(sb.toString());
    }

    public static void bishi(Scanner sc) {
        String s = sc.nextLine();
        String[] split = s.split(",");
        Arrays.sort(split);
        for (int i = 0; i < split.length - 1; i++) {
            if (split[i].length() == 1 && split[i + 1].charAt(0) == split[i].charAt(0) && split[i + 1].length() == 2) {
                if (split[i + 1].charAt(0) < split[i + 1].charAt(1)) {
                    continue;
                } else {
                    String temp = split[i + 1];
                    split[i + 1] = split[i];
                    split[i] = temp;
                }
            } else if (split[i].length() == 1 && split[i + 1].length() == 3) {
                split[0] = "100";
                for (int j = i + 1; j > 1; j--) {
                    String temp = split[j + 1];
                    split[i + 1] = split[i];
                    split[i] = temp;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("0")) {
                start++;
            }
        }
        for (int i = start; i < split.length; i++) {
            sb.append(split[i]);
        }
        System.out.println(sb.toString());
    }
}
