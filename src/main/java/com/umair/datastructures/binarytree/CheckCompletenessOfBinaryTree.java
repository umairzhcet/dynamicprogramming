package com.umair.datastructures.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessOfBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left =new TreeNode(6);

        System.out.println(new CheckCompletenessOfBinaryTree().isCompleteTree(root));

    }

    public boolean isCompleteTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean past=false;

        while(!queue.isEmpty()){
            TreeNode node =queue.poll();
            if(node!=null){
                if(past ==true){
                    return false;
                }
                else{
                    queue.add(node.left);
                    queue.add(node.right);

                }

            }
            else{
                past =true;

            }
        }

        return true;

    }
}
