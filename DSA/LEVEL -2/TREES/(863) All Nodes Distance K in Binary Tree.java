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
    
    private static List<Integer>  printkdown(TreeNode node, int k ,TreeNode blocker){
    
        
        if(node == null || k<0 || node ==blocker){
              List<Integer> list = new ArrayList<>();
            return list;
        }
        if(k==0){
            List<Integer> list = new ArrayList<>();
            list.add(node.val);
            return list;
            
        }
        List<Integer> list1 = printkdown(node.left, k-1, blocker);
        List<Integer> list2 = printkdown(node.right, k-1, blocker);
          list1.addAll(list2);
        
        return list1;
    }
    
    private  List<TreeNode> nodetorootpath(TreeNode node ,TreeNode target){
        if(node == null ){
            return new ArrayList<>();
            
        }
        if(node == target){
            List<TreeNode> list = new ArrayList<>();
            list.add(node);
            return list;
        }
    List<TreeNode> llist = nodetorootpath(node.left ,target);
        if(llist.size()>0){
            llist.add(node);
            return llist;
        }
        
          List<TreeNode> rlist = nodetorootpath(node.right ,target);
        if(rlist.size()>0){
            rlist.add(node);
            return rlist;
        }
        return rlist;//isme saare honge kyukin ye tarah final list ka kaam karegi
        
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<TreeNode> path = nodetorootpath(root ,target);
        List<Integer> ans1 = new ArrayList<>(); 
        for(int i=0;i<path.size();i++){
               ans1.addAll(printkdown(path.get(i),k-i,i==0 ?null :path.get(i-1)));
          }
        return ans1;
    }
}


