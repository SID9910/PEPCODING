
import java.io.*;
import java.util.*;

public class Main {
   
 
//main code hai ye
 private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  //display a generic tree
public static void display(Node node){
    //aaagr node null hui to ye reutn kar denge bss
     if(node == null){
       return;
     }
     //aao pehle or root ko print kardo
  System.out.print(node.data+ "->");
  //aanb root ke childrens ko print kardo
  for(Node child: node.children){
    System.out.print(child.data +" ,");
 
  }
 
  System.out.println(".");
  //aaab children per loop lagaoo then fhir uper node vale ki 
  //tarah children print honge and children ke children print honge
   for(Node child: node.children){
    display(child);
 
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
  }

}














  











