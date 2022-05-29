

class Solution {
    // Function to return the diameter of a Binary Tree.
     int dia =0;
    public  int helper(Node root) {
          if (root == null){
        return 0;
    }
    int lh = helper(root.left);
    int rh = helper(root.right);
    int ht = Math.max(lh, rh)+1;
    
    if(lh+rh+1> dia){
        dia = lh+rh+1;
    }
    return ht; 
    } 
    
    int diameter(Node root) {
    
     helper(root);
    return dia;
    }
    
}
