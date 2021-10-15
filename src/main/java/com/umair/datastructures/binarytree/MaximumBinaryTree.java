package com.umair.datastructures.binarytree;

public class MaximumBinaryTree {

    public static void main(String[] args) {
    int nums[]={3,2,1,6,0,5};
    TreeNode root=new MaximumBinaryTree().constructTree(nums,0,nums.length-1);

        System.out.println(root.toString());
    }

    public TreeNode constructTree(int[] nums,int l, int r){

        if(l>r){
            return null;
        }

        int max=Integer.MIN_VALUE;
        int rootIndex=-1;
        for(int i=l;i<=r;i++){
            if(nums[i]>max){
                max=nums[i];
                rootIndex=i;
            }
        }
        TreeNode root=new TreeNode(nums[rootIndex]);
        root.left=constructTree(nums,l,rootIndex-1);
        root.right=constructTree(nums,rootIndex+1,r);
        return root;
    }
}
