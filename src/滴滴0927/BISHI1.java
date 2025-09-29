package 滴滴0927;

import java.util.*;

/**
 * 因为超时只a了30%，现在进行了修改，当一个数满足了k个进制为波浪数后跳出循环
 * 改了转换进制当中的错误，原代码在余数小于10时没有进行处理，产生错误
 * 判断波浪数没有考虑长度为1和为2
 */
public class BISHI1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();
        int k = sc.nextInt();
        for (int i = l; i <= r; i++) {
            int count = 0;
            for (int j = a; j <= b; j++) {
                String numToStr = swap(j, i);
                if (isBoLang(numToStr)) {
                    count++;
                    if (count >= k) {
                        break;
                    }
                }
            }
            if (count >= k) {
                System.out.println(i);
            }
        }
    }

    private static String swap(int jin, int num) {
//        char[] str16 = {'A', 'B', 'C', 'D', 'E', 'F'};
//        char[] str13 = {'A', 'B', 'C'};
//        StringBuilder sb = new StringBuilder();
//        int chu = num / jin;
//        while (chu != 0) {
//            int yu = num % jin;
//            if (jin == 16 && yu >= 10 && yu <= 15) {
//                sb.append(str16[yu % 10]);
//            } else if (jin == 13 && yu >= 10 && yu <= 12) {
//                sb.append(str13[yu % 10]);
//            } else {
//                sb.append(yu);
//            }
//            chu = num / jin;
//            num = chu;
//        }
//        sb.reverse();
//        return sb.toString();
        StringBuilder sb = new StringBuilder();
        int n = num;
        while (n > 0) {
            int remainder = n % jin;
            char digit;
            if (remainder < 10) {
                digit = (char) ('0' + remainder);
            }else {
                digit = (char) ('A' + (remainder - 10));
            }
            sb.append(digit);
            n = n / jin;
        }
        return sb.reverse().toString();
    }

    private static boolean isBoLang(String str) {
        int length = str.length();
        if (length == 1) {
            return true;
        }
        char ch1 = str.charAt(0);
        char ch2 = str.charAt(1);
        if (ch1 == ch2) {
            return false;
        }
        for (int i = 2; i < length; i++) {
            if (i % 2 == 0) {
                if (str.charAt(i) != ch1) {
                    return false;
                }
            } else {
                if (str.charAt(i) != ch2) {
                    return false;
                }
            }
        }
        return true;
    }
}
