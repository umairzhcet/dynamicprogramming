package com.umair.datastructures.binarytree;

public class MaximumBinaryTree2 {

    public static void main(String[] args) {

        TreeNode root=new TreeNode();
        int val=5;
        root=new MaximumBinaryTree2().addNode(root,val);
        System.out.println(root);

    }

    public TreeNode addNode(TreeNode root, int val){
        if(root==null){
            return new TreeNode(val);
        }
        if(val>root.val){
            return new TreeNode(val, root, null);
        }

        else{
            root.right=addNode(root.right,val);
            return root;
        }
    }
}
