package com.umair.datastructures.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.right=new TreeNode(5);
        root.right.right=new TreeNode(4);

        System.out.println(new RightSideView().rightSideView(root));
        List<Integer> list = new ArrayList<>();

        dfs(root,1, list);
        System.out.println(list);

    }

    private static void dfs(TreeNode root, int level, List<Integer> list) {

        if(root ==null){
            return ;
        }

        if(list.size()<level){
            list.add(root.val);
        }
        dfs(root.right,level+1, list);
        dfs(root.left,level+1, list);


    }

    public List<Integer> rightSideView(TreeNode root) {

        if(root==null){
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int n =queue.size();

            while(n>0){
                TreeNode node =queue.poll();
                if(node.left!=null){
                    queue.add(node.left) ;
                }
                if(node.right!=null){
                    queue.add(node.right) ;
                }
                n--;
                if(n==0){
                    result.add(node.val);
                }

            }


        }

        return result;

    }
}
