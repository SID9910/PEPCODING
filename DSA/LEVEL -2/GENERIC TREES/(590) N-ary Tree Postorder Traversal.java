class Solution {
    public List<Integer> postorder(Node root) {

        List<Integer> res = new ArrayList<>();

        helper(root , res);

        return res;

    }

    public void helper(Node node , List<Integer>res){

        if(node == null)

            return;

        for(Node val:node.children ){

            helper(val , res);

        }

        res.add(node.val);

    }
        
    

}