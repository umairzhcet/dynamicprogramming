package com.umair;

import java.util.PriorityQueue;

public class MergeKSortedList {

    public static void main(String[] args) {

        ListNode node1=new ListNode();
        node1.val=1;
        node1.next=new ListNode(4);
        node1.next.next=new ListNode(5);

        ListNode node2=new ListNode();
        node2.val=1;
        node2.next=new ListNode(3);
        node2.next.next=new ListNode(4);

        ListNode node3=new ListNode();
        node3.val=2;
        node3.next=new ListNode(6);

        ListNode[] lists=new ListNode[3];
        lists[0]=node1;
        lists[1]=node2;
        lists[2]=node3;


        ListNode result=new ListNode();

        int k=lists.length;
        PriorityQueue<Integer> heap=new PriorityQueue();

        for(int i=0;i<k;i++){
            ListNode node=lists[i];

            while(node!=null){
                heap.add(node.val);
                node=node.next;
            }

        }
        result.val=heap.poll();

        while(!heap.isEmpty()){
            ListNode next=new ListNode(heap.poll());
            result.next=next;
            result=result.next;

        }
        System.out.println(result);
    }

     static class ListNode {
     int val;
      ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
