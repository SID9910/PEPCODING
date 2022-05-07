import java.io.*;
import java.util.*;

public class Main {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }

  public static int height(Node node) {
    if (node == null) {
      return -1;
    }

    int lh = height(node.left);
    int rh = height(node.right);

    int th = Math.max(lh, rh) + 1;
    return th;
  }

 static class DiaPair{
  
   int height =-1;
  int dia =0;

 }
 //approach-1
//main code
 static int dia =0;
  public static int diameter1(Node node) {
    if(node ==null){
      return -1;
    }
    int leftHeight = diameter1(node.left );
    int rightHeight = diameter1(node.right);
    int ht =Math.max(leftHeight ,rightHeight)+1;
    if(leftHeight+rightHeight+2 >dia){
      dia =leftHeight+rightHeight+2;
    }
    return ht;
  }

  //approach-2
//main code
 static class DiaMover{
   int dia =0;

 }
  public static int diameter2(Node node ,DiaMover dm) {
    if(node ==null){
      return -1;
    }
    int leftHeight = diameter2(node.left ,dm);
    int rightHeight = diameter2(node.right, dm);
    int ht =Math.max(leftHeight ,rightHeight)+1;
    if(leftHeight+rightHeight+2 >dm.dia){
      dm.dia =leftHeight+rightHeight+2;
    }
    return ht;
  }


 //approach -3
 //main code 
  public static DiaPair diameter3(Node node ) {
    if(node == null){
    DiaPair bs =new DiaPair();
    
    bs.height =-1;
    bs.dia =0;
    return bs;
    }
    DiaPair leftPair = diameter3(node.left);
    DiaPair rightPair = diameter3(node.right);

DiaPair mp =new DiaPair();
mp.dia = Math.max(leftPair.height+rightPair.height + 2 ,Math.max(leftPair.dia,rightPair.dia));
mp.height =Math.max(leftPair.height ,rightPair.height)+1;


    return mp;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    Node root = construct(arr);

    // int ht= 0;
    // ht = diameter1(root);
    // System.out.println(dia);

    // DiaMover dm =new DiaMover();
    // diameter2(root ,dm);
    // System.out.println(dm.dia);

DiaPair dp =diameter3(root);
System.out.print(dp.dia);

  }

}