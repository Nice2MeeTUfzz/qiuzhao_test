package FunPlus913;
/*
给定一个链表的头节点head，旋转链表，将链表每个节点向右移动k个位置。输入：head=
[1, 2, 3,4,5],k=2输出：[4,5, 1,2,31
链表中节点的数目在范围[0,1000]内-1000<= Node.val<= 1000
示例1
输入
{1,2,3,4,5},3
输岀
{3,4,5,1,2}
 */
import java.util.*;

class ListNode{
    int value;
    ListNode next;
    ListNode(){}
    ListNode(int value) {
        this.value = value;
    }
    ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }

}
public class BISHI1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] parts = input.split(",(?=\\d+$)");
        String arrayStr = parts[0];
        int num = Integer.parseInt(parts[1]);

        arrayStr = arrayStr.replace("[", "").replace("]", "").trim();
        String[] numStrs = arrayStr.split(",\\s*");
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < numStrs.length; i++) {
            list.add(numStrs[i]);
        }

        for (int i = 0; i < num; i++) {

        }
    }
}
