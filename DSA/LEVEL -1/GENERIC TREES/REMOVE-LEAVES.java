

import java.io.*;
import java.util.*;

public class Main {
   
 
//main code hai ye
 private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }
 



  public static void removeLeaves(Node node) {

    //loop ulta chalega kyuki aasan hota hain remove remove karna 
     for(int i=node.children.size()-1 ; i>=0 ;i--){
       //aab child main vo vo index vala lelo
       //and aagr uske children nhi hai mtlb leaf hai vo
       //to usse remove kardo
       
       Node child=node.children.get(i);
       if(child.children.size()==0){
         node.children.remove(i);
       }
     }
    // //and loop ki kasiyat ye hai ki bss ye leaf nodes ke element ko call nhi lga paega
    //kyuki vo remove he ho jaenge uper pre order main pehle he
     for(Node child:node.children){
       removeLeaves(child);
     }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    removeLeaves(root);
    display(root);
  }
}














  






















 



