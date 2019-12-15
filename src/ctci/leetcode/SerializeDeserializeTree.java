package ctci.leetcode;

public class SerializeDeserializeTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "null,";
        StringBuilder result = new StringBuilder();
        result.append(root.val).append(",");
        result.append(serialize(root.left));
        result.append(serialize(root.right));
        // System.out.println(result.toString());
        return result.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        int start = 0, end = nodes.length -2;
        TreeNode root = null;
        return deserialize(nodes, new int[]{0}, nodes.length - 1);
    }

    public TreeNode deserialize(String[] nodes, int start[], int end){

        if(start[0] == end)
            return null;
        String val = nodes[start[0]++];
        if("null".equals(val))
            return null;
//        System.out.println(start[0]);
        TreeNode root = new TreeNode(Integer.valueOf(val));
        //root.val = Integer.parseInt(nodes[start++]);
        root.left = deserialize(nodes, start, end);
        root.right = deserialize(nodes, start, end);

        return root;
    }

    public void printInOrder(TreeNode node) {
        if (node == null)
            return;
        printInOrder(node.left);
        System.out.println(node.val);
        printInOrder(node.right);
    }

    public static void main(String[] args) {
        SerializeDeserializeTree codec = new SerializeDeserializeTree();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        codec.printInOrder(codec.deserialize(codec.serialize(n1)));
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}
