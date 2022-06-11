
class Solution {
    //ye eek tarah static ka kaam karega isme value update hoti jaegi
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        max =Integer.MIN_VALUE;
        maxPathSum_RTN(root);
        return max;
    }
    //it return maximum root to node ,but also calculate maximum node to node path.
    public int maxPathSum_RTN(TreeNode node){
        if(node ==null){
            return 0;
        }
        
        int left = maxPathSum_RTN(node.left);
        int right = maxPathSum_RTN(node.right);
        
        int left_dash =Math.max(0 ,left);
        int right_dash =Math.max(0,right);
        
        //pura code same hai bss ye extra kaam hai 
        // is sumfromlefttoright ke through comparison hoga and value max main iske through he updatehogi aagar baadi hui max se
        int sumfromleftToright=left_dash+right_dash+node.val;
        if(sumfromleftToright >max){
            max =sumfromleftToright;
        }
        
        
        return Math.max(left_dash ,right_dash)+node.val;
        
        
    }
    
}