package org.practise.algorithm.interviewbit.tree.easy;

import org.practise.algorithm.pojo.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 *  Height-balanced binary tree : is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 *
 * Example :
 *
 * Input :
 *           1
 *          / \
 *         2   3
 *
 * Return : True or 1
 *
 * Input 2 :
 *          3
 *         /
 *        2
 *       /
 *      1
 *
 * Return : False or 0
 *          Because for the root node, left subtree has depth 2 and right subtree has depth 0.
 *          Difference = 2 > 1.
 */
public class BalancedTree {
    public int isBalanced(TreeNode node) {
        return isBalancedTree(node).isBalanced ? 1 : 0;
    }

    public Result isBalancedTree(TreeNode node) {
        if (node == null) return new Result(0, true);
        Result left = isBalancedTree(node.left), right = isBalancedTree(node.right);
        int height = 1 + Math.max(left.height, right.height);
        if ( ! left.isBalanced || ! right.isBalanced || left.height > right.height + 1 || left.height + 1 < right.height) {
            return new Result(height, false);
        }
        return new Result(height, true);
    }

    class Result {
        int height;
        boolean isBalanced;
        public Result(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }
}
