package com.umair.datastructures.binarytree;

public class CountCompleteTreeNodes {

    public static void main(String[] args) {

    }

    public int countNodes1(TreeNode root) {
        if(root ==null){
            return 0;
        }

        int leftHeight =heightLeft(root);
        int rightHeight =heightRight(root);

        if(leftHeight==rightHeight){
            return (int)Math.pow(2,leftHeight)-1;
        }
        return 1+countNodes1(root.left)+countNodes1(root.right);

    }

    public int countNodes2(TreeNode root) {
        if(root ==null){
            return 0;
        }

        int left =countNodes2(root.left);
        int right =countNodes2(root.right);
        return 1+left+right;

    }

    public int heightLeft(TreeNode root){

        if(root ==null){
            return 0;
        }
        return 1+heightLeft(root.left);

    }

    public int heightRight(TreeNode root){

        if(root ==null){
            return 0;
        }
        return 1+heightRight(root.right);

    }
}
