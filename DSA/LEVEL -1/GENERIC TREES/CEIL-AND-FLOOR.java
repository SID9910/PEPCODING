// way-1
  
  static int ceil=Integer.MAX_VALUE;
  static int floor=Integer.MIN_VALUE;
  public static void ceilAndFloor(Node node, int data) {
    if(node.data>data){
   if(node.data<ceil){
     ceil= node.data;
   }
       }

  if(node.data<data){
    if(node.data>floor){
      floor =node.data;
    }
  }

  for(Node child:node.children){
    ceilAndFloor(child ,data);

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

    int data = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    ceil = Integer.MAX_VALUE;
    floor = Integer.MIN_VALUE;
    ceilAndFloor(root, data);
    System.out.println("CEIL = " + ceil);
    System.out.println("FLOOR = " + floor);
  }

//   way-2
  
public static class CfMover{
     int ceil=Integer.MAX_VALUE;

    int floor=Integer.MIN_VALUE;
}
public static void ceilAndFloor2(Node node, int data ,CfMover mover) {
  if(node.data>data){
 if(node.data<mover.ceil){
   mover.ceil= node.data;
 }
     }

if(node.data<data){
  if(node.data>mover.floor){
    mover.floor =node.data;
  }
}   

for(Node child:node.children){
  ceilAndFloor2(child ,data, mover);

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

  int data = Integer.parseInt(br.readLine());

  Node root = construct(arr);
 CfMover mover = new CfMover();
  ceilAndFloor2(root, data ,mover);
  System.out.println("CEIL = " + mover.ceil);
  System.out.println("FLOOR = " + mover.floor);
}