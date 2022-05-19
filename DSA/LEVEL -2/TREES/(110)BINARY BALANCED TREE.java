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
  
    boolean TreeIsbalanced =true;
  private int Isbalanced2(TreeNode node){
    if(node ==null){
      return -1;
    }

  int leftheight =Isbalanced2(node.left);
  int rightheight =Isbalanced2(node.right);

  int height =Math.max(leftheight ,rightheight)+1;
 boolean nodeBalance =Math.abs(leftheight -rightheight)<=1;
  if(nodeBalance ==false){
    TreeIsbalanced= false;
  }
  
  return height;

  }
    public boolean isBalanced(TreeNode root) {
          Isbalanced2(root);
		return  TreeIsbalanced;
    }
}