package ctci.chapterfour;

public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        data = x;
    }

    static void printTree(TreeNode node){

        if(node !=null){
            // Inorder traversal
            printTree(node.left);
            System.out.print(node.data + " , ");
            printTree(node.right);
        }
    }
}
