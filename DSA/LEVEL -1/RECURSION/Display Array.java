import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n=scn.nextInt();
        int[]arr=new int[n];
        
        for(int idx=0;idx<n;idx++){

            arr[idx]=scn.nextInt();  //array ka input lelo
        }
        displayArr(arr,0);

    }

    public static void displayArr(int[] arr, int idx){
     if(idx==arr.length){
         return;
     }
     System.out.println(arr[idx]);
     displayArr(arr,idx+1);
    }

}