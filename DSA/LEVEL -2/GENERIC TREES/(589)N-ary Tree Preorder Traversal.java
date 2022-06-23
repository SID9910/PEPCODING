
class Solution {
    


    public List<Integer> preorder(Node root) {
    
            List<Integer> result = new ArrayList<>();
    
            helper(root,result);
    
            return result;
    
        }
    
        void helper(Node root,List<Integer> list){
    
            if(root==null){
    
                return;
    
            }
    
            list.add(root.val);
    
            for(Node val:root.children){
    
                helper(val,list);
    
            }
    
        }
            
    
    }