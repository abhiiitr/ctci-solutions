package ctci.chapterfour;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ListOfDepths {
    /* List of Depths: Given a binary tree, design an algorithm which creates a linked list
    of all the nodes at each depth (e.g., if you have a tree with depth 0, you'll have 0 linked lists).*/


    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new LinkedList<>();
        // For level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<List<Integer>> result = new LinkedList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new LinkedList<>();

            while (size-- > 0) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            result.add(level);
        }

        return result;
    }

    public List<List<Integer>> levelOrderRecursion(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();

        levelOrderHelper(root, levelOrder, 0);

        return levelOrder;
    }

    public void levelOrderHelper(TreeNode node, List<List<Integer>> levelOrder, int level) {
        if (node == null) {
            return;
        }

        if (level >= levelOrder.size()) {

            levelOrder.add(new ArrayList<Integer>());
        }

        levelOrder.get(level).add(node.val);

        levelOrderHelper(node.left, levelOrder, level + 1);
        levelOrderHelper(node.right, levelOrder, level + 1);
    }

    public static void main(String[] args) {
        /*  3
           / \
          9  20
            /  \
           15   7
           */
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;

        ListOfDepths obj = new ListOfDepths();
        List<List<Integer>> lists = obj.levelOrder(n1);
        for (List<Integer> list : lists) {
            for (Integer e : list) {
                System.out.print(e + ",");
            }

            System.out.println();
        }

    }
}
