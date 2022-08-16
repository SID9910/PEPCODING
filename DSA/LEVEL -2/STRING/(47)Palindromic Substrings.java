class Solution {
    //level-1  string question 
    
    //approach-1 tc=0(n2) i guess
    public boolean isPalindrome(String str){
      boolean flag =true;
        int left =0;
        int right =str.length()-1;
        while(left<right){
            if(str.charAt(left)!=str.charAt(right)){
                flag = false;
                break;
            }
            left++;
            right--;
        }
        return flag;
        
    }
    int count =0;
    public int countSubstrings(String s) {
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                String substr = s.substring(i,j);
                if(isPalindrome(substr)==true){
                    count++;
                }
            }
        }
    return count;
    }
    
}