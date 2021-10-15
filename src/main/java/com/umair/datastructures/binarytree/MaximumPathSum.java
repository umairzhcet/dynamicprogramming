package com.umair.datastructures.binarytree;

public class MaximumPathSum {

    int ans=Integer.MIN_VALUE;

    public static void main(String[] args) {

        TreeNode node=new TreeNode();

        new MaximumPathSum().rec(node);

    }

    public int rec(TreeNode root){
        if(root==null){
            return 0;
        }

        int left=Math.max(rec(root.left),0);
        int right=Math.max(rec(root.right),0);

        ans=Math.max(ans,left+right+root.val);

        return Math.max(left,right)+root.val;
    }


}
