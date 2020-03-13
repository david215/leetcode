import java.util.Queue;
import java.util.LinkedList;

import ds.binarytree.BinaryTree;
import ds.binarytree.BinaryTree.TreeNode;


public class Solution {
    public static boolean isSymmetricTree(TreeNode root) {
        return isMirror(root, root);
    }

    private static boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else {
            return left.data == right.data
                    && isMirror(left.left, right.right)
                    && isMirror(left.right, right.left);
        }
    }

    // recursive solution 1
    // public static boolean isSymmetricTree(TreeNode root) {
    //     if (root == null) {
    //         return true;
    //     }
    //     return isMirror(root.left, root.right);
    // }

    // private static boolean isMirror(TreeNode p, TreeNode q) {
    //     Queue<TreeNode> left = new LinkedList<>();
    //     Queue<TreeNode> right = new LinkedList<>();
    //     left.offer(p);
    //     right.offer(q);
    //     return isMirrorHelper(left, right);
    // }

    // private static boolean isMirrorHelper(Queue<TreeNode> left, Queue<TreeNode> right) {
    //     if (left.isEmpty() || right.isEmpty()) {
    //         return left.isEmpty() && right.isEmpty();
    //     } else {
    //         TreeNode leftNode = left.poll();
    //         TreeNode rightNode = right.poll();
    //         if (leftNode == null && rightNode == null) {
    //             return isMirrorHelper(left, right);
    //         } else if (leftNode == null || rightNode == null) {
    //             return false;
    //         } else if (leftNode.data != rightNode.data) {
    //             return false;
    //         } else {
    //             left.offer(leftNode.left);
    //             left.offer(leftNode.right);
    //             right.offer(rightNode.right);
    //             right.offer(rightNode.left);
    //             return isMirrorHelper(left, right);
    //         }
    //     }
    // }

    // iterative solution
    // public static boolean isSymmetricTree(TreeNode root) {
    //     if (root == null) {
    //         return true;
    //     }
    //     return isMirror(root.left, root.right);
    // }

    // private static boolean isMirror(TreeNode p, TreeNode q) {
    //     Queue<TreeNode> leftQueue = new LinkedList<>();
    //     Queue<TreeNode> rightQueue = new LinkedList<>();
    //     leftQueue.offer(p);
    //     rightQueue.offer(q);
    //     while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
    //         TreeNode leftNode = leftQueue.poll();
    //         TreeNode rightNode = rightQueue.poll();
    //         if (leftNode == null && rightNode == null) {
    //             continue;
    //         } else if (leftNode == null || rightNode == null) {
    //             return false;
    //         } else if (leftNode.data != rightNode.data) {
    //             return false;
    //         } else {
    //             leftQueue.offer(leftNode.left);
    //             leftQueue.offer(leftNode.right);
    //             rightQueue.offer(rightNode.right);
    //             rightQueue.offer(rightNode.left);
    //         }
    //     }
    //     return leftQueue.isEmpty() && rightQueue.isEmpty();
    // }

    public static void main(String[] args) {
        Integer[] data1 = new Integer[]{1, 2, 2, 3, 4, 4, 3};
        Integer[] data2 = new Integer[]{1, 2, 2, null, 3, null, 3};
        TreeNode<Integer> tree1 = new BinaryTree<>(data1).root;
        TreeNode<Integer> tree2 = new BinaryTree<>(data2).root;
        System.out.println("expected: true, actual: " + isSymmetricTree(tree1));
        System.out.println("expected: false, actual: " + isSymmetricTree(tree2));
    }
}
