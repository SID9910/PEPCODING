import java.io.*;
import java.util.*;

public class Main{

 public static int linearsearch(int[]arr,int element){ //decleration
     for(int index=0;index<arr.length;index++){
         if(arr[index]==element){  //aaagr element present hua to arr[i]ke baarabar aaega to return index ho jaega
             return index;   //index return kara rahe hai

         }

     }
     return -1;//aaagr loop nhi chalega to return -1 karenge
 }   


public static void main(String[] args) throws Exception {
    Scanner scn=new Scanner(System.in);
     int n=scn.nextInt();    
    int []arr=new int[n];
    for(int i=0;i<n;i++){
        arr[i]=scn.nextInt();


    }
    int element=scn.nextInt();
    System.out.println(linearsearch(arr,element));//function call

 }

}