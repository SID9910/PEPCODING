class Solution {
    public boolean isValid(String s) {
        //tc-o(N) space =o(n)
        Stack<Character> stack = new Stack<>();
        for(int i=0 ;i<s.length();i++){
           char a = s.charAt(i);//character le ley
            
            //aagr opening brackets hai to  bss add karo
            if(a == '(' || a == '{' || a == '[') {
                stack.push(a); 
            }else{ //agr stack khali hui return false
                if(stack.isEmpty()){
                    return false;
                }//aab check karo stack ke top main vo closing brackets ke baraber nhi to return                 //fale 
                else if(a == ')' && stack.peek() != '(') {
                    return false;}
            else if(a == ']' && stack.peek() != '['){ 
                return false;}
            else if(a == '}' && stack.peek() != '{'){ return false;
            }//agar top ke barbar hua to pop kardo
                else{
                stack.pop();
            }
         }
    } //agar akhri taak stack khali hui to mtlb true hai
        return stack.isEmpty();//true if it is true
}
}

        
           