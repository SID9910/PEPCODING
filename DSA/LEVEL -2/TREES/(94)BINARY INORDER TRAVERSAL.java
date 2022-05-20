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
//     public List<Integer> inorderTraversal(TreeNode root) {
//         list=new ArrayList<>();
//         inorder(root);
//         return list;
//     }
    
//     public void inorder(TreeNode root){
//         if(root==null){
//             return; 
//         }
        
//         inorder(root.left);
//         list.add(root.val);
//         inorder(root.right);
//     }
    //approach-2
    //morris traversal
    //tc=o(n) and space =o(1)
    public List<Integer> inorderTraversal(TreeNode root){
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
                    iop.right =curr;
                    curr =curr.left;
                }
                else{
                    iop.right =null;
                    retVal.add(curr.val);
                    curr =curr.right;
                }
            }
            
        }
        return retVal;
    }
 