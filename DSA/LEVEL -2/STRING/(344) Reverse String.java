class Solution {
    public void reverseString(char[] s) {
        
        //approach-1 inplace -space-0(1) and tc=0(n)
        int i=0;
        int  j=s.length-1; //used for character 
        while(i<=j){
            char temp =s[i];
            s[i] =s[j];
            s[j]=temp;
            i++;
            j--;
        }
        
        //approach-2
        //but aachi nhi hzai approach 
        // tc=o(n) and space=0(n)
//         Stack<Character> st = new Stack<>();
    
//         for(int i = 0; i <s.length; i++){
//             st.push(s[i]);
//         }
//         char ans[] = new char[s.length];
//         int i = 0;
//         while(st.size() > 0){
//             char temp= st.pop();
//             s[i]=temp;
//             i++;
//         }
        
        //approach-3 ye approach chal nhi rahi
     //    String str = new String(s);
     //    ArrayList<String> s1 = new ArrayList<String>();
     // Collections.reverse(s1);
    }
}
