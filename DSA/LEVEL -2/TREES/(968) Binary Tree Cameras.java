/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count =0;//isme saara camera ka count aaega
    //final hum isley lete hai kyuki ye fix kar deta hai value
    final int camera =1;
    final int MONITOR =2; //monitor ko camera karega unmonitor ko
    //monitor ka mtlb count ho jya hai camnera ke duvara
    final int UN_MONITOR =3;
    public int minCameraCover(TreeNode root) {
        int val =helper(root);//value aajaegi isme
       // aaagar root unmonitor return hoga to uske agge camera lga dena and count kar lo
        //uska camera
        if(val ==UN_MONITOR){
            count++;
         
        }
       return count;
    }
    public int  helper(TreeNode node){
       //aagar node null hai use hum monitor mante hai
        if(node ==null){
            return MONITOR;
        }
        
        int left =helper(node.left);
        int right =helper(node.right);
        //isme sare umonitor ke cases covere ho jaene
        //mtlb jha bhi unmonitor mille udher camera lga do
        //and camera lga do
        if(left ==UN_MONITOR || right ==UN_MONITOR){
           count++;
           return camera;
       }
        //isme sare camera cases cover ho jaenge
        //aagr camera lga mille to monitor kardo return
       else if(left == camera || right ==camera){
            return MONITOR;
        } 
      //isme sare monitor ke cases cover ho jaenge
        else{
            return UN_MONITOR;
        }
    }
}