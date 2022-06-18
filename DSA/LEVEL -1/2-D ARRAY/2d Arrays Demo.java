import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn=new Scanner(System.in);
    int rows=scn.nextInt();
    int column=scn.nextInt();

    int [][]arr=new int[rows][column];//syntax of 2d array

    for(int i=0;i<rows;i++){
        for(int j=0;j<column;j++){//input aaise lete hai
            arr[i][j]=scn.nextInt();
        }
    }

 for(int i=0;i<rows;i++){
        for(int j=0;j<column;j++){
            System.out.print(arr[i][j]+" "); //outpu aaega
        }
        System.out.println();
    }






 }

}