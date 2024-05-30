package com.umair.datastructures.binarytree;

public class SubsetOfAnotherTree {

    public static void main(String[] args) {

        TreeNode p = new TreeNode(1);
        p.left=new TreeNode(2);
        p.right=new TreeNode(1);

        TreeNode q = new TreeNode(3);
        q.left=new TreeNode(4);
        q.right=new TreeNode(1);
        q.right.left=new TreeNode(2);
        q.right.right=new TreeNode(1);

        System.out.println(new SubsetOfAnotherTree().isSubtree(q,p));

    }


    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null && subRoot==null){
            return true;

        }
        if(root ==null || subRoot==null){
            return false;
        }
        if(root.val==subRoot.val && checkEqual(root,subRoot)){
            return true;
        }

        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);

    }

    public boolean checkEqual(TreeNode root, TreeNode subRoot){

        if(root==null && subRoot==null){
            return true;
        }

        if(root==null || subRoot==null ||root.val!=subRoot.val){
            return false;
        }

        return checkEqual(root.left,subRoot.left) && checkEqual(root.right,subRoot.right);


    }


}
