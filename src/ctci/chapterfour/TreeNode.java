package ctci.chapterfour;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    static void printTree(TreeNode node) {

        if (node != null) {
            // Inorder traversal
            printTree(node.left);
            System.out.print(node.val + " , ");
            printTree(node.right);
        }
    }
}
