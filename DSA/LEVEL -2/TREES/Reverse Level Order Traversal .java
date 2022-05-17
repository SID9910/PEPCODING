

 
// } Driver Code Ends



/* 
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Tree
{
    
    //basically hum kya kar rahe hai pehle queue main remove kar rahe hai and stack main push
    //kar rahe hai and pehle right children  dalenge and then left children queue main dalenge
    //and then aaise remove karke fhir stack main puch kar denge 
    //jaab sab stack main puch ho jaenge use pop karke nikal lenge saare while loop ki help se
    public ArrayList<Integer> reverseLevelOrder(Node node) 
    {  
        
ArrayList<Integer> ret = new ArrayList<>();
     Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Stack<Integer> st = new Stack<>();
        
        while(queue.size()>0){
          Node temp =queue.remove();
          st.push(temp.data);
         
              
              if(temp.right!=null){
                  queue.add(temp.right);
              }
              if(temp.left !=null){
                  queue.add(temp.left);
              }
          }
          
             while(st.size()>0){
                  int val =st.pop();
                  ret.add(val);
             
          }

return ret;
        }
  
          
        
    
}      