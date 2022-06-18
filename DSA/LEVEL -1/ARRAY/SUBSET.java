import java.io.*;
import java.util.*;

public class Main{


//ye vala function decimal to binary kar dega 
public static int decimalTobinary(int decimal){
int res=0;
int multiplier=1;
while(decimal>0){
    int quot=decimal/2;
    int rem=decimal%2;
    decimal=quot;
  res=res+rem*multiplier;
  multiplier *=10;
}
return res;

}




public static void main(String[] args) throws Exception {

Scanner scn=new Scanner(System.in);
int n=scn.nextInt();
int[]arr=new int[n];

for(int i=0;i<n;i++){
    arr[i]=scn.nextInt();  //array input

}


 int totalsubset=(int)Math.pow(2,n); //ye formula hai total subset nikalne ka

 for(int dec=0;dec<totalsubset;dec++){ //ye 2*n-1 taak chalega subset vala
 
     int binaryno=decimalTobinary(dec);  //is se hoga ye ki sare decimal- 0 to subsests 
                                       //convert jo jaenge binary main
    
 int pow= (int)Math.pow(10,n-1); //ye power function devide karne ke ley use hoga
                               //binary number ko aalag aalag karne ley isley isse last se
                               //start karenge and power kaam karte jaenge

for(int i=0;i<n;i++){
    int bit = (binaryno/pow)%10; //ye aalag karne ka ;logic hota hai binary number ko
                                //single bit main convert karne ke ley

  //logic bit agar 1 hui to uss i index per jo value hogi vo print ho jaega
  //aagr bit 0 hui to -print kar denge 
    if(bit==1){     
        System.out.print(arr[i]+"\t");
    }
    else{
        System.out.print("-\t");
    }
     pow /=10;//power kaam kar rahe hai
}

System.out.println();//new line ley


 }


 }

}