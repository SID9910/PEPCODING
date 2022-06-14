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
    public TreeNode deleteNode(TreeNode root, int key) {
      if(root ==null){
          return null;
      }
        //aaagr value badi aaai mtlb right side hogi vo
        if(key>root.val){
            root.right = deleteNode(root.right ,key);
            return root;
        }
        //aagr value choti aai mtlb left side hogi vo
        else if(key<root.val){
            root.left = deleteNode(root.left , key);
            return root;
        }
        //aaagr value barabar aai to case lagenge ander
        else {
            //aagar value ke children nhi honge mtlb leaf node ko  null return kar denge
            if(root.left ==null && root.right == null){
                return null;
            }
            //agr bss uska right taab bss right return kar denge mtlb node ka children bedgh 
            //denge uper node ko chodkar
            else if(root.left == null){
                return root.right;
            }
            //aaagr bss uska left hua taab bss  right return kar denge mtlb node ka children bedgh denge uper node ko chodkar
            else if(root.right == null){
                return root.left;
            }
            //aaagr value ke dono children hue taab hum left ka max manga lenge and 
            // value ko left ke max se badal denge and value delete kar denge 
            //lmax ko bhi delete kar denge calll lagakar 
            //deleteNode ke through
            
            else {
                int lmax =max(root.left);
                root.val =lmax;
                root.left =deleteNode(root.left ,lmax);
                return root;
                
            }
        }
    }
    //left ka max nikal lenge is max ke through
    public int max(TreeNode node){
        while(node.right!=null){
            node = node.right;
        }
        return node.val;
    }
}