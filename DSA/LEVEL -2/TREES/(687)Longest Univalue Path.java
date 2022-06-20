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
    int length =0; //static lekar chalenge
    public int longestUnivaluePath(TreeNode root) {
        helper(root,-1); //root ka parent nhi hai uper to usko -1 lekar chalo
      if(length>0){
          length =length-1;//-1 isley hum nodes ki form main  nikalenge and edge ki form main 
                        //retun karenge length
      }
        return length; 
    }
    public int helper(TreeNode node , int val){
        if(node == null){
            return 0;
        }
        int left = helper(node.left , node.val); //aapse parent node ke jaise niche saare
        int right = helper(node.right , node.val);//same dhundege right and left
 
        //aaagr length se baade hua comparission then update
        if(left+right+1>length){
     length =left+right+1;
 }
       // jaise he niche jakar value same mill gai aapne parent node jaise max karke return kardo nhi to return 0 kardo jaab na mille 
        if(val==node.val){
            return Math.max(left,right)+1;
        }else{
            return 0;
        }
    }
}