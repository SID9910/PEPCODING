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
    //tc -o(n) space =o(n)
     public boolean findTarget(TreeNode root, int k){
        if(root == null){
            return false;
        } 
         List<Integer> list = new ArrayList<>();
         inorder(root , list);
         int i=0;
         int j=list.size()-1;
         while(i<j){
             int sum =list.get(i)+list.get(j);
             if(sum ==k){
                 return true;
             }
             else if(sum>k){
                 j--;
             }else{
                 i++;
             }
         }
         return false;
     }
    private void inorder(TreeNode node ,List<Integer> list ){
        if(node ==null){
            return ;
        }
        inorder(node.left , list);
        list.add(node.val);
        inorder(node.right , list);
    }
    
}