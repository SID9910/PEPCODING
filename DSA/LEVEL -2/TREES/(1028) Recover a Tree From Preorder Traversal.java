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
    int i=0; //as a traversal use kar rahe hai hum isse
    public TreeNode recoverFromPreorder(String traversal) {
        return helper(traversal , 0); //input string and depth
        
    }
    public TreeNode  helper(String str , int depth){
        int d =0; //means dash
        
        //aaagr dash milenge taab he chalega ye
        while(i+d<str.length() && str.charAt(i+d)=='-'){ //string ke ander hona chaheye
                                                        //aaagr bash mille taab he chalega ye
            d++; //dash ko bda do jis se algi per chali jaengi
        }
        
        //jaab depth ke barabar dash nhi hogi to leaf ka kaam hoga 
        //mtlb null return karenge aaagr dash depth ke barabar nhi honge jaab
        if(d!=depth){
            return null;           }
        
        int nd =0; //means non dash
        
        //aab jaise non dash values like 100,200,300
        //aenge bss unke ley chalega ye
        while(i+d+nd<str.length() && str.charAt(i+d+nd)!='-'){
            //string ke ander ho taab chalega //character dash nhi hon a chaheye
            nd++;//aaagr non dash values milti jaenge jaab taak chalega ye
        }
        //aaab value ke ley hum dash se pehli vali value le lenge subtring ke through
        //kyuki subtring eek index kaam degi
        int val =Integer.parseInt(str.substring(i+d, i+d+nd));//mtlb dash ki value se i+d se
                           //isley kyuki uper loop dash ko eek index aage dega uper se jo
                           //ki non dash per jakar rukega loop ke dash ke hisab se
                           //i+d+nd main dash per hogi jis se substring apply karne se 
                           //eek index pehli vali value mill jaegi
        i=i+d+nd; //is se bash se start karenge jaab non dash uper se khatam hogi
        TreeNode node =new TreeNode(val); //value aajaengi
        node.left =helper(str, depth+1);//ye isley taaki agli depth ke ley kaam karenge
        node.right =helper(str,depth+1);
        return node;//iss se uper node bedghenge
    }
}