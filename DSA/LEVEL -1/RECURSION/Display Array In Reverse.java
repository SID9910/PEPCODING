import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[]arr=new int[n];
        
        for(int idx=0;idx<n;idx++){

            arr[idx]=scn.nextInt();  //input array
        }
        
        displayArrreverse(arr,0);
        
        
        
        
            }

    public static void displayArrreverse(int[] arr, int idx){
        if(idx==arr.length){   //same as display array
            return;
        }
displayArrreverse(arr,idx+1); //pehle call
System.out.println(arr[idx]);//fhir print bss same as display array



    }

}