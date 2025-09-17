package hiki;

import java.util.*;

public class Solution {
    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<ListNode> sortList(ListNode[] lists) {
        // write code here
        Arrays.sort(lists, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b) {
                if (a == null && b == null) {
                    return 0;
                }
                if (a == null) {
                    return -1;
                }
                if (b == null) {
                    return 1;
                }
                ListNode p = a;
                ListNode q = b;
                while (p != null && q != null) {
                    if (p.val < q.val) {
                        return -1;
                    } else if (p.val > q.val) {
                        return 1;
                    }
                    p = p.next;
                    q = q.next;
                }
                if (p == null) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        return new ArrayList<>(Arrays.asList(lists));
    }
}
