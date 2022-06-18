import java.io.*;
import java.util.*;

public class Main{
   //display function   
    public static void display(int[][] arr){

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }


public static void main(String[] args) throws Exception {
    Scanner scn=new Scanner(System.in);
    int n1=scn.nextInt();
    int m1=scn.nextInt();
    int [][]matrix1=new int[n1][m1];

    for(int i=0;i<n1;i++){    
        for(int j=0;j<m1;j++){
            matrix1[i][j]=scn.nextInt();   //matrix1 ka input lena 
        }
    }

 int n2=scn.nextInt();
    int m2=scn.nextInt();
    int [][]matrix2=new int[n2][m2];

    for(int i=0;i<n2;i++){
        for(int j=0;j<m2;j++){
            matrix2[i][j]=scn.nextInt();   //matrix2 ka input lena
        }
    }

    if(m1!=n2){
        System.out.println("Invalid input");  //ye condition m1=n2 hona chaheye for matrix
                                              //multiplication
    return;

    }

    int[][] res=new int[n1][m2]; //resultant array

    for(int i=0;i<res.length;i++){
        for(int j=0;j<res[0].length;j++){
            for(int k=0;k<m1;k++){  //m1==n2 dono main se kuch bhi le sakte hai
                               //k loop isley chahaya hai taaki m1 ya n2 ke barabar multiply karega
          res[i][j]+=(matrix1[i][k])*(matrix2[k][j]); //ye matrix ka logic hai
            }

        }
    }

      display(res); //call of display function 




 }

}