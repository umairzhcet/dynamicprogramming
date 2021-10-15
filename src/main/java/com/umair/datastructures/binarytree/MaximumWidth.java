package com.umair.datastructures.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidth {

    static class Pair {
        TreeNode node;
        int pos;

        Pair(TreeNode node,int pos){
            this.node=node;
            this.pos=pos;
        }
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode();
        if(root==null){
            System.out.println(0);
        }

        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        int max=1;
        while(!q.isEmpty()){
            int size=q.size();
            int lm=q.peek().pos;
            int rm=0;
            for(int i=0;i<size;i++){
                Pair item=q.poll();
                rm=item.pos;
                if(item.node.left!=null){
                    q.add(new Pair(item.node.left,2*rm+1));
                }
                if(item.node.right!=null){
                    q.add(new Pair(item.node.right,2*rm+2));
                }
                max=Math.max(max,rm-lm+1);
            }

        }

        System.out.println(max);
    }
}
