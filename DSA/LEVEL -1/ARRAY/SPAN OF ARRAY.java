import java.io.*;
import java.util.*;
                               //span ka mtlb max-min
public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn=new Scanner (System.in);

   int n= scn.nextInt();
   int []arr=new int[n];//declaration of array
   for(int i=0;i<n;i++){
       arr[i]=scn.nextInt();//is se array ka input lete hai elements ka

   }
int min=Integer.MAX_VALUE;//ismey maximum number store kardo do jis se chota he milega number
int max=Integer.MIN_VALUE;//isme sabse chota number daal do or isse compare kar kar bda number milega

for(int i=0;i<n;i++){
    if(arr[i]>max){ //jaise he max se bda number milega store kardo
        max=arr[i];

    }
    if(arr[i]<min){//jaise he min se chota number milega store kardo
        min=arr[i];

    }
  
}
  int span=max-min;
    System.out.println(span);
    
 }

}
