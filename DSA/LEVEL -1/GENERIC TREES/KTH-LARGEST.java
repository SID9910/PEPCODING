  
 //calling ceil and floor
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

  //kth largest 

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    int k = Integer.parseInt(br.readLine());

    Node root = construct(arr);
   int kthlargest= Integer.MAX_VALUE;
   for(int i=0 ;i<k ;i++){
     ceilAndFloor(root, kthlargest);
     kthlargest =floor;
     floor =Integer.MIN_VALUE;
     
   }
   System.out.println(kthlargest);
  }
