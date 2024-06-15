package com.greatlearning.javafsd.model;

import java.util.ArrayList;
import java.util.List;

public class PairSum {

    static class TreeNode {
        int value;
        TreeNode left, right;

        TreeNode(int item) {
            value = item;
            left = right = null;
        }
    }

    static TreeNode root;

    
    public static void inorderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, list);
        list.add(node.value);
        inorderTraversal(node.right, list);
    }

   
    public static void findPair(TreeNode root, int sum) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);

        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            int currentSum = list.get(left) + list.get(right);
            if (currentSum == sum) {
                System.out.println("Pair is (" + list.get(left) + ", " + list.get(right) + ")");
                return;
            }
            if (currentSum < sum) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println("Nodes are not found.");
    }

    public static void main(String[] args) {
        
        root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        int sum = 130;
        findPair(root, sum);
    }
}

