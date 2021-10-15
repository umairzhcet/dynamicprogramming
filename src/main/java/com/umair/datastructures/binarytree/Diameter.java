package com.umair.datastructures.binarytree;

public class Diameter {

    static int ans=Integer.MIN_VALUE;

    public static void main(String[] args) {

        TreeNode node=new TreeNode();
        rec(node);
        System.out.println(ans);

    }

    public static int rec(TreeNode root){

        if(root==null){
            return 0;
        }
        int left=rec(root.left);
        int right=rec(root.right);

        ans=Math.max(ans,1+left+right);

        return 1+Math.max(left,right);

    }
}
