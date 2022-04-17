import java.io.*;
import java.util.*;

public class Main {
   
 
//main code hai ye
 private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }
  public static void levelOrderLinewise(Node root){
    Queue<Node> queue = new ArrayDeque<Node>();
    Queue<Node> cqueue =new ArrayDeque<Node>();

     queue.add(root);
      
    while(queue.size()>0){
          ////method call -rpa(remove,print,add)
        //is se pehle root ko remove hoga uper add kara tha na.bss eek bar ke ley 
        //fhir print karenge .then hum childen ko add karegenge and rpa follow karenge
        //jaab taak loop chalega taab taak hoga kaam and queue ko current queue se badal denge jaab queue khali hogi
        //and cqueue main children add karte jaege
      Node temp=queue.remove();
      System.out.print(temp.data + " ");
      for(Node child : temp.children ){
        cqueue.add(child);
      }
      if(queue.size() == 0){
        queue=cqueue;
        cqueue= new ArrayDeque<>();
        System.out.println();
      }

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
    levelOrder(root);
  }

}














  