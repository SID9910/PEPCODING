
import java.io.*;
import java.util.*;

public class Main {
   
 
//main code hai ye
 private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  //TRAVERSAL KA CODE (PRE-ORDER AND POST-ORDER)
  public static void traversals(Node node){
    //Node pre
    System.out.println("Node Pre "+node.data);

    for(Node child: node.children){
      //Edge pre
      System.out.println("Edge Pre "+node.data+"--"+child.data);
      traversals(child);
      //Edge post
      System.out.println("Edge Post "+node.data+"--"+child.data);
    }
    //Node post
    System.out.println("Node Post "+node.data);
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
    traversals(root);
  }

 


}









