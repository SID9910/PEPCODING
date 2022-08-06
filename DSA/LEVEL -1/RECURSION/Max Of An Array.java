import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=scn.nextInt();
        }
        int max1 =maxOfArray(arr,0);
        System.out.println(max1);
    }

    public static int maxOfArray(int[] arr, int idx){
    if(idx ==arr.length){
        return Integer.MIN_VALUE;
    }       
    int max3 =maxOfArray(arr,idx+1);
    int tuk =Math.max(max3,arr[idx]);
    return tuk;
 


    }

}