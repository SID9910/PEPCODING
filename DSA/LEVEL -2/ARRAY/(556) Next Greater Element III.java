class Solution {
    public int nextGreaterElement(int n) {
        //basically hum ceil find out karna hai
        //mtlb given value se baadi and max se choti means integer.max se choti
        //nlog(n)
      //pehle string ko array main convert kar lenge
        char[] arr =(n +"").toCharArray();
        int i=arr.length-1;//akri se start karenge
        while(i>0){
            //check nums are in ascending order
            if(arr[i-1]>=arr[i]){
                i--;
            }//aagr bda milla then break
            else{
                break;
            }
            }
        //mtlb ki sare ascending order main pehle se hai
        //koi bda element nhi ho sakta
        if(i==0){
            return -1; //is se bda number nhi hai
        }
        int idx =i-1;//ye vo index hai jha ascending order main element jo nhi hoga
        int j=arr.length-1;
        while(j>idx){
            //aab compare kar rahe hai ki aagr idx ki value se 
            //last se koi bda milla to break kardo
            if(arr[j]>arr[idx]){
                break;
            }
            j--;
        }
        swap(arr,idx,j); //aab swap kardo jaise ye idx se badi value milli to
        int left =i; //isme element ko swap hokar jo milega
        int right =arr.length-1;
        //reverse kardo
        //i se akhri taak swap kardo
        while(left<right){
            swap(arr,left,right);
            left++;
            right--;
        }
        //vapis string main kardlo
        String res = new String(arr);
        long val =Long.parseLong(res); //long isley value baadi ko
                                    //kyuki question dea hua hai
        return (val > Integer.MAX_VALUE? -1: (int)val); //aagr integer se bhi baadi value then                                                           -1 because question dea hua hai
        
    }
    //swap function
     void swap(char[] arr ,int left , int right){
        char temp =arr[left];
        arr[left] =arr[right];
            arr[right] =temp;
    }
}