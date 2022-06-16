

// } Driver Code Ends


//User function Template for Java



//User function Template for Java
/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/
class Solution
{ 
    //Function to convert binary tree into circular doubly linked list.
    Node bTreeToClist(Node root)
    {
         return helper(root);
    }
    Node helper(Node node){
        if(node==null){
            return null;
        }
        // is se faith rakhenge ki ye aapni left side ko doubly linked list bna dega
      Node lefthead = helper(node.left);
            // is se faith rakhenge ki ye aapni right side ko doubly linked list bna dega
      Node righthead =helper(node.right);
       
       //ye root ko aapne aap se point kara dega
       Node onl =node;
       onl.left = onl.right = onl;
       ///jodne ka kaam
       Node s1 =concate(lefthead ,onl);
       Node s2 =concate( s1,righthead );
       return s2;//judi vi list aaise milegi
       
       
        
    }
    //sara jodne ka kaam yha ho rha hai
     Node concate(Node h1, Node h2){
        //pehli list na ho to dusri return kardo
         if(h1 ==null){
             return h2;
         }//dusri list na ho to pehli return kardo
         else if(h2==null){
             return h1;
         }
         //tail aaise milegi
         Node t1 =h1.left;
         Node t2 =h2.left;
         //connection bna rahe hai
         t1.right =h2;
         h2.left =t1;
         t2.right =h1;
         h1.left =t2;
         
         return h1;
    
         
     } 
    
}
    
