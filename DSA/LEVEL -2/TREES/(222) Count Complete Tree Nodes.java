
class Solution {
    //pure tree main nodes count karni hai
    //     public int countNodes(TreeNode root) {
    //       if(root ==null){
    //           return 0;
    //       }  
    //         int left =countNodes(root.left);
    //         int right =countNodes(root.right);
    //         int ts=left+right+1;
    //         return ts;
    //     }
        public int countNodes(TreeNode root){
            if(root ==null){
                return 0 ;
            }
            int left =0;
            TreeNode node=root.left;
            while(node!= null){
                node =node.left;
                left++;
            }
            int right =0;
            node =root.right;
            while(node!=null){
              node =node.right;
                right++;
            }
            if(left ==right){
                int ht=left+1;
                return (1 << ht)-1;
            }else{
                return countNodes(root.left)+countNodes(root.right)+1;
            }
            
        }
        
    }