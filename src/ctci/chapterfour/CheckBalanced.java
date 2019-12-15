package ctci.chapterfour;

import java.util.List;

public class CheckBalanced {

    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        boolean result = false;

        // not efficient
        int h1 = height(root.left);
        int h2 = height(root.right);
        if(Math.abs(h1 - h2) <= 1)
            return isBalanced(root.left) && isBalanced(root.right);
        else
            return false;
    }

    public int height(TreeNode node){
        if(node != null){
            return 1 + Math.max(height(node.left), height(node.right));
        } else
            return 0;
    }

    public static void main(String[] args) {
        /*  3
           / \
          9  20
            /  \
           15   7
           */
        TreeNode root = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);

        root.left = n2;
        root.right = n3;
        n3.left = n4;
        n3.right = n5;

        CheckBalanced obj = new CheckBalanced();
        System.out.print(obj.isBalanced(root));
    }
}
