// way-1
static int largest = Integer.MIN_VALUE;
static int slargest = Integer.MIN_VALUE;
  public static void secondLargest(Node node){
   if(node.data>largest){
     slargest =largest;
     largest =node.data;
   }
  else if(node.data>slargest){
     slargest =node.data;
   }
   for(Node child :node.children){
     secondLargest(child);
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
    //display(root);
    secondLargest(root);
    System.out.println(largest);
    System.out.println(slargest);
   // display(root);
  }

//   way-2

public static class MoverForSecondLargest{
    int largest = Integer.MIN_VALUE;
    int slargest = Integer.MIN_VALUE;
}

  public static void secondLarges2t(Node node,MoverForSecondLargest mover){
   if(node.data>mover.largest){
     mover.slargest =mover.largest;
     mover.largest =node.data;
   }
  else if(node.data>mover.slargest){
     mover.slargest =node.data;
   }
   for(Node child :node.children){
     secondLargest(child ,mover);
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
    MoverForSecondLargest mover =new MoverForSecondLargest();

    //display(root);
    secondLargest2(root);
    System.out.println(mover.largest);
    System.out.println(mover.slargest);
   // display(root);
  }

