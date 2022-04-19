
//are trees mirror
public static boolean areMirror(Node n1, Node n2) {
    if(n1.children.size()!=n2.children.size()){
    return false;
  }

  
//are trees mirror
 public static boolean areMirror(Node n1, Node n2) {
    if(n1.children.size()!=n2.children.size()){
    return false;
  }

  //child per he chalegi
  for(int i=0 ;i<n1.children.size();i++){
    Node c1 =n1.children.get(i);
    //ye last child se start hoga
    Node c2 =n2.children.get(n2.children.size()-1-i);
    if(areMirror(c1,c2)==false){
      return false;
    }
  
  
  }
  //aaagr uper se nhi milla mtlb true hai
  return true;
}
  public static boolean IsSymmetric(Node node) {
    // bss mirror call kardo
    return areMirror(node , node);
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
    boolean sym = IsSymmetric(root);
    System.out.println(sym);
    // display(root);
  }

   
  }

