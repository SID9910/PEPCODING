class Solution {
    //again practice difficult
    public int maximumSwap(int num) {
        //pehle isse character array main karlo
        char[] arr = (num+ "").toCharArray();
        int[] right = new int[arr.length];//right ki length normal array ki tarah same hogi
        //loop ulta chalao
        for(int i=arr.length-1; i>=0;i--){
            //right main last se store karna chalu karenge
            if(i==arr.length-1){
                right[i]=-1;//last index -1 daal do
            }else if(i==arr.length-2){
                //last second value 
                //last vali daal do
                right[i] =arr.length-1;//last second index daal do isme
                
            }else{
                //main kaam imp 
                //hum aab check karenge ki arr[i+1] ki value mtlb arr ki last second
                //value aagr niche right value ke i+1 se aagr baadi hui then vo index daal 
                //do 
                if(arr[i+1]>arr[right[i+1]]){
                    right[i]=i+1;
                }else{
                    //agar uper vali false then bss normal purani vali index daal do
                    right[i] =right[i+1];
                }
            }
        }
        //bss aab compare karo
        //right ko normal se 
        //jonsa  chota mile normal se then swap and break
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]<arr[right[i]]){
                char temp =arr[i];
                arr[i] =arr[right[i]];
                arr[right[i]] =temp;
                break;
            }
        }
        return Integer.parseInt(new String(arr));//bss vapis return karo arr ki form main
    }
}