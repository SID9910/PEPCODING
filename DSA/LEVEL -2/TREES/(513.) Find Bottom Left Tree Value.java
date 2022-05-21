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
    //maximum height nikal lo jaise he height akri level per hogi left size ke barabar then vo //he hogi bottom left
    public int height(TreeNode root){
        if(root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right)+1;
    }
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int height = height(root);
        int level =1;
        while(que.size()>0){
            int size = que.size();
            for(int i=0; i<size; i++){
                   TreeNode temp =que.remove();
            
                     if(i==0 && level ==height){
                         return temp.val;
                         
                     }
                     if(temp.left!=null){
                         que.add(temp.left);
                     }
                     
                     
                     if(temp.right!=null){
                         que.add(temp.right);
                     }
                 
            }
            level++;
        }
        return -1;
    }
}
