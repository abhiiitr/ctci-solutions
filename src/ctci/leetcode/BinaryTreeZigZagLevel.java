package ctci.leetcode;

import java.util.*;

public class BinaryTreeZigZagLevel {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        Stack<TreeNode> left = new Stack<>();
        Stack<TreeNode> right = new Stack<>();
        List<List<Integer>> result = new ArrayList<>();
        left.push(root);
        result.add(Arrays.asList(root.val));
        while (!left.isEmpty() || !right.isEmpty()) {
            TreeNode temp;
            List<Integer> level = new ArrayList();
            while (!left.isEmpty()) {
                temp = left.pop();
                if (temp.left != null)
                    right.push(temp.left);
                if (temp.right != null)
                    right.push(temp.right);
                level.add(temp.val);
            }
            if (level.size() > 0) {
                result.add(level);
                level = new ArrayList<>();
            }

            while (!right.isEmpty()) {
                temp = right.pop();
                if (temp.right != null)
                    left.push(temp.right);
                if (temp.left != null)
                    left.push(temp.left);
                level.add(temp.val);
            }
            if (level.size() > 0)
                result.add(level);

        }
        PriorityQueue queue = new PriorityQueue();

        return result;
    }

}
