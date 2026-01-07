package LeetCode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class 二叉树展开为链表114 {
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
//                找左子树的最右边节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
//                将原来的右子树连接到左子树的最右边节点
                pre.right = root.right;
//                将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }
}

