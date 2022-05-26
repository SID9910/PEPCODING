

//duabra eek bar or
class Solution {
    public boolean isSymmetric(TreeNode root) {
         return ismirror(root.left,root.right);
      }
      
      private boolean ismirror(TreeNode root1 , TreeNode root2){
          
          if(root1 == null && root2 == null){
              return true;
          }
          
          if( (root1==null && root2!=null) || (root1!=null && root2==null)){
              return false;
          }
          
          return (root1.val == root2.val) && ismirror(root1.left , root2.right)&&            ismirror(root1.right , root2.left);
      }
  }