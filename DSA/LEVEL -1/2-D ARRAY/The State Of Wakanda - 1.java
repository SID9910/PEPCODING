import java.io.*;
import java.util.*;

public class Main{
//eek function banao wave traversal ka
    public static void wavetraversal(int[][]arr){
        int n=arr.length;//ye hai no of rows ka
        int m=arr[0].length;//ye hai no of columns ka

        for(int column=0;column<m;column++){ //hamm column to column traverse kar rahe hai
           
                if(column%2==0){ //ye logic hai aaagr column even hui to top to bottom jana hai
                     for(int rows=0;rows<n;rows++){
                         System.out.println(arr[rows][column]);
                     }
                }
                else{ //ye logic hai aaagr odd hua to haam bottom to top jaega
                    for(int rows=n-1;rows>=0;rows--){
                        System.out.println(arr[rows][column]);
                    }
                }
            
            
        }
    }

public static void main(String[] args) throws Exception {
    Scanner scn=new Scanner(System.in);
    int n=scn.nextInt();
    int m=scn.nextInt();
    int[][]arr=new int[n][m];

    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            arr[i][j]=scn.nextInt();
        }
    }
    wavetraversal(arr); //ye hai call of function

 }

}