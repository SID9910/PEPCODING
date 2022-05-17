


/*Complete The Function Provided
Given Below is The Node Of Tree
class Node
{
    int data;
    Node left, right;
    public Node(int data)
    {
        this.data = data;
         left = right = null;
    }
}*/


class Solution{
    
        //queue main jo add karenge uska size nikal lenge and uska first index store kar lenge arraylist 
        //main and aakhri main return kar denge arraylist ko
    ArrayList<Integer> rightView(Node root) {
        
            ArrayList<Integer> retval = new ArrayList<>();
         if (root == null){
             return retval;
             }
             Queue<Node> queue = new LinkedList<>();
             queue.add(root);
             
             while(queue.size()>0){
                 
                 int lsize =queue.size();
                 for(int i=0 ;i<lsize ;i++){
                   
                     Node temp =queue.remove();
            
                     if(i==lsize-1){
                         retval.add(temp.data);
                         
                     }
                     if(temp.left!=null){
                         queue.add(temp.left);
                     }
                     
                     
                     if(temp.right!=null){
                         queue.add(temp.right);
                     }
                 } 
        
             }
       
       return retval;
       }
    }



