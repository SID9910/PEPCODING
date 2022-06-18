import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[][]arr=new int [n][n]; // n he number of rows and column hai
                                  //aaise logic bss square matrix main use hota hai

  for(int i=0;i<n;i++){
      for(int j=0;j<n;j++){
          arr[i][j]=scn.nextInt();
      }
  }


//idher jo n lea hai vo number of column hai
//gap=j-i
  for(int gap=0;gap<n;gap++){ 

  //inner loop main jo n lea hai vo bhi no of column ko represent kar rha hai
   for(int i=0,j=gap+i;j<n;i++,j++){
    System.out.println(arr[i][j]);
}

  }




    }

}