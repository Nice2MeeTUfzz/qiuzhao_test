package LeetCode;

import java.util.*;

public class 二叉树右视图199 {
    public List<Integer> rightView(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        int max_depth = -1;

        Deque<TreeNode> nodeStack = new LinkedList<>();
        Deque<Integer> depthStack = new LinkedList<>();

        nodeStack.push(root);
        depthStack.push(0);

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();
            if (node != null) {
                if (!map.containsKey(depth)) {
                    max_depth = Math.max(max_depth, depth);
                    map.put(max_depth, node.val);
                }
                nodeStack.push(node.left);
                nodeStack.push(node.right);
                depthStack.push(depth + 1);
                depthStack.push(depth + 1);
            }
        }

        List<Integer> re = new ArrayList<>();
        for (int i = 0; i < max_depth; i++) {
            re.add(map.get(i));
        }
        return re;
    }
}
