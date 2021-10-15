package com.umair.datastructures.linkedlist;

public class LinkedListReversal {

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);

        ListNode result=reverseList(head);
        //ListNode result=reverseBetween(head,1,2);
        while(result!=null){
            System.out.println(result.val);
            result=result.next;
        }


    }

    public static ListNode reverseList(ListNode head) {

        ListNode current=head;
        ListNode previous=null;
        ListNode next=null;
        while(current!=null){
            next=current.next;
            current.next=previous;
            previous=current;

            current=next;

        }
        return previous;

    }

    private static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        int counter=1;
        ListNode current=head;
        ListNode previous=null;
        ListNode previousLeft=null;
        ListNode next=null;
        while(counter<m){
            previousLeft=current;
            current=current.next;
            counter++;
        }
        ListNode start=current;

        while(current!=null && counter<=n){

            next=current.next;
            current.next=previous;
            previous=current;

            current=next;
            counter++;

        }
        if(previousLeft!=null)
        previousLeft.next=previous;
        else{
            head=previous;
        }
        start.next=next;

        return head;

    }
}
