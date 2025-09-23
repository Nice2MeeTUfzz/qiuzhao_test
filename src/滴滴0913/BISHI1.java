package 滴滴0913;
/*
题目内容
小钟有一个长度为n的全部由大写英文字母组成的字符用s。然而，这26个英文字母之间并不总是和谐相处的，
有 m 对字母之间存在矛盾，分别表示为(ch1,1,ch1,2),(ch2,1,ch2,2),·.,(chm,1,chm,2)。
对于某字符用t，当且仅当任意两个字符之间不存在矛盾，则称该字符是和谐的。
小钟想问你，s的所有连续非空子串中，有多少子串是和谐的？
注意，两个子串不同，当且仅当两个子串在字符串中出现的位置不同。
例如，对于字符串s=AAAA，S_1,2=AA与S_2,3=AA视为不同的子串。
输入描述
第一行有两个整数n(1≤n≤2*10)、m(0m<500)，分别表示字符串s的长度和存在矛盾的字符对的个
数。
第二行有一行字符串s。
接下来m行第i行有两个字符chi,1、chi,2，表示字符ch,1与字符chi,2之间存在矛盾。
保证任何字符不会与自己产生矛盾。矛盾关系可能出现重复。
输出描述
输出一个数字，表示。的多少连续子串是和谐的。
样例1
输入
4 1
ACBA
A B
B C

4 2
ACBA
A B
B C
输岀
6
 */

import java.util.*;

public class BISHI1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int m = sc.nextInt();
        HashMap<Character, Set<Character>> map = new HashMap<>();
        sc.nextLine();
        String s = sc.nextLine();
        for (int i = 0; i < m; i++) {
            String str = sc.nextLine().trim();
            char ch1 = str.charAt(0);
            char ch2 = str.charAt(2);
            map.computeIfAbsent(ch1, k -> new HashSet<>()).add(ch2);
            map.computeIfAbsent(ch2, k -> new HashSet<>()).add(ch1);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            Set<Character> currentChars = new HashSet<>();
            for (int j = i; j < n; j++) {
                char newChar = s.charAt(j);
                boolean hasConflict = false;
                for (char ch : currentChars) {
                    if (map.getOrDefault(ch,new HashSet<>()).contains(newChar)) {
                        hasConflict = true;
                        break;
                    }
                }
                if (hasConflict) {
                    break;
                }
                currentChars.add(newChar);
                count++;
            }
        }
        System.out.println(count);
    }
}
