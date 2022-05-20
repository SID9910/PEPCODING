         //approach-1
   //ye list globally bta dea hai humne
   List<Integer> list;
   public List<Integer> preorderTraversal(TreeNode root) {
       list=new ArrayList<>();
       preorder(root);
       return list;
   }
   
   public void preorder(TreeNode root){
       if(root==null){
           return; 
       }
       list.add(root.val);
       preorder(root.left);
       
       preorder(root.right);
   }