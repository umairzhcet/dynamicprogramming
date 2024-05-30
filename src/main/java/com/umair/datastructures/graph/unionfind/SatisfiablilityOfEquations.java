package com.umair.datastructures.graph.unionfind;

import java.util.Arrays;

public class SatisfiablilityOfEquations {



    public static void main(String[] args) {
        int[] parent =new int[26];
        int[] rank=new int[26];
        for(int i=0;i<26;i++){
            parent[i]=(char)(i+'a');
        }
        SatisfiablilityOfEquations satisfiablilityOfEquations = new SatisfiablilityOfEquations();
        String[] equations = {"a==b","e==c","b==c","a!=e"};
        System.out.println(satisfiablilityOfEquations.equationsPossible(equations,parent,rank));

    }

    public boolean equationsPossible(String[] equations, int[] parent, int[] rank) {

        for(int i=0;i<26;i++){
            parent[i]=i;
        }

        for(String eq: equations){
            int x = eq.charAt(0)-'a';
            int y = eq.charAt(3)-'a';
            char sign =eq.charAt(1);

            if(sign=='='){
                union(x, y, parent, rank);
            }

        }

        for(String eq: equations){
            char sign =eq.charAt(1);
            if(sign=='!'){
                int x = eq.charAt(0)-'a';
                int y = eq.charAt(3)-'a';
                int x_parent =find(x, parent, rank);
                int y_parent =find(y, parent, rank);
                if(x_parent==y_parent){
                    return false;
                }
            }

        }

        return true;

    }

    public int find(int x, int[] parent, int[] rank){

        if(parent[x]==x){
            return x;
        }
        return parent[x]=find(parent[x],parent,rank);

    }
    public void union(int x, int y, int[] parent, int[] rank){
        if(x>y){
            int temp =x;
            x=y;
            y=temp;
        }

        int x_parent =find(x, parent, rank);
        int y_parent =find(y, parent, rank);

        if(x_parent==y_parent){
            return;
        }
        else if(rank[x_parent]== rank[y_parent]){
            parent[y]=parent[x];
            rank[x]++;
        }

        else if(rank[x_parent]> rank[y_parent]){
            parent[y]=parent[x];
        }
        else {
            parent[x]=parent[y];
        }

    }
}
