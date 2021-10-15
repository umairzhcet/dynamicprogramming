package com.umair.datastructures.binarytree;

import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversal {

    List<Integer> result=new ArrayList<>();

    public static void main(String[] args) {

        TreeNode root=new TreeNode();
        new PreOrderTraversal().preOrder(root);
    }

    public void preOrder(TreeNode root){

        if(root==null){
            return;
        }
        result.add(root.val);
        preOrder(root.left);
        preOrder(root.right);

    }
}
