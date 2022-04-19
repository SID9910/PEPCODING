

import java.io.*;
import java.util.*;

public class Main {
   
 
//main code hai ye
 private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }
 
  public static ArrayList<Integer> nodeToRootPath(Node node, int data){
      //aaagr pehle he data mill jay taab add kardo arrayList main
    if(node.data == data){
        ArrayList<Integer> base = new ArrayList<>();
        base.add(node.data);
         return base;
         }
  //faith
  for(Node child: node.children){
    ArrayList<Integer> nodeToRootPath = nodeToRootPath(child , data);
    //aagr uper se return hone ke baad node khali ho jata hai taab stop honge 
    //mhi to add karte jaenge node.data ko
    if(nodeToRootPath.size()>0){
      nodeToRootPath.add(node.data);
      return nodeToRootPath;
    }
  }
  //aaagr kuch na milla to return kar deenge khali arraylist
  return  new ArrayList<>();
  
   }
    public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];
      String[] values = br.readLine().split(" ");
      for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(values[i]);
      }
  
      int data = Integer.parseInt(br.readLine());
  
      Node root = construct(arr);
      ArrayList<Integer> path = nodeToRootPath(root, data);
      System.out.println(path);
      // display(root);
    }
  
}














  






















 




 