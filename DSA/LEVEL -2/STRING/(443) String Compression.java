class Solution {
    //tc =o(n)
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        
        int count =1;
        
        for(int i=0;i<chars.length-1;i++){
            if(chars[i]==chars[i+1]){
                count++;
            }else{
                
                sb.append(chars[i]);
                if(count>1){
                sb.append(count);
                count=1;
                }
            }
            
        }
        sb.append(chars[chars.length-1]);
        
        if(count>1){
            sb.append(count);
        }
        //store karo words
       for(int i=0;i<sb.length();i++)
        {
            chars[i]=sb.charAt(i);
        } 
        //return length karo 
        return sb.length();
    }
}