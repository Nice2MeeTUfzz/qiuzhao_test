package LeetCode;

import java.util.*;

public class 反转链表206 {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode temp = head.next;
        if(temp == null) return head;
        head.next = null;
        while (temp.next != null) {
            ListNode next = temp.next;
            temp.next = head;
            head = temp;
            temp = next;
        }
        temp.next = head;
        head = temp;
        return head;
    }
}
