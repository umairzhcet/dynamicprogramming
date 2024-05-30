package com.umair.datastructures.binarytree;

public class Diameter {

    static int ans=Integer.MIN_VALUE;

    public static void main(String[] args) {

        TreeNode node=new TreeNode(1);
        node.left = new TreeNode(2);
        recursiveHeight(node);
        System.out.println(ans);

        System.out.println(diameterOfBinaryTree(node));

    }

    public static int diameterOfBinaryTree(TreeNode root) {

        if(root ==null){
            return 0;
        }

        int hl =height(root.left);
        int hr =height(root.right);

        int dl =diameterOfBinaryTree(root.left);
        int dr =diameterOfBinaryTree(root.right);

        int result = Math.max(Math.max(dl,dr),hl+hr);

        return result;


    }

    public static int height(TreeNode root){

        if(root==null){
            return 0;
        }
        int left=height(root.left);
        int right=height(root.right);

        return 1+Math.max(left,right);

    }

    public static int recursiveHeight(TreeNode root){

        if(root==null){
            return 0;
        }
        int left=recursiveHeight(root.left);
        int right=recursiveHeight(root.right);

        //at every recursive call, also update the global ans value with the sum of left height and right height;

        ans=Math.max(ans,left+right);

        return 1+Math.max(left,right);

    }


}
