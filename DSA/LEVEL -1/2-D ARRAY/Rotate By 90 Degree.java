import java.io.*;
import java.util.*;

//logic ye hai ki pehle matrix ka transpose lenge fhir uski columns ko swap karenge

public class Main {
 
 //ye matrix ke ander ke elements ko swap karne ka function hai  
public static void swapnum(int[][]arr ,int i,int j){
 //transpose karega (i,j) ko (j,i)se
 int temp=arr[i][j];
 arr[i][j]=arr[j][i];
 arr[j][i]=temp;
}


 //ye matrix ka tranpose lene ka function hai
public static void transporse(int[][]arr){
    for(int i=0;i<arr.length;i++){
        for(int j=i;j<arr[0].length;j++){    //ye logic  hai transpose lene ka 
                                           // j=i or j=i+1 bhi kar sakte hai use se
                                           // uper vala
                                           //triangular matrix swap kar sakte hai eek illetration aage
                                           //kyuki j=i se diagonal bhi swap hoga jo ki
                                            // same he rehne vala hai
            swapnum(arr,i,j); //swap ho rahe hai elements
        }
    }
}
//swapnum ki method overloading kar di hai
//ye swap function column ko swap karne main help karega

public static void swapnum(int[][]arr,int i,int left,int right){ //column ko swap karega
    int temp=arr[i][left];
    arr[i][left]=arr[i][right];
    arr[i][right]=temp;
} 

//ye column ko swap karne ka function hai 
//jaise hamne pehle kara hai tha reverse of an array main 
public static void swapcolumn(int[][]arr){
   int left=0,right=arr[0].length-1;
    while(left<right){
       for(int i=0;i<arr.length;i++){
        swapnum(arr,i,left,right);}
        left++;
        right--;
    }
}  





    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        
        int[][]arr=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
           arr[i][j]=scn.nextInt();
            }
        }


  transporse(arr);//pehle ye call hoga fhir swapcolumn hoga
  swapcolumn(arr);//ise se column swap ho jaenge

  display(arr);//akhri main display ho jaega array


    }

    
    
    
    
    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}