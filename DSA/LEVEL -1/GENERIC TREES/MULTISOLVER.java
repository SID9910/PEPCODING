
  //way-1

Static int sum=0;
Static int max =Integer.MIN_VALUE;
Static int min =Integer.MAX_VALUE;
Static int height =-1;

public static void multisolver(Node node , int depth){
    sum+=node.data;
    if(node.data>max){
        max= node.data;
    }
    if(node.data<min){
        min =node.data;
    }
    if(depth>height){
        height=depth;
    }

    for(Node child:node.children){
        multisolver(child ,depth+1);
    }
}


// way-2
public static class HeapMover{
 int sum=0;
 int max =Integer.MIN_VALUE;
 int min =Integer.MAX_VALUE;
 int height =-1;
}

public static void multisolver2(Node node , int depth,HeapMover mover){
    mover.sum+=node.data;
    if(node.data>mover.max){
        mover.max= node.data;
    }
    if(node.data<mover.min){
        mover.min =node.data;
    }
    if(depth>mover.height){
        mover.height=depth;
    }

    for(Node child:node.children){
        multisolver2(child ,depth+1,mover);
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

    //way-1
    Node root = construct(arr);
    
    multisolver(root ,0);
    System.out.println("sum"+sum);
    System.out.println("max"+max);
    System.out.println("min"+min);
    System.out.println("height"+height);

    //way-2
    HeapMover mover = new HeapMover();
    multisolver2(root ,0,mover);
    System.out.println("sum"+mover.sum);
    System.out.println("max"+mover.max);
    System.out.println("min"+mover.min);
    System.out.println("height"+mover.height);  
  
  }

   
  }

