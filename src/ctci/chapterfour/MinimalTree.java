package ctci.chapterfour;

public class MinimalTree {

    /* 4.2 Minimal Tree: Given a sorted (increasing order) array with
    unique integer elements, write an algorithm to
    create a binary search tree with minimal height.*/
    
    public TreeNode sortedArrayToBST(int[] nums) {

        if (nums == null || nums.length == 0)
            return null;

        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        TreeNode root = null;
        if (start > end)
            return null;
        else {
            int mid = (start + end) / 2;
            root = new TreeNode(nums[mid]);
            root.left = sortedArrayToBST(nums, start, mid - 1);
            root.right = sortedArrayToBST(nums, mid + 1, end);
        }

        return root;
    }

    public static void main(String[] args) {
        MinimalTree obj = new MinimalTree();

        int nums[] = {-10, -3, 0, 5, 9};
        TreeNode resultRoot = obj.sortedArrayToBST(nums);
        TreeNode.printTree(resultRoot);
    }
}
