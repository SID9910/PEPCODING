import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
         Scanner scn= new Scanner(System.in);
        int n=scn.nextInt();
        int[]arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();   //input lelo pehle
        }
        int target=scn.nextInt();
        //traverse left to right so start with 0 index
        System.out.print(firstIndex(arr,0,target));

    }

    public static int firstIndex(int[] arr, int idx, int x){
    if(idx == arr.length){
        return -1;
    }
       if(arr[idx]==x){
           return idx;
       }else{
           int t =firstIndex(arr, idx+1,x);
            return t;
       }


    }

}