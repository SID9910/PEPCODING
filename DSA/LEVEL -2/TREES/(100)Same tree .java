
//ye eek bar or karna hai khud se

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return findAns(p,q);
    }
    public boolean findAns(TreeNode p, TreeNode q){
        if((p == null && q != null) || (p != null && q == null)){
            return false;
        }
        if(p == null && q == null){
            return true;
        }
        if(p.val != q.val){
            return false;
        }
        if(!findAns(p.left, q.left)){
            return false;
        }
        if(!findAns(p.right, q.right)){
            return false;
        }
        return true;
    }
}