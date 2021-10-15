package com.umair.datastructures.binarytree;

public class MinimumDepth {

    public static void main(String[] args) {
        TreeNode root=new TreeNode();
        new MinimumDepth().minDepth(root);
    }

    public int minDepth(TreeNode root){
        if(root==null){
            return 0;
        }

        int left=minDepth(root.left);
        int right=minDepth(root.right);
        if(root.left==null && right>0){
            return 1+right;
        }
        if(root.right==null && left>0){
            return 1+left;
        }
        return 1+Math.min(left,right);
    }
}
