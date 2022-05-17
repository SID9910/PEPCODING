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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
   //pehle hum root node ko add karenge then remove karenge and sath main null daal denge
        // then hum root ko remove karenge and array list main store karenge jaab taak  null //encounter nhi hoga .jaise he null aaega .then arraylist main jo store hai usse stack main //puch kar denge and arraylist ko empty kar denge new arraylist banakar start karenge vapis //and aaagr queue main kuch hoga null ke baaad hoga then vapis temp daal denge.kyuki aagr temp //main further children hue to push kar denge..
  //then aakri main jo stack main hoga usse while loop ke through return kar denge aaraylist //main sabko      
    
        
    
        
      if(root == null){
            return new ArrayList<List<Integer>>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null); //har node ke baad null daal  o
        
        Stack<List<Integer>> st = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while(queue.size()>0){
          TreeNode temp =queue.remove();
          if(temp!=null){
                list.add(temp.val);
              if(temp.left!=null){
                  queue.add(temp.left);
              }
              if(temp.right !=null){
                  queue.add(temp.right);
              }
          }
          //jaise he temp null encounter hua us time he new line kardo and null daal do
          else {
              st.add(list);
                list = new ArrayList<>();
                if(queue.size() > 0){
                    queue.add(null);
                  
              }
          }
   
        }

  List<List<Integer>> ans = new ArrayList<List<Integer>>();
        while(st.size() > 0){
            ans.add(st.pop());
        }
        return ans; 
    }
}