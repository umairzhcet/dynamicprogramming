package com.umair.recursion;

import java.util.ArrayList;
import java.util.List;

public class TreePathSum {

    public static void main(String[] args) {

        List<List<Integer>> result=new ArrayList<>();

        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(4);
        root.right=new TreeNode(8);
        root.left.left=new TreeNode(11);
        root.left.left.left=new TreeNode(7);
        root.left.left.right=new TreeNode(2);
        root.right.left=new TreeNode(13);
        root.right.right=new TreeNode(4);
        root.right.right.left=new TreeNode(5);
        root.right.right.right=new TreeNode(1);


        int sum=22;

        recursiveSol(root,sum,new ArrayList<Integer>(),result);

        System.out.println(result);

    }

    public static void recursiveSol(TreeNode root, int sum,List<Integer> list,List<List<Integer>> result){

        if(root==null){
            return;
        }

        if(root.val==sum && root.left==null && root.right==null){
            result.add(list);
        }

        list.add(root.val);
        recursiveSol(root.left,sum-root.val,new ArrayList<Integer>(list),result);
        recursiveSol(root.right,sum-root.val,new ArrayList<Integer>(list),result);

    }

    public static class TreeNode {
     int val;
      TreeNode left;
     TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
         this.right = right;
      }
 }
}
