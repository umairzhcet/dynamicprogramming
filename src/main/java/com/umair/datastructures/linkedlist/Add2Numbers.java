package com.umair.datastructures.linkedlist;

public class Add2Numbers {

    public static void main(String[] args) {

        Add2Numbers main=new Add2Numbers();

        ListNode l1 = new ListNode(7);
        l1.next=new ListNode(2);
        l1.next.next=new ListNode(4);
        l1.next.next.next=new ListNode(3);

        System.out.println(l1);


        ListNode l2 = new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(4);

        System.out.println(l2);

        System.out.println(main.addTwoNumbers(l1,l2));
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        l1=reverseList(l1);
        l2=reverseList(l2);

        ListNode result=null;
        int sum=0;
        while(l1!=null || l2!=null || sum!=0){

            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }

            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }

            ListNode node=new ListNode(sum%10);
            sum=sum/10;

            node.next=result;
            result=node;

        }
        return result;


    }

    public ListNode reverseList(ListNode node){

        ListNode prev=null;
        while(node!=null){
            ListNode next=node.next;
            node.next=prev;
            prev=node;
            node=next;
        }
        return prev;
    }

     static class ListNode {
         @Override
         public String toString() {
             return "ListNode{" +
                     "val=" + val +
                     ", next=" + next +
                     '}';
         }

         int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
       }

}

