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
   
    //approach-1
//ye list globally bta dea hai humne
//      List<Integer> list;
//     public List<Integer> preorderTraversal(TreeNode root) {
//         list=new ArrayList<>();
//         preorder(root);
//         return list;
//     }

//     public void preorder(TreeNode root){
//         if(root==null){
//             return; 
//         }
//         list.add(root.val);
//         preorder(root.left);
   
//         preorder(root.right);
//     }
//approach-2
//  morris traversal
// tc=o(n) and space =o(1)
public List<Integer> preorderTraversal(TreeNode root){
   List<Integer> retVal =new ArrayList<>();
   TreeNode curr= root; //aabhi node current per hai
   while(curr!=null){
       if(curr.left ==null){
           //print
           retVal.add(curr.val);
           //
           curr =curr.right;
           
       }else {
           TreeNode iop = curr.left ;
           while(iop.right !=null && iop.right != curr){
               iop =iop.right;
           }
           if(iop.right == null){
               retVal.add(curr.val);
               iop.right =curr;
               curr =curr.left;
           }
           else{
               iop.right =null;
               
               curr =curr.right;
           }
       }
       
   }
   return retVal;
}
}
