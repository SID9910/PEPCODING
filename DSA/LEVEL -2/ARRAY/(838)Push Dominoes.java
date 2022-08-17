class Solution {
    public String pushDominoes(String dominoes) {
       //kya karo previous main l and r add kardo us se special
        //case handle ho jaenge and l and r add karne se dominoes per koi effect bhi nhi padega
        dominoes ="L"+dominoes+"R";
        
        char[] arr =dominoes.toCharArray();//character array main karlo
        
        //act as previous index
        int pi =0;
        //1 se chalenge loop
        for(int i=1;i<arr.length;i++){
            
            //aagr pehle he left hua to mtlb pehle ke left honge saare
            if(arr[i] == 'L'){
                if(arr[pi]=='L'){  //case-1 LL aagr ho
                    for(int x =pi+1;x<i;x++){
                        arr[x] ='L'; //bich ke main L daal do
                    }
                    //agr LR mille then jo pehle pohocha usse milega
                }else if(arr[pi] == 'R'){
                    int lo = pi+1;
                    int hi =i-1;
                    //is loop se bich main even ho ya ood dono handle ho jaenge
                    //aagr even hue barbar bharenge
                    //agr odd hue to bich ka nhi bharega baaki ke  bhar jaenge
                    //means jo bich main nhi bhara hoga vo stable hai
                    while(lo<hi){
                        arr[lo] ='R';
                        arr[hi] ='L';
                        lo++;
                        hi--;
                        
                    }
                    
                    }
                pi=i; //agla index ke ley aab
            }//aagr start r hota taab
            else if(arr[i] =='R'){
                if(arr[pi]=='L'){
                    //do nothing  //isme dono eek dusre ko impact nhi kar rahe
                }else if(arr[pi] =='R'){ //jaab rr ko means bich ke rr honge
                    for(int x =pi+1;x<i;x++){
                        arr[x]='R';
                    }
                }
                pi=i;
            }
        }
        StringBuilder sb = new StringBuilder(); //aagr char main ho then sb main daal lo
        //loop main previous ko consider nhi karenge
        //to hum bss 1 se arr,length-1 taab chalenge
        for(int i=1;i<arr.length-1;i++){
            sb.append(arr[i]);
        }
        return sb.toString(); //vapis char array ko string main karke return 
    }
}