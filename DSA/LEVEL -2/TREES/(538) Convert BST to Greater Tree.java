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
    //same as 1038 leetcode
       int sum=0;
       
    public TreeNode convertBST(TreeNode root) {
         
           if(root == null){
               return root;
           }
           convertBST(root.right);
           int osum =root.val;
           sum+=osum;
           root.val =sum;
           convertBST(root.left);
           return root;
           
       
    }
}