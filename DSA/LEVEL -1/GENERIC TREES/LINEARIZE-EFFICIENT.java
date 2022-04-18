


import java.io.*;
import java.util.*;

public class Main {
   
 
//main code hai ye
 private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  
//linear efficient ka code
//tc=o(n)
public static Node linearizeefficient(Node node){
    //aaagr node khali hui to ye hoga
    if(node.children.size()==0){
      return node;
    }
    //last child isme aajaega
    Node lastchild =node.children.get(node.children.size()-1);
    //isme last ki tail store ho jaegi
    Node lastTail=linearizeefficient(lastchild);
  
    while(node.children.size()>1){
  
      //isme second last store hoga
      Node slastchild =node.children.get(node.children.size()-2);
      //isme second last ki tail store hogi
      Node slastTail=linearizeefficient(slastchild);
      //aaab addd kardo isse lastchild se 
      slastTail.children.add(lastchild);
      //aab iski help se last child ko remove kardo
      node.children.remove(node.children.size()-1);
      //aaab last node haat hai hai mtlb second last aab last hai
      //aaise karte jao jaab taak node.children ka size 1 na ho jay
      lastchild=slastchild;
    }
    //aab tail return kardo bss akri main
    return lastTail;
  
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
      linearizeefficient(root);
      display(root);
    }
 
 
  


 
}














  






























