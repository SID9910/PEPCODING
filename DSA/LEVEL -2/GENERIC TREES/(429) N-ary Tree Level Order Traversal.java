/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
      if(root == null){
return new ArrayList<>();
}
     List<List<Integer>> ans = new ArrayList<>();
    List<Integer> ans2 = new ArrayList<>(); 
    Queue<Node> q = new ArrayDeque<Node>();
    Queue<Node> cq = new ArrayDeque<Node>();
    
                      q.add(root); 
  while(q.size()>0){
     Node temp = q.remove();
        ans2.add(temp.val);
        
 for(Node child: temp.children){
     cq.add(child);
 }
 
  if(q.size()==0){
   q = cq;
  cq = new ArrayDeque<>();
  ans.add(ans2);
  ans2 = new ArrayList<>();
 }
}

return ans;
} 
    }
