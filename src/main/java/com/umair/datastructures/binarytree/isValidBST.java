package com.umair.datastructures.binarytree;

public class isValidBST {

    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        long min =Long.MIN_VALUE;
        long max =Long.MAX_VALUE;

        return isValid(root,min,max);

    }

    public boolean isValid(TreeNode root, long min, long max){

        if(root==null){
            return true;
        }
        if(root.val<=min || root.val>=max ){
            return false;

        }

        return isValid(root.left,min,root.val) && isValid(root.right,root.val,max);
    }
}
