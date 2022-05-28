//morris travERSAL KE THROUGH KARENGE
class Solution
{
    // returns the inorder successor of the Node x in BST (rooted at 'root')
	public Node inorderSuccessor(Node root,Node x)
         {
            Node prev =null;
        Node curr =root;
        Node n1 =null;
        Node succ =null;
        Node n2 =null;
        while(curr!=null){
            if(curr.left ==null){
                if(prev == x){
                succ = curr;
            }
                prev =curr;
                curr=curr.right;
                
            }else{
                Node iop =curr.left;
                while(iop.right!=null && iop.right!=curr){
                    iop =iop.right ;
                }
                if(iop.right ==null){
                    iop.right =curr;
                    curr=curr.left;
                }
                else{
         if(prev == x){
                succ = curr;
            }
               
                prev =curr;
                iop.right =null;
                curr=curr.right;
                    
                }
            
            }
        }
            return succ;
         }
}