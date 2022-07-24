class Solution {
    public String reverseVowels(String s) {
        //bss check karo ye ho taab swap hoga
    String check="aeiouAEIOU";
        StringBuilder sb = new StringBuilder(s);
        int left =0;
        int right =s.length()-1;
        while(left<right){
            //aagar consonents milenge normal travel karenge
            while(left<right && check.indexOf(sb.charAt(left))==-1){ //mtlb vowels nhi mille then bss aage bado
                left++;
            }
            //same right main bhi vowels  na mille to bss baadao pointer 
            while(left<right && check.indexOf(sb.charAt(right))==-1){
                right--;
            }
            //vowels mill jay to bss swap kardo
            char temp =sb.charAt(left);
            sb.setCharAt(left,sb.charAt(right));
            sb.setCharAt(right,temp);
            left++;
            right--;
        }
        return sb.toString();
    }
}