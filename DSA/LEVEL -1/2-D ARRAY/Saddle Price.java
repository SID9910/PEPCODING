import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
    Scanner scn=new Scanner(System.in);
    int n=scn.nextInt();

    int[][]mat=new int[n][n];
//input of matrix
for(int i=0;i<n;i++){
    for(int j=0;j<n;j++){
        mat[i][j]=scn.nextInt();
    }
}

//outer loop hamara sari rows ko traverse karega taaki kis row per minimum ho row
//ka and column ka max ho udher se saddle point le
for(int i=0;i<mat.length;i++){

//ye logic hai ki starting column ka index lenge .or use se campare karenge
//taaki vo sab column ke index se chota rahe.aaagr aaisa hua to  uss row ka
//minumum pta chal jaega  
    int mincol=0;//intial index zero karenge
    for(int j=0;j<mat[0].length;j++){ //ye column per chalega logic
    //jaise he column ke zero index se or choti value milli to store ho jaegi vo

        if(mat[i][j]<mat[i][mincol]){  
            mincol=j;//sabse choti value store hogi
        }
}

//ye logic column ka max nikalega .row ko traverse karke 

 int maxrow=0;//is index ko max kara hai
  for(int k=0;k<mat.length;k++){  //row traverse karke column nikalega
      if(mat[k][mincol]>mat[maxrow][mincol]){ //jaise he max value milegi 
          maxrow=k; //isme max vale store hogi
      }
  }
  if(maxrow==i){//row ka min and column ka max store hoga
      //min in row ->max column is also true
      System.out.println(mat[maxrow][mincol]);
      return;
  }




}


//loop se bahar
//zero saddle point
System.out.println("Invalid input");







    }

}