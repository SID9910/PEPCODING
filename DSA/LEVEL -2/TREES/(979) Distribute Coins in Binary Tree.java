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
    //isme basically total nodes and total coins har point per calculate karenge
    class Pair {
        int nodes;
        int coins;
    }
    //isme moves aaenge saare and ye static lekar chal rahe hai hum
    int moves =0;
    public int distributeCoins(TreeNode root) {
         helper(root);
        return moves;
    }
    //main ye kaam karega saara
    public Pair helper(TreeNode node){
        if(node == null){
            return new Pair();

        }
        Pair lp = helper(node.left);
        Pair rp =helper(node.right);
        //eek har point per calculate karne main help karega
        Pair mp =new Pair();
        //total nodes har point per
        mp.nodes =lp.nodes +rp.nodes+1;
        //total coins har point per
        mp.coins =lp.coins+rp.coins+node.val;
        //absolute diffenence he bataega ki kitne coins extra hai and extra coins he moves   honge
        moves+=Math.abs(mp.nodes -mp.coins);
        return mp;
        
        
    }
}