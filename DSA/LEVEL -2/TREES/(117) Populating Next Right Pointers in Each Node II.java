/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
//ye code 116 leetcode main bhi valid hai
//for incomplete binary tree

class Solution {
    public Node connect(Node root) {
        Node curr =root;
        Node head =null;
        Node tail =null;
        
        //ye current har level per traverse karne main help karega
        //and isko head se point karakar agle level per jaenge
        while(curr!=null){
            
            //ye current aapne next per jane ka kaam karega
            while(curr!=null){
                if(curr.left!=null){
                    //head ho level se jodna
                    if(head == null){
                        head =curr.left;
                        tail= curr.left;
                    }else{
                        //connection banana
                        tail.next = curr.left;
                        tail =curr.left;
                    }
                    
                }
                  if(curr.right!=null){
                      //head ko right se jodna jaab left na ho
                    if(head == null){
                        head =curr.right;
                        tail= curr.right;
                    }else{
                        //connection banana aapne agle se
                        tail.next = curr.right;
                        tail =curr.right;
                    }
                   
                }
                //current ke thorugh ke aage badaenge
                curr= curr.next;
                
            }
            //head ke through niche jana current se point karana 
            //and head ,tail ko fhir null karna
                curr =head;
                head =null;
                tail =null;
        }
        return root;//akri main root return karna
        
    }
}