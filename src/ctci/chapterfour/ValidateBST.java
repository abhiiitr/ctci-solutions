package ctci.chapterfour;

public class ValidateBST {

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, Integer min, Integer max) {

        if (root == null)
            return true;

        if ((min != null && root.val <= min) || (max != null && root.val >= max))
            return false;

        if (!isValidBST(root.left, min, root.val) || !isValidBST(root.right, root.val, max))
            return false;

        return true;
    }

    public static void main(String[] args) {
        /*  5
           / \
          1   4
             / \
            3   6
            // 6 > 5 so NOT a BST
           */
        TreeNode root = new TreeNode(5);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(6);

        root.left = n2;
        root.right = n3;
        n3.left = n4;
        n3.right = n5;

        ValidateBST obj = new ValidateBST();
        System.out.print(obj.isValidBST(root));
    }
}
