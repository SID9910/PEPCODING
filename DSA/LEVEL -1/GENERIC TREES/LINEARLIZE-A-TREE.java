

import java.io.*;
import java.util.*;

public class Main {
   
 
//main code hai ye
 private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }





//is function ki help se tail nikal lenge 
public static Node getTail(Node node){
    while(node.children.size()>0){
       node =node.children.get(0);
    }
    return node;
  }

  public static void linearize(Node node){
  
  for(Node child:node.children){
    linearize(child);
  }
  //saara kaam post order main hoga
   while(node.children.size()>1){
     Node last=node.children.remove(node.children.size()-1);

     //isme children.size()-1 use is ley kara kyuki uper se remove hogya hau
     //to slast he aab last node reh gya hai dekha jay to
     Node slast = node.children.get(node.children.size()-1);
     Node slastTail = getTail(slast);
     slastTail.children.add(last);

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
    linearize(root);
    display(root);
  }
 
 
  


 
}














  


















