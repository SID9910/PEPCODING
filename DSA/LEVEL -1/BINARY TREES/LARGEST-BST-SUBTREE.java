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

  static class lbst{
    int min;
    int max;
    boolean isbst;
    int size;
    Node root;
  }
  public static lbst largestbst(Node node){
    if(node == null){
      lbst bs = new lbst();
      bs.min =Integer.MAX_VALUE;
      bs.max =Integer.MIN_VALUE;
      bs.isbst =true;
      bs.size =0;
      return bs;

    }
lbst leftbst = largestbst(node.left);
lbst rightbst = largestbst(node.right);

lbst mp = new lbst();
mp.isbst = leftbst.isbst && rightbst.isbst &&(node.data >=leftbst.max && node.data<=rightbst.min);
mp.min=Math.min(node.data ,Math.min(leftbst.min ,rightbst.min));
mp.max =Math.max(node.data ,Math.max(leftbst.max ,rightbst.max));

if(mp.isbst){
  mp.root =node;
  mp.size =leftbst.size+rightbst.size+1;

}
else if(leftbst.size>rightbst.size){
  mp.root =leftbst.root;
  mp.size =leftbst.size;
}
else {
  mp.root =rightbst.root;
  mp.size =rightbst.size;
}

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
    
    lbst lb =largestbst(root);
    System.out.print(lb.root.data + "@"+ lb.size);
  }

}