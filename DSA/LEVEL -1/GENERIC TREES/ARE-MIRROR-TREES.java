

import java.io.*;
import java.util.*;

public class Main {
   
 
//main code hai ye
 private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }
  

//are trees mirror
 public static boolean areMirror(Node n1, Node n2) {
    if(n1.children.size()!=n2.children.size()){
    return false;
  }

  //child per he chalegi
  for(int i=0 ;i<n1.children.size();i++){
    Node c1 =n1.children.get(i);
    //ye last child se start hoga
    Node c2 =n2.children.get(n2.children.size()-1-i);
    if(areMirror(c1,c2)==false){
      return false;
    }
  
  
  }
  //aaagr uper se nhi milla mtlb true hai
  return true;
}

public static void main(String[] args) throws Exception {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  int n1 = Integer.parseInt(br.readLine());
  int[] arr1 = new int[n1];
  String[] values1 = br.readLine().split(" ");
  for (int i = 0; i < n1; i++) {
    arr1[i] = Integer.parseInt(values1[i]);
  }
  Node root1 = construct(arr1);

  int n2 = Integer.parseInt(br.readLine());
  int[] arr2 = new int[n2];
  String[] values2 = br.readLine().split(" ");
  for (int i = 0; i < n2; i++) {
    arr2[i] = Integer.parseInt(values2[i]);
  }
  Node root2 = construct(arr2);

  boolean mirror = areMirror(root1, root2);
  System.out.println(mirror);
}

 
  
  }
  


  

  












  





















