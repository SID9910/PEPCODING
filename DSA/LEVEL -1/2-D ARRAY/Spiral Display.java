import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();

     int [][]arr=new int[n][m];
     for(int i=0;i<n;i++){
         for(int j=0 ;j<m;j++){
             arr[i][j]=scn.nextInt();
             
         }
     }    
//ye hamne four pointers ley hai
int frow=0,fcolumn=0;//ye haam start se karenge
int lrow=n-1,lcolumn=m-1;//ye haam last se karenge
int count=0;//eek count variable lenge jis se ham taab terminate karenge jaab
           //no of rows x no of coumn ho jay
while(count<m*n){ //imp condidion ki sare elements count ho jay

//left wall from top to bottom
//rows traverse hogi
for(int i=frow ;i<=lrow ;i++){ //first row se karenge and last row taak jaenge
  System.out.println(arr[i][fcolumn]);//khai row change hogi and column fix rahega
  count++;//count karlo kitne elements hue traverse 
  if(count==m*n){//jaise he count barabar hua no of rows xno of column terminate kardo
      return; //sidha return no break
  }

}
fcolumn++;  // fcolumn =0 se fcolumn=1//ye is ley kara kyuki fcolumn pura hogya hai 
             //to alge column se aage badenge


//bottom wall from left to right
//column traverse
for(int j=fcolumn;j<=lcolumn;j++){ //fcolumn se lcolumn traverse karenge
    System.out.println(arr[lrow][j]);//idher lrow same rahegi anf column traverse hoga
    count++;//count karlo kitne elements hue traverse 
  if(count==m*n){//jaise he count barabar hua no of rows xno of column terminate kardo
      return; //sidha return no break
  }

}
lrow--;// lrow =n-1 se lrow=n-2 hogi ye is ley kara kyuki lrow eek aab uper se start karenge

//right wall from bottom to top
for(int i=lrow ;i>=frow;i--){ //last row se first low ki taraf jaenge 
    System.out.println(arr[i][lcolumn]);//rows traverse karenge
    count++;//count karlo kitne elements hue traverse 
  if(count==m*n){//jaise he count barabar hua no of rows xno of column terminate kardo
      return; //sidha return no break
  }

}
lcolumn--;//lcolumn ko eek se htaenge taki eek piche se start ho aab

//top wall from right to left
//coumn traversal
for(int j=lcolumn;j>=fcolumn;j--){ //lcoumn se first column ki taraf jaenge
    System.out.println(arr[frow][j]); //column traverse karenge
    
    count++;//count karlo kitne elements hue traverse 
  if(count==m*n){//jaise he count barabar hua no of rows xno of column terminate kardo
      return; //sidha return no break
  }

}
frow++;//first row ko eek se isley badaenge taaki ander traverse
      // kare jaab outer ho jay traverse





}


    }

}