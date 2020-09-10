package com.umair.recursion;

import java.util.ArrayList;
import java.util.List;

public class TreePathSum2 {

    //LEETCODE 437

    static int count=0;
    static List<Integer> list=new ArrayList<>();

    public static void main(String[] args) {


        TreeNode root=new TreeNode(10);
        root.left=new TreeNode(5);
        root.right=new TreeNode(-3);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(2);
        root.left.right.right=new TreeNode(1);
        root.left.left.left=new TreeNode(3);
        root.left.left.right=new TreeNode(-2);

        root.right.right=new TreeNode(11);



        int sum=8;

        recursiveSol(root,sum);

        System.out.println(count);

    }

    public static void recursiveSol(TreeNode root, int sum){

        if(root==null){
            return;
        }
        list.add(root.val);
        recursiveSol(root.left,sum);
        recursiveSol(root.right,sum);

        int temp=0;
        for(int i=list.size()-1;i>=0;i--){
            temp+=list.get(i);
            if(temp==sum){
                count++;
            }

        }
        list.remove(list.size()-1);

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
