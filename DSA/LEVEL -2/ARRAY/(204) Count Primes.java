class Solution {
    //most imp
    //seive of escothesis algorithm gfg
    public int countPrimes(int n) {
        
      //aagr number 2 se mtlb to return karo bss
        if(n<2){
            return 0;
        }  
        boolean[] primes = new boolean[n+1]; //jitna n dea hua uska +1 ka root nikalna
        Arrays.fill(primes ,true);//start main sab true hai
        
        
        //ye dono primes nhi hai so inhe pehle false kardo
        primes[0] =false;
        primes[1] =false;
        
        //root taak chalega ye 
        for(int table =2 ;table*table<=n;table++){
            //aab table ki valye mille to usse false karo
            //mtlb root taak main se kisi ka table mille hta do use
            
            //iska mtlb jaab table ki value aagr hta di ho jaab baad main kisi or
            //table main vo same value mill rahi hai then bss continue karo mtlb skip eek tarah               se
            if(primes[table]== false){
                continue;
            }
            //table ka loop mtlb 2,4,6,8,10 so on
            for(int ja =table; table*ja<=n;ja++){
                primes[table*ja] =false; //value mille then false karo
            }
            
        }
        //basically jiske table main nhi honge vo bache honge 
        //so vo prime hai mtlb
        //bss true reh gay hai unhe count karlo
        int count=0;
        for(int i=0;i<primes.length-1;i++){
            if(primes[i] == true){
                count++;
            }
        }
        return count;//count return 
        
    }
}