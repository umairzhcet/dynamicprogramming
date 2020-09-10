package com.umair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigZagTreeTraversal {

    public static void main(String[] args) {

        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);
        zigzagLevelOrder(root);


    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> current=new Stack<>();
        Stack<TreeNode> next=new Stack<>();
        List<List<Integer>> result=new ArrayList<>();
        current.push(root);
        List<Integer> temp=null;

        while(!current.isEmpty() || !next.isEmpty()){
            temp=new ArrayList<>();
            while(!current.isEmpty()){

                TreeNode node=current.pop();
                temp.add(node.val);

                if(node.left!=null){
                    next.add(node.left);
                }
                if(node.right!=null){
                    next.add(node.right);
                }

            }
            if(temp.size()>0)
            result.add(temp);
            // next level
            temp=new ArrayList<>();
            while(!next.isEmpty()){

                TreeNode node=next.pop();
                temp.add(node.val);

                if(node.right!=null){
                    current.add(node.right);
                }
                if(node.left!=null){
                    current.add(node.left);
                }

            }
            if(temp.size()>0)
            result.add(temp);
        }
     return result;
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
