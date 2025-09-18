package 美团0906;

import java.util.*;

/*
题目内容:
已知一套试卷包含多个 x - dp 算法，即 x 类型的 dp (保证 x 不为空且不含 d' 和 p' 两个字符)。
例如 sosdp，adp，其拼接起来为 sosdpadp，构成了一套完整的试卷。
现在便可以得到该试卷中存在若干类型的 dp 算法，你需要知道有多少种本质不同的 dp 算法, 即有多少种不同 x 类型的算法。
保证 s 可以被唯一地分割为一个或多个形如 x + dp 的段。
输入描述:
在一行上输入一个仅由小写字母组成的字符串s (3≤length(s）≤10^6），表示试卷。
 */
public class BISHI1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        HashSet<String> set = new HashSet();
        String[] res = s.split("dp");
        for (int i = 0; i < res.length; i++) {
            set.add(res[i]);
        }
        System.out.println(set.size());
    }
}
