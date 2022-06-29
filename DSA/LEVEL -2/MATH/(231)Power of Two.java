class Solution {
    public boolean isPowerOfTwo(int n) {
     int count=0;
        int t=n;
    while(n!=0){
         int d =n/2;
         count++;
         n=d;
     }
        if(Math.pow(2,count-1)==t){
           return true;
       } 
        else{
            return false;
        }
    }
}