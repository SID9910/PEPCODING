/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //ye isley kyuki humme pta lagana hai ki nodes milli hai ya nhi
    //aaagr mmilli hongi tabhi lca call karenge
    boolean f1=false;
    boolean f2 =false;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    f1=false;
        f2=false;
        TreeNode lca = helper(root,p,q);
        //ye true then lca call
        if(f1 && f2){
            return lca;
        }else{
            //nhi to null
            return null;
        }
        
        }
    TreeNode helper(TreeNode node, TreeNode n1 , TreeNode n2){
        //aagr node kahli then null return kardo
        if(node == null){
            return null;
            
        }
        
        //saara kaam post order main hoga
            TreeNode left =helper(node.left , n1 , n2);
            TreeNode right = helper(node.right,n1,n2);
        
        //aaagr value mille bss eek return kardo vo
            if(node.val == n1.val){
                f1 =true;
                return node;
            }else if(node.val == n2.val){ //aagr bss dusri then vo return uper
                f2 =true;
                return node;
            }//aagr uska left or right do then node return karo
            else if(left!=null && right!=null){
                return node;
            }else if(left!=null){ //aagar bss left ho
                return left;
            }else if(right!=null){ //agar bss right ho
                return right;
            }else {
                //aagr nhi milla then return uper
                return null;
            }
         
    }
}