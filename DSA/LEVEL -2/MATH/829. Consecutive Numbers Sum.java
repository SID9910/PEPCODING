class Solution {
    public int consecutiveNumbersSum(int n) {
        int res =0;//total possibilites isme
        int k=1;
        int check =k*(k-1)/2;//condition 
        while(check<n){
            if((n-check)%k==0){ //ye mtlb ki start point mill rha hai then res++
                res++;
            }
            k++;//nai iteration start karo jaab taab kya check aab n se chota hai
            check =k*(k-1)/2;//dubara aage se chalu hoga aab nai k se
        }
    return res;    //sari posibilites aajaegi
    }
    
}