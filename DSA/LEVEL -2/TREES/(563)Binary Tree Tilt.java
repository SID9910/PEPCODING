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
    int tilt=0;
    public int findTilt(TreeNode root) {
if(root == null){
    return 0;

}
        helper(root);
        return tilt;
    
    }
     public int helper(TreeNode root) {
if(root == null){
    return 0;

}
         int ls =helper(root.left);
        int rs =helper(root.right);
        int totalsum=ls+rs+root.val;
        tilt+=Math.abs(ls-rs);
        return totalsum;
    }
}

