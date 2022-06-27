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

    public int sumOfLeftLeaves(TreeNode root) {
if(root ==null){
    return 0;
}  
    //sum variable main store kar lo
        int sum =0;
        //root ke left ko traverse karo
        if(root.left!=null){
            //aaagr root ke left side se uska left or right null ho tabhi
            //bss sum main root ka left add karo aaagr nhi ho aaise niche jao or root.left   main
        if(root.left.left==null && root.left.right == null){
        sum+=root.left.val;
        }else{
            sum+=sumOfLeftLeaves(root.left);
        }
}
        //aaab ho sakta hai right side left vale bhi ho unhe bhi call mardo 
        //vo bhi aapni side ke left valo ko bhi call mar denge
        sum+=sumOfLeftLeaves(root.right);
        return sum;
    }
}
