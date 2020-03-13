import ds.binarytree.BinaryTree;
import ds.binarytree.BinaryTree.TreeNode;

public class Solution {
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }

    public static void main(String[] args) {
        Integer[] data = new Integer[]{3, 9, 20, null, null, 15, 7};
        TreeNode<Integer> tree = new BinaryTree<>(data).root;
        System.out.println("expected: 3, actual: " + maxDepth(tree));
    }
}
