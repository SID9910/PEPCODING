/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //ye pair ke through he karenge ye head and tail lekar
    class Pair {
        TreeNode head;
        TreeNode tail;
        Pair(){
            
        }
        //constructor
        Pair(TreeNode head , TreeNode tail){
            this.head =head;
            this.tail = tail;
        }
    }
    // ispe root null nhi hona chaheye
    public void flatten(TreeNode root) {
       if(root!=null){
           helper(root);
       } 
    }
    
    public Pair helper(TreeNode node){
    
        if(node.left!=null && node.right!=null){
    //iss se expect karenge ki ye left ko linear karke rakhega and right se jode dega sab
            Pair lp =helper(node.left);
            //is se bhi expect karenge ki ye right ko linear karke rakhega and right se sab ko jode rakhega
          Pair lr =helper(node.right);
            
            //eek new node banage and uska left null karenge fhir left ko node ke right ki jagah laagenge and right ko left ki tail se jodenge and akri tail right ki hogi and head node hoga
            Pair mp =new Pair();
            mp.head = node;
            mp.head.left =null;
            mp.head.right =lp.head;
            lp.tail.right =lr.head;
            mp.tail =lr.tail;
            return mp;
            
        }//aagr left hua bss taab sabko right side se jodenge
        else if(node.left!=null){
            Pair lp =helper(node.left);
            Pair mp =new Pair();
            mp.head = node;
            mp.head.left =null;
    
           mp.head.right =lp.head;
            mp.tail =lp.tail;
            return mp;
        }
        //aagr bss right hua uska taab bss right se jod denge sab ko
        else if(node.right!=null){
            Pair lr =helper(node.right);
         Pair mp =new Pair();
            mp.head = node;
            mp.head.left =null;
    
           mp.head.right =lr.head;
            mp.tail =lr.tail;  
            return mp;
        }else {
            //agr node ke sath main kucch nhi bss node return kardo
            Pair mp =new Pair(node,node);
            return mp;
        }
    }
}