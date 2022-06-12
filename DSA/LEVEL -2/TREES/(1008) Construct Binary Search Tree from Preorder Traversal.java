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
    int index =0;
    public TreeNode bstFromPreorder(int[] preorder) {
     return   constructbinary(preorder ,Integer.MIN_VALUE , Integer.MAX_VALUE);
    }
     public TreeNode constructbinary(int[] pre ,int min ,int max) {
         //basically aaagr preorder main length nhi hui to null kar denge return
         if(index ==pre.length){
             return null;
         }
            //aaagr value max  se choti or min se baadi hui taab
            //naya node banaenge and fhir index baadanege and left right call main
            //bhi same aaise karenge ki unki range main vo aata hai ya nhi
        else if(pre[index]> min && pre[index]<max){
             TreeNode node = new TreeNode();
             node.val =pre[index];
             index++;
              node.left = constructbinary(pre ,min ,node.val);
              node.right = constructbinary(pre ,node.val ,max);
             return node;
         }else {
            //aaagr  range main nhi aaega uper min ,max ki taab null kar denge
            //basically ye leaf banane main help karega
             return null;
         }
        
    }
}