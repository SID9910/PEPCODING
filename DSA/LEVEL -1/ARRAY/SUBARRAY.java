import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    
Scanner scn=new Scanner(System.in);
int n=scn.nextInt();
int[] arr=new int[n];
for(int i=0;i<n;i++){
    arr[i]=scn.nextInt();
}

for(int start=0;start<n;start++){  //outer loop hamara end taak jana ka kaam karega
for(int end=start;end<n;end++){  //ye end start ko start se or end taak jaega
    for(int i=start;i<=end;i++){  //ye vala loop start se chalega or end taak chalega 
                                  //bss jha taak end ki value di ho gi
        System.out.print(arr[i] +"\t"); //element print hoga 

    }
    System.out.println(); //spaces print karne ke ley
}
}




 }


}