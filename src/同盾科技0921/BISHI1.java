package 同盾科技0921;

/*
最长公共前缀
["aaa","aab","aac"]
"aa"
 */

import java.util.*;

public class BISHI1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.substring(1, str.length() - 1);
        String[] charStr = str.split(",");
        for (int i = 0; i < charStr.length; i++) {
            charStr[i] = charStr[i].substring(1, charStr[i].length() - 1);
        }

        int n = charStr.length;
        int preCount = 0;
        while (n-- > 0) {
            int count = 0;
            int ch = charStr[n].charAt(preCount);
            for (String str1 : charStr) {
                if (str1.charAt(preCount) == ch) {
                    count++;
                } else {
                    break;
                }
            }
            if (count == charStr.length) {
                preCount++;
            }
        }
        System.out.println(charStr[0].substring(0,preCount));
    }
}
