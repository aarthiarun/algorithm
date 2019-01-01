package org.practise.algorithm.leetcode.linkedlist;

import org.practise.algorithm.pojo.TreeNode;

/**
 * Convert a BST to a sorted circular doubly-linked list in-place. Think of the left and right pointers as synonymous to the previous and next pointers
 * in a doubly-linked list.
 *
 * Let's take the following BST as an example, it may help you understand the problem better:
 *
 *
 *
 *
 *
 * We want to transform this BST into a circular doubly linked list. Each node in a doubly linked list has a predecessor and successor.
 * For a circular doubly linked list, the predecessor of the first element is the last element, and the successor of the last element is the first element.
 *
 * The figure below shows the circular doubly linked list for the BST above. The "head" symbol means the node it points to is the smallest element of the linked list.
 *
 *
 *
 *
 *
 * Specifically, we want to do the transformation in place. After the transformation, the left pointer of the tree node should point to its predecessor,
 * and the right pointer should point to its successor. We should return the pointer to the first element of the linked list.
 *
 * The figure below shows the transformed BST. The solid line indicates the successor relationship, while the dashed line means the predecessor relationship.
 */
public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null)
            return null;
        TreeNode left = treeToDoublyList(root.left), right = treeToDoublyList(root.right);

        root.left = root;
        root.right = root;
        return concatenate(concatenate(left, root), right);
    }

    private TreeNode concatenate(TreeNode left , TreeNode right) {
        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        TreeNode leftLast = left.left, rightLast = right.left;

        leftLast.right = right;
        rightLast.right = left;


        right.left = leftLast;
        left.left = rightLast;

        return left;
    }
}
