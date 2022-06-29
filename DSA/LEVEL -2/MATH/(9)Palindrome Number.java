class Solution {
    public boolean isPalindrome(int x) {
        int ans =0;
        int n=x;
        
        while(x>0){
            int d = x%10;
            ans=ans*10+d;
            x=x/10;
        }
        if(ans==n){
            return true;
        }
        else{
            return false;
        }
    }
}

