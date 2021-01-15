import ds.binarytree.BinaryTree;
import ds.binarytree.BinaryTree.TreeNode;

public class Solution {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else {
            return p.data == q.data
                    && isSameTree(p.left, q. left)
                    && isSameTree(p.right, q.right);
        }
    }

    public static void main(String[] args) {
        Integer[] data1 = new Integer[]{1, 2};
        Integer[] data2 = new Integer[]{1, null, 2};
        Integer[] data3 = new Integer[]{1, 1, 2};
        Integer[] data4 = new Integer[]{1, 2, 1};
        Integer[] data5 = new Integer[]{1, 2, 3};
        TreeNode<Integer> tree1 = new BinaryTree<>(data1).root;
        TreeNode<Integer> tree2 = new BinaryTree<>(data2).root;
        TreeNode<Integer> tree3 = new BinaryTree<>(data3).root;
        TreeNode<Integer> tree4 = new BinaryTree<>(data4).root;
        TreeNode<Integer> tree5 = new BinaryTree<>(data5).root;
        System.out.println("expected: true, actual: " + isSameTree(tree5, tree5));
        System.out.println("expected: false, actual: " + isSameTree(tree1, tree2));
        System.out.println("expected: false, actual: " + isSameTree(tree3, tree4));
    }
}
