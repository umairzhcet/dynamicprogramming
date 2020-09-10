package com.umair.recursion;

public class LongestUniValuePath {

    static int max=0;

    public static void main(String[] args) {

        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(4);
        root.left.left=new TreeNode(1);
        root.left.right=new TreeNode(1);

        root.right=new TreeNode(5);
        root.right.right=new TreeNode(5);


        recursiveSol(root);
        System.out.println(max);
    }

    public static int recursiveSol(TreeNode root){

        if(root==null){
            return 0;
        }
        int leftPath=recursiveSol(root.left);
        int rightPath=recursiveSol(root.right);

        if (root.left != null && root.left.val == root.val) {
            leftPath= leftPath + 1;
        }
        else{
            leftPath=0;
        }

        if (root.right != null && root.right.val == root.val) {
            rightPath = rightPath + 1;
        }
        else{
            rightPath=0;
        }
        max=Math.max(max,leftPath+rightPath);

        return Math.max(leftPath,rightPath);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
