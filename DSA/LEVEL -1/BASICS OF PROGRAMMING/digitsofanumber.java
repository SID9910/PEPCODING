import java.util.*;
    
    public class Main{
    
    public static void main(String[] args) {
     Scanner scn = new Scanner(System.in);

        int n= scn.nextInt();
        int temp=n;
        int count=0;
        while(temp!=0){
        
            temp=temp/10;                    //count karega ye loop digits kitni hai
            count=count+1;
        }
        int j=1;
        int div=1;
        while(j<=(count-1)){
            div=10*div;     //aagr 2345 hai to ye loop thousand se devide karega eek count kaam karega 
            j=j+1;
        }



 
        while(div!=0){
              int digit=n/div;         //ye loop starting se print ka hai
            n=n%div;
            System.out.println(digit);
            div=div/10;
        }



     }
    }