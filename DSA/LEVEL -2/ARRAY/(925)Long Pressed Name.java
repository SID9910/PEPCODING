class Solution {
    public boolean isLongPressedName(String name, String typed) {
     int i=0;//typed ko traverse karega
     int j=0;//name ko traverse karega
        
        //typed bda hoga isley isko chalenge
        while(i<typed.length()){
            //name bhi bss bacha rehna chaheye
            if(j<name.length() && typed.charAt(i) ==name.charAt(j)){
                //bss aage bdate jao
                i++;
                j++;
                
            }//i>0 hona chahaye taaki negative main na jay
            else if(i>0 && typed.charAt(i) ==typed.charAt(i-1)){
                i++;//bss typed ko eek aage bda do
            }
            else{
                //agr uper vali condition invalid then 
                return false;
            }
        }
        return j == name.length();//aagr uper loop chalne ke baad bhi j pura traverse means
                               //name traverse hogya then true return mtlb typed pura chal gya
                              //and j khatam bhi hua pura chalne ke baad.
    }
}