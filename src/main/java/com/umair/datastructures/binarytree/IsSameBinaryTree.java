package com.umair.datastructures.binarytree;

public class IsSameBinaryTree {

    public static void main(String[] args) {

        TreeNode p = new TreeNode(1);
        p.left=new TreeNode(2);
        p.right=new TreeNode(1);

        TreeNode q = new TreeNode(1);
        q.left=new TreeNode(1);
        q.right=new TreeNode(2);

        System.out.println(new IsSameBinaryTree().isSameTree(p,q));

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p== null && q==null){
            return true;
        }
        if(p==null || q==null || p.val!=q.val){
            return false;
        }

        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right) ;


    }
}
