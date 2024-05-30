package com.umair.datastructures.binarytree;

public class LongestZigZagPath {

    int result =0;

    public static void main(String[] args) {

    }

    public int longestZigZag(TreeNode root) {

        helper(root,-1,0);

        return result;

    }

    public void helper(TreeNode root, int direction, int count){

        if(root ==null){
            result =Math.max(result,count-1);
            return;
        }
        if(direction==-1){
            helper(root.right,1,count+1);
            helper(root.left,-1,1);

        }
        else{
            helper(root.left,-1,count+1);
            helper(root.right,1,1);
        }


    }
}
