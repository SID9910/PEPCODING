//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int M = Integer.parseInt(S[0]);
            int N = Integer.parseInt(S[1]);
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.primeRange(M, N);
            for (int i : ans) System.out.print(i + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    //leetcode -204 count primes or sieve of esthosesis algorithm
    ArrayList<Integer> primeRange(int M, int N) {
   
   
       ArrayList<Integer> res = new ArrayList<>();    
        boolean[] primes = new boolean[N+1]; //jitna n dea hua uska +1 ka root nikalna
        Arrays.fill(primes ,true);//start main sab true hai
        
        
        //ye dono primes nhi hai so inhe pehle false kardo
        primes[0] =false;
        primes[1] =false;
        
        //root taak chalega ye 
        for(int table =2 ;table*table<=N;table++){
            //aab table ki valye mille to usse false karo
            //mtlb root taak main se kisi ka table mille hta do use
            
            //iska mtlb jaab table ki value aagr hta di ho jaab baad main kisi or
            //table main vo same value mill rahi hai then bss continue karo mtlb skip eek tarah               se
            if(primes[table]== false){
                continue;
            }
            //table ka loop mtlb 2,4,6,8,10 so on
            for(int ja =table; table*ja<=N;ja++){
                primes[table*ja] =false; //value mille then false karo
            }
            
        }
        //basically jiske table main nhi honge vo bache honge 
        //so vo prime hai mtlb
        //bss true reh gay hai unhe count karlo
        int count=0;
        for(int i=M;i<=N;i++){
            if(primes[i] == true){
                res.add(i);
            }
        }
        return res;//count return 
        
    }
}
