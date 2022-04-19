

import java.io.*;
import java.util.*;

public class Main {
   
 
//main code hai ye
 private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }
   public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
    if (node.data == data) {
      ArrayList<Integer> path = new ArrayList<>();
      path.add(node.data);
      return path;
    }

    for (Node child : node.children) {
      ArrayList<Integer> ptc = nodeToRootPath(child, data);
      if (ptc.size() > 0) {
        ptc.add(node.data);
        return ptc;
      }
    }

    return new ArrayList<>();
  }

//lowest common ansector
  public static int lca(Node node, int d1, int d2) {
  ArrayList<Integer> path1 = nodeToRootPath(node, d1);
  ArrayList<Integer> path2 = nodeToRootPath(node , d2);
  //isme size aajaega
  int i = path1.size()-1;
  int j = path2.size()-1;
  //jaab taak size hai
  while(i>=0 && j>=0){
    if(path1.get(i)==path2.get(j)){
      i--;
      j--;
    }else{
      break;
    }

  }
  // agla index aaajega isme
  int lca =path1.get(i+1);
  return lca;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    int d1 = Integer.parseInt(br.readLine());
    int d2 = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    int lca = lca(root, d1, d2);
    System.out.println(lca);
    // display(root);
  }

 

  
}














  






















 




 