
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
//ye code sahi hai but working nhi hai
public static Node construct(Integer arr[]){

Stack<Pair> stack = new Stack<>();
 Node root =new Node();
 root.data =arr[0];
 
 Pair rootp = new Pair();
 rootp.node =root;
 rootp.state =1;

 stack.push(rootp);
 int idx =1;
 while(stack.size() >0){
Pair peekPair =stack.peek();
if(peekPair.state ==1){
    //left
    if(arr[idx]!= null){
        Node lc =new Node();
        lc.data =arr[idx];
        peekPair.node.left =lc;
        Pair lp =new Pair();
   lp.node =lc;
   lp.state =1;
   stack.push(lp);
       
    }
    peekPair.state++;
    idx++;
}else if (peekPair.state ==2){
    //right
    if(arr[idx]!= null){
        Node lr =new Node();
        lr.data =arr[idx];
        peekPair.node.right =lr;
        Pair ld =new Pair();
   ld.node =lr;
   ld.state =1;
   stack.push(ld);

}
peekPair.state++;
idx++;
 }else if (peekPair.state ==3){
     //pop
     stack.pop();
 }



}
  return root;
}



//
