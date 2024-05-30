package com.umair.datastructures.binarytree;

public class BalancedBinaryTree {

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left=new TreeNode(2);
        p.right=new TreeNode(3);
        p.right.right = new TreeNode(4);
        System.out.println(new BalancedBinaryTree().isBalanced(p));
    }

    public boolean isBalanced(TreeNode root) {

        if(root ==null){
            return true;
        }

        int lh=height(root.left);
        int rh=height(root.right);

        if(Math.abs(lh-rh)>1){
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);


    }

    public int height(TreeNode root){
        if(root ==null){
            return 0;
        }
        return 1+Math.max(height(root.left),height(root.right));
    }


}
