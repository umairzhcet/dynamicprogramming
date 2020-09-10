//package com.umair;
//
//public class CommonAncestor {
//
//
//              n1
//    n2                n3
// n4      n5         n6      n7
//}
//
//Node left=findAncestor(Node n1,Node root);
//Node right=findAncestor(Node n2,Node root);
//
//
//
//
//
//public findAncestor(Node n , Node root ){
//
//
//
//    if(root.left==null && root.right==null){
//
//        return null;
//
//    }
//    else if(root.val==n1.val || root.val==n2.val){
//        return root;
//    }
//    if(n1.val>=root.val){
//        return findAncestor( n1, n2,root.right);
//    }
//    else if(n1.val<root.val){
//        return findAncestor( n1, n2,root.left);
//
//
//}
//
//
//class Node {
//
//    int val;
//    Node left;
//    Node right;
//
//
//    public Node(int val){
//        this.val=val;
//    }
//
//}
//
//
//            start startword word word
//
//            HashMap<String,Integer> map
//
//           PriorityQueue<FrequencyCount> queue=new PriorityQueue<>();
//            while(map.size()!=0){
//                queue.offer()
//            }
//
//
//            while(queue.isEmpty())
//
//
//FrequencyCount implements Comparable{
//          String word;
//          Integer count;
//
//        @override
//         public compareTo(FrequencyCount fr)   {
//
//            return Integer.compare(this.count,fr.count);
//        }
//
//
//
//            }
//}