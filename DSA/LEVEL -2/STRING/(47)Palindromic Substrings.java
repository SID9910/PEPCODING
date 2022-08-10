class Solution {
    //level-1  string question 
    
    //approach-1 tc=0(n2) i guess
    public boolean isPalindrome(String str){
        int left =0;
        int right =str.length()-1;
        while(left<right){
            if(str.charAt(left)!=str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
        
    }
    int count =0;
    public int countSubstrings(String s) {
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                String substr = s.substring(i,j+1);
                if(isPalindrome(substr)==true){
                    count++;
                }
            }
        }
    return count;
    }
    
}