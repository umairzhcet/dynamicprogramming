package com.umair.datastructures.binarytree;

public class TiltOfTree {
    static int ans=0;
    public static void main(String[] args) {
        TreeNode root=new TreeNode();
        new TiltOfTree().rec(root);
        System.out.println(ans);
    }

    public int rec(TreeNode root){

        if(root==null){
            return 0;
        }

        int lt=rec(root.left);
        int rt=rec(root.right);
        ans+=Math.abs(lt-rt);
        return lt+rt+root.val;
    }
}
