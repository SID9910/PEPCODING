import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
    Scanner scn=new Scanner(System.in);
    int n=scn.nextInt();
    int m=scn.nextInt();

int [][]arr=new int[n][m];
for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
        arr[i][j]=scn.nextInt();
    }
}
int currcoln=0,currrow=0; //current column zero and current row zero

//ye previous row,column isley banaya hai kyuki exit point se pehle vala point 
//print ho jay taaki store ho jay
int prevcoln=0,prevrow=0;//previous column zero and previous row zero

//directions
//right->zero  ,down->1,left->2,top->3

//question main given hai direction right se start karenge
//so
int direction=0;

//left wall se exit //top wall se exit //bottom wall se exit//right wall se exit
        
while((currcoln>=0)&&(currrow>=0)&&(currrow<n)&&(currcoln<m)){
    if(arr[currrow][currcoln]==1){
        direction=(direction+1)%4;

    }
    prevrow=currrow;
    prevcoln=currcoln;
    if(direction==0){
       //right
        currcoln++; //current column ++ hoga aage badega
    }
    else if(direction==1){
  //bottom
  currrow++; //current row aage badagi
    }
    else if(direction==2){
        //left
        currcoln--; //cureent column gathega b

    }
    else{
        currrow--;//current  row gathega
    }
}

//current column and row print nhi karenge kyuki vo exit point jha hoga vo aage ka point hoga 
System.out.println(prevrow);//ye exit point se pehle ki row print karega
System.out.println(prevcoln);//ye exit point se pehle ki column print karega 




    }

}