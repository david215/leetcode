import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;

import ds.binarytree.BinaryTree;
import ds.binarytree.BinaryTree.TreeNode;

public class Solution {
    // recursive (DFS) solution
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, result, 0);
        return result;
    }

    private static void helper(TreeNode node, List<List<Integer>> result, int currDepth) {
        if (node != null) {
            List<Integer> currLevel;
            if (currDepth >= result.size()) {
                currLevel = new ArrayList<>();
                result.add(0, currLevel);
            } else {
                currLevel = result.get(result.size() - 1 - currDepth);
            }
            currLevel.add((Integer) node.data);
            helper(node.left, result, currDepth + 1);
            helper(node.right, result, currDepth + 1);
        }
    }

    // iterative (BFS) solution
    // public static List<List<Integer>> levelOrderBottom(TreeNode<Integer> root) {
    //     List<List<Integer>> result = new ArrayList<>();
    //     Queue<TreeNode<Integer>> queue = new ArrayDeque<>();
    //     if (root != null) {
    //         queue.offer(root);
    //     }
    //     while (!queue.isEmpty()) {
    //         List<Integer> currLevel = new ArrayList<>();
    //         int size = queue.size();
    //         for (int i = 0; i < size; i++) {
    //             TreeNode<Integer> node = queue.poll();
    //             currLevel.add(node.data);
    //             if (node.left != null) { queue.offer(node.left); }
    //             if (node.right != null) { queue.offer(node.right); }
    //         }
    //         result.add(0, currLevel);
    //     }
    //     return result;
    // }

    public static void main(String[] args) {
        Integer[] data = new Integer[]{3, 9, 20, null, null, 15, 7};
        TreeNode<Integer> root = new BinaryTree<Integer>(data).root;
        StringBuilder output = new StringBuilder();
        output.append("expected: [[15, 17], [9, 20], [3]], actual: ");
        output.append(levelOrderBottom(root));
        System.out.println(output.toString());
    }
 }
