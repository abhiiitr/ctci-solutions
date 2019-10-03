package ctci.chapterfour;

public class Successor {
    /* Successor: Write an algorithm to find the "next" node (i.e., in-order successor)
    of a given node in a binary search tree.
    You may assume that each node has a link to its parent.*/

    public TreeNodeV2 findSuccessorInBST(TreeNodeV2 node) {

        if (node == null)
            return null;
        // Node contains parent as well
        TreeNodeV2 result = null;

        // If right node is present
        if (node.right != null) {
            return node.right;
        } else if (node.parent != null && node.parent.left == node) {
            // If node is a left child of parent, then only the successor is possible i.e. parent
            return node.parent;
        }

        return null;
    }

    public static void main(String[] args) {
        /*  5
           / \
          1   10
             / \
            7   12
            // 6 > 5 so NOT a BST
           */
        TreeNodeV2 root = new TreeNodeV2(5);
        TreeNodeV2 n2 = new TreeNodeV2(1);
        TreeNodeV2 n3 = new TreeNodeV2(10);
        TreeNodeV2 n4 = new TreeNodeV2(7);
        TreeNodeV2 n5 = new TreeNodeV2(12);

        root.left = n2;
        root.right = n3;
        root.parent = null;
        n2.parent = root;
        n3.parent = root;
        n3.left = n4;
        n3.right = n5;
        n4.parent = n3;
        n5.parent = n3;

        Successor obj = new Successor();
        printSuccessor(n3, obj.findSuccessorInBST(n3));
        printSuccessor(n4, obj.findSuccessorInBST(n4));
        printSuccessor(n5, obj.findSuccessorInBST(n5));
    }

    private static void printSuccessor(TreeNodeV2 node, TreeNodeV2 successor) {

        System.out.print(node.val + " : ");
        if (successor != null) {
            System.out.println(successor.val);
        } else
            System.out.println("No Successor");
    }
}
