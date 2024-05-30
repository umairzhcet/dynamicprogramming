package com.umair.datastructures.binarytree;

public class CountGoodNodes {

    public static void main(String[] args) {

        TreeNode q = new TreeNode(3);
        q.left=new TreeNode(1);
        q.right=new TreeNode(4);
        q.right.left=new TreeNode(1);
        q.right.right=new TreeNode(5);
        q.left.left=new TreeNode(3);

        System.out.println(new CountGoodNodes().goodNodes(q));

    }

    public int goodNodes(TreeNode root) {

        return countGood(root,Integer.MIN_VALUE);

    }

    public int countGood(TreeNode root, int maxValue){
        int count =0;

        if(root==null){
            return 0;
        }

        if(root.val>=maxValue){
            count++;
            maxValue=root.val;
        }
        int lc=countGood(root.left,maxValue);
        int rc=countGood(root.right,maxValue);

        return count+lc+rc;

    }
}
