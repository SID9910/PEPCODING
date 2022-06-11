

class Solution
{
    public static int maxPathSum(Node root)
    {
        if(root.left!=null && root.right!=null){
            int left =maxPathSum(root.left);
            int right =maxPathSum(root.right);
            return Math.max(left,right)+root.data;
        }else if(root.left!=null){
         int left =maxPathSum(root.left);
         return left+root.data;
        }else if(root.right!=null){
            int right =maxPathSum(root.right);
        return right+root.data;
            
        }else{
            return root.data;
        }
    }
}