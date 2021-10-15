package com.umair.datastructures.binarytree;

public class InvertTree {

    public static void main(String[] args) {
        TreeNode root=new TreeNode();
        root=new InvertTree().invertTree(root);
    }

    public TreeNode invertTree(TreeNode root) {

        if(root==null){
            return null;
        }

        TreeNode left=invertTree(root.left);
        TreeNode right=invertTree(root.right);
        root.left=right;
        root.right=left;
        return root;

    }
}
