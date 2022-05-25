


class Solution
{
    public static int maxPathSum(Node root)
    {
        if(root ==null){
            return 0;
            
        }
        if(root.left ==null && root.right ==null){
            return root.data;
        }
        int left =maxPathSum(root.left);
        int right =maxPathSum(root.right);
        return Math.max(left ,right)+root.data;
    }
}