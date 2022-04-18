
import java.io.*;
import java.util.*;

public class Main {
   
 
//main code hai ye
 private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }
  public static void mirror(Node node){
    //mirror main call karo
    for(Node child:node.children){
      mirror(child);
    }
    //or reverse kar dega  har node ko ye Collections.reverse 
    Collections.reverse(node.children);

    //collection reverse ki alawa ye bhi kar sakte ho


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
  display(root);
  mirror(root);
  display(root);
}

}














  






















 