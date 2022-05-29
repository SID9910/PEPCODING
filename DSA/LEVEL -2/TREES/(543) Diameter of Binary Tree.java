
class Solution {
    int dia =0;
  public  int helper(TreeNode root) {
        if (root == null){
      return 0;
  }
  int lh = helper(root.left);
  int rh = helper(root.right);
  int ht = Math.max(lh, rh)+1;
  
  if(lh+rh> dia){
      dia = lh+rh;
  }
  return ht; 
  }
  
  public  int diameterOfBinaryTree(TreeNode root){
   
   helper(root);
  return dia;
  }
  
  

}