

class Solution {
    //inorder traversal
//   approach-1
    //  ArrayList<Integer> list;
    // ArrayList<Integer> inOrder(Node root) {
          
    
    
    //     list=new ArrayList<>();
    //     inorder(root);
    //     return list;
    // }
    
    // public void inorder(Node root){
    //     if(root==null){
    //         return; 
    //     }
       
    //     inorder(root.left);
    //      list.add(root.data);
    //     inorder(root.right);
    
    // }
    
    // approACH-2
    
    //morris traversal
    
     ArrayList<Integer> inOrder(Node root){
         ArrayList<Integer> retVal =new ArrayList<>();
         
         Node curr = root;
         while(curr!=null){
             if(curr.left ==null){
                 //print
                 retVal.add(curr.data);
                 curr =curr.right;
                 
             }else{
                 Node iop =curr.left;
                 while(iop.right!=null && iop.right!=curr){
                     iop=iop.right;
                 }
                 if(iop.right ==null){
                     iop.right =curr;
                     curr=curr.left;
                 }else{
                     iop.right =null;
                     retVal.add(curr.data);
                     curr =curr.right;
                 }
          
             }
             
         }
         
         return retVal;
         
     }
    
    
    
    
    
    
    
    
    
}