
 */
  // public List<List<Integer>> levelOrder(TreeNode root) {
  //       List<List<Integer>> list = new ArrayList<>();
  //       if(root==null)
  //           return list;
  //       Queue<TreeNode> q = new LinkedList<>();
  //       q.add(root);
  //       while(q.isEmpty()==false){
  //           int treeLvl = q.size();
  //           List<Integer> subList = new ArrayList<>();
  //           for(int i=0; i<treeLvl; i++){
  //               TreeNode curr = q.poll();
  //               subList.add(curr.val);
  //               if(curr.left!=null)
  //                   q.add(curr.left);
  //               if(curr.right!=null)
  //                   q.add(curr.right);
  //           }
  //           list.add(subList);
  //       }
  //       return list;
  //   } 
    
  class Solution {
    //level order using size method
    public List<List<Integer>> levelOrder(TreeNode root) {
         List<List<Integer>> list=new ArrayList<List<Integer>>();
         if(root==null)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size()>0){
            int lsize =queue.size();
             List<Integer> subList = new ArrayList<>();
           for(int i=0 ;i<lsize ;i++){
            TreeNode temp =queue.remove();
            subList.add(temp.val);
            if(temp.left!=null){
                queue.add(temp.left);
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }
           }
            list.add(subList);
            
        }
        return list;
    }
}