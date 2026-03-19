package 极兔速递;

import java.util.Scanner;

public class 下划线命名 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        StringBuilder sb = new StringBuilder();
        String s = "abcdefg";
        for(int i = 0;i<n;i++){
            if (i == 1) {
                sb.append('_');
            } else {
                sb.append(s.charAt(i % s.length()));
            }
        }
        System.out.println(sb);
    }
}
