package com.umair.datastructures.Trie;

import java.util.Arrays;

public class Trie {

    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode current = root;

        for(int i =0; i<word.length(); i++){
            char c = word.charAt(i);
            int index = c-'a';
            if(current.children[index]==null){
                TrieNode node = new TrieNode();
                current.children[index]=node;
                current = node;
            }
            else{
                current = current.children[index];
            }
        }
        current.isWord = true;
    }

    public boolean search(String key){
        TrieNode current = root;
        for(int i=0; i<key.length(); i++){
            char c = key.charAt(i);
            int index = c-'a';
            if(current.children[index] == null){
                return false;
            }
            current=current.children[index];
        }
        return current.isWord;
    }

    private class TrieNode{
        @Override
        public String toString() {
            return "TrieNode{" +
                    "children=" + Arrays.toString(children) +
                    ", isWord=" + isWord +
                    '}';
        }

        private TrieNode[] children;
        private boolean isWord;

        public TrieNode(){
            children = new TrieNode[26];
            isWord = false;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("cat");
        trie.insert("car");
        trie.insert("bat");
        System.out.println("Is cat present? "+trie.search("cat"));
        System.out.println("Is cats present? "+trie.search("cats"));
        System.out.println("Is dog present? "+trie.search("dog"));
    }

    @Override
    public String toString() {
        return "Trie{" +
                "root=" + root +
                '}';
    }
}
