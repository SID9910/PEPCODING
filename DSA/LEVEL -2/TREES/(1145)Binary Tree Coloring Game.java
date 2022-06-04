
class Solution {
    //question- hum player1 and player2 ke pass check karna chahenge ki kaun jada nodes cover //kar sakta hai and players bss aapni adjacent node per he ja sakte hai size ke ley
    //jisne akhri main jada subree ka size ghera hua hoga vo jeet jaega
    
    
    //solution
    //is quetion main x hamara 3 hai jo player 1 hai .hum pehle player 1 ke aasa pass ke nodes //ka size nikal lenge and xleftsize and xright main store kar lenge node 3 ke niche ka size
    // and total main se 3 ke niche ka size minus kar denge us se sabse bada subree ka size //mil jaega and fhir tinno subree ka size compare karenge .and fhir total se minus karke 
    //dekhenge and rest main store kar denge and check karenge aaagr maxtrree ka size rest se
    //bda hua mtlb player 2 jada jagah ja sakta hai and jeet sakta hai.then true return kardo
    
    int xleftsize =0;
    int xrightsize =0;
    public int size(TreeNode node ,int x){
        if(node ==null){
            return 0;
        }
        int leftsize =size(node.left ,x);
        int rightsize =size(node.right, x);
       int ts=leftsize+rightsize+1;
        if(node.val ==x){
            xleftsize =leftsize;
            xrightsize =rightsize;
        }
        return ts;
    }
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        size(root,x);
        int othersize =n -(xleftsize+xrightsize+1);
        int mathsize =Math.max(othersize ,Math.max(xleftsize,xrightsize));
        int rest =n-mathsize;
        if(mathsize >rest){
            return true;
        }
        else{
            return false;
        }
    }
}