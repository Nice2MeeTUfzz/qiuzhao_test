package 小米823_1;
import java.util.*;
/*
 * 题目内容:
 * n艘船出发去探索海洋深处。这些船编号从 1 到 n,按升序依次排列:
 * 第i艘船的耐久度为a_1。海怪按特定顺序对这些船发动了k次攻击。
 * 首先，它攻击第一艘船，然后是最后一艘，接着又攻击第一艘，依此类推。
 * 海怪的每次攻击都会使船的耐久度降低1。当船的耐久度降至0时，它就会沉没，不再受到攻击(因此该船不再是第一艘或最后一艘。海怪只会攻击尚未沉没的船)。
 * 如果所有船都沉没了，海怪就没有可攻击的目标，便会游走。
 * 例如，如果n=4、k=5,且a=[1,2,4，3].将会发生以下情况:
 * 1. 海怪攻击第一艘船,其耐久度变为0,现在a=[2,4,3]
 * 2. 海怪攻击最后一艘船,现在a=[2,4,2]
 * 3. 海怪攻击第一艘船,现在a=[1,4,2]
 * 4. 海怪攻击最后一艘船,现在a=[1,4,1]
 * 5. 海怪攻击第一艘船,其耐久度变为0,现在a=[4,1]。请问海怪攻击后有多少艘船沉没了?
 * 输入描述:
 * 输入包括多组测试数据。
 * 第一行包含一个整数t表示测试数据的组数.对于每个测试用例:
 * 1. 第一行包含两个整数 n 和 k,表示船的数量以及海怪攻击船的次数。
 * 2. 第二行包含n个整数a_1,a_2...a_n,表示船的耐久度。
 * 输出描述:
 * 对于每个测试用例，在单独的一行中输出被海怪击沉的船的数量。
 */
public class BISHI1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            ArrayList<Integer> a = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                a.add(sc.nextInt());
            }
            int presum = a.size();
            for (int i = 0; i < k; i++) {
                if (i % 2 == 0 && !a.isEmpty()) {
                    Integer i1 = a.get(0);
                    if (i1 - 1 == 0) {
                        a.remove(0);
                    } else {
                        a.set(0, i1 - 1);
                    }
                } else if (i%2 ==1 && !a.isEmpty()){
                    int index = a.size() - 1;
                    Integer i1 = a.get(index);
                    if (i1 - 1 == 0) {
                        a.remove(index);
                    } else {
                        a.set(index, i1 - 1);
                    }
                }else {
                    break;
                }
            }
            System.out.println(presum - a.size());
        }
    }
}
