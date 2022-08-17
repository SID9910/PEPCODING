import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
       
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
    
        for(int i = 0; i < n; i++){
           arr[i] = Integer.parseInt(br.readLine());
        }

        int tar = Integer.parseInt(br.readLine());
        printTargetSumSubsets(arr, 0, "", 0, tar);

    }

    public static void printTargetSumSubsets(int[] arr, int idx, String set, int sos, int tar) {
        if(sos > tar){
            return;
        }
        if(idx ==arr.length){
            if(sos ==tar){
                System.out.println(set+".");
            
            }
            return;
        }


        //jab add hoga
        printTargetSumSubsets(arr ,idx+1,set+arr[idx]+", " ,sos+arr[idx] ,tar);
       //jaab add nhi hoga
        printTargetSumSubsets(arr ,idx+1,set ,sos ,tar);

    }

}