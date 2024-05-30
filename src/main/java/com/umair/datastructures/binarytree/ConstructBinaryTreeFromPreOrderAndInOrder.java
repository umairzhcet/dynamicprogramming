package com.umair.datastructures.binarytree;

public class ConstructBinaryTreeFromPreOrderAndInOrder {

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

       TreeNode root = new ConstructBinaryTreeFromPreOrderAndInOrder().buildTree(preorder,inorder);

        System.out.println(root);


    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int start = 0;
        int end =inorder.length-1;

        return helper(preorder, inorder, start, end, 0);

    }

    public TreeNode helper(int[] preorder, int[] inorder, int start, int end, int indexRoot){

        if(start>end){
            return null;
        }

        int root =preorder[indexRoot];
        int i=start;
        for(;i<=end;i++){
            if(inorder[i]==root){
                break;
            }
        }

        TreeNode node =new TreeNode(root);
        int leftTreeLen = i-start;

        node.left =helper(preorder, inorder, start, i-1, indexRoot+1);
        node.right =helper(preorder, inorder, i+1, end, indexRoot+1+leftTreeLen);

        return node;

    }
}
