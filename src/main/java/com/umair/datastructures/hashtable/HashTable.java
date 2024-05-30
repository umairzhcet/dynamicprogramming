package com.umair.datastructures.hashtable;

import java.util.Arrays;

public class HashTable {

    private HashNode[] buckets;
    private int noOfBuckets;
    private int size;

    public HashTable(int capacity){
        this.noOfBuckets = capacity;
        this.buckets = new HashNode[noOfBuckets];
        this.size = 0;
    }
    public HashTable(){
        this(10);
    }

    public void put(Integer key, String value){

        if(key==null || value==null){
            throw new IllegalArgumentException("key or value cannot be null");
        }
        int bucketIndex=getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        while(head!=null){
            if(head.key.equals(key)){
                head.value=value;
                return;
            }
            head = head.next;
        }
        size++;
        head = buckets[bucketIndex];
        HashNode node = new HashNode(key,value);
        node.next=head;
        buckets[bucketIndex]=node;
    }

    public String get(Integer key){
        if(key==null)  {
            throw new IllegalArgumentException("key cannot be null");
        }

        int bucketIndex=getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        while(head!=null){
            if(head.key.equals(key)){
                return head.value;
            }
            head= head.next;
        }
       return null;
    }
    public String remove(Integer key){
        if(key==null)  {
            throw new IllegalArgumentException("key cannot be null");
        }

        int bucketIndex=getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        HashNode previous = null;
        while(head!=null){
            if(head.key.equals(key)){
                size--;
                if(previous==null){
                    buckets[bucketIndex]=head.next;
                }
                else{
                     previous.next =head.next;
                }
                return head.value;
            }
            previous = head;
            head = head.next;
        }

       return null;
    }

    private int getBucketIndex(Integer key) {
        return key%noOfBuckets;
    }

    @Override
    public String toString() {
        return "HashTable{" +
                "buckets=" + Arrays.toString(buckets) +
                ", noOfBuckets=" + noOfBuckets +
                ", size=" + size +
                '}';
    }

    private class HashNode{
        private Integer key;
        private String value;
        private HashNode next;

        public HashNode(Integer key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "HashNode{" +
                    "key=" + key +
                    ", value='" + value + '\'' +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        HashTable table = new HashTable(10);
        table.put(105, "A");
        table.put(508, "B");
        table.put(216, "C");
        table.put(155, "D");
        table.put(105, "AA");
        System.out.println(table);
        System.out.println(table.size);
        table.remove(155);
        System.out.println(table.size);
        System.out.println(table);   
    }

}
