
class Solution {
    //Function to find the height of a binary tree.
    int height(Node node) 
    {
    if(node ==null){
        return 0;
    }
    int leftheight =height(node.left);
    int rightheight =height(node.right);
    int maxheight =Math.max(leftheight ,rightheight)+1;
    return maxheight;
    }
}
