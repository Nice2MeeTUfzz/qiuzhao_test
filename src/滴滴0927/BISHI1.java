package 滴滴0927;

import java.util.*;

/**
 *
 */
public class BISHI1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();
        int k = sc.nextInt();

//        int[] jinList = {2, 3, 4, 5, 6, 7, 8, 9, 10, 13, 16};
//        int left = 0;
//        int right = jinList.length - 1;
//        while (left <= right) {
//            if (a >= jinList[left]) {
//                left++;
//            } else if (b <= jinList[right]) {
//                right--;
//            }
//        }

        for (int i = l; i <= r; i++) {
            int count = 0;

            for (int j = a; j <= b; j++) {
                String numToStr = swap(j, i);
                if (isBoLang(numToStr)) {
                    count++;
                }
                if (count == k) {
                    System.out.println(i);
                    break;
                }
            }
//            for (int j = left; j <= right; j++) {
//                String numToStr = swap(jinList[j], i);
//                if (isBoLang(numToStr)) {
//                    count++;
//                }
//                if (count == k) {
//                    System.out.println(i);
//                    break;
//                }
//            }
        }
    }

    private static String swap(int jin, int num) {
        char[] str16 = {'A', 'B', 'C', 'D', 'E', 'F'};
        char[] str13 = {'A', 'B', 'C'};
        StringBuilder sb = new StringBuilder();
        int chu = num / jin;
        while (chu != 0) {
            int yu = num % jin;
            if (jin == 16 && yu >= 10 && yu <= 15) {
                sb.append(str16[yu % 10]);
            } else if (jin == 13 && yu >= 10 && yu <= 12) {
                sb.append(str13[yu % 10]);
            } else {
                sb.append(yu);
            }
            chu = num / jin;
            num = chu;
        }
        sb.reverse();
        return sb.toString();
    }

    private static boolean isBoLang(String str) {
        char ch1 = str.charAt(0);
        char ch2 = str.charAt(1);
        for (int i = 2; i < str.length(); i++) {
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
