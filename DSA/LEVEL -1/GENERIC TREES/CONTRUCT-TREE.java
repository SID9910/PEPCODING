import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  //aasal main contruct ye code chalega nhi kyuki saare code main construct pehle se he bana hua hai
  //taaki array paas karenge to tree dega vo fhir haam use karenge sabke ley us tree ko

  public static Node construct(int[] arr) {
Node root = null;
Stack<Node> stack = new Stack<>();

for(int val: arr){
  if(val!=-1){
    Node node = new Node(val);
    stack.push(node);
  }
  else{
    Node node = stack.pop();
    if(stack.size()>0){
      Node parent = stack.peek();
      parent.children.add(node);

    }else{
      root=node;
    }
  }
}
return root;
  }

  public static int size(Node node) {
    int s = 0;

    for (Node child : node.children) {
      s += size(child);
    }
    s += 1;

    return s;
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
    Construct(root);
  }

}


































