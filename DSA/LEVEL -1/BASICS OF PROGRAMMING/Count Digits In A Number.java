import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
     int count=0;
     int n=scn.nextInt();
     while(n!=0){
     
     int rem=n%10;
    
     n=n/10;
     count=count+1;
     }
     System.out.println(count);
   }
  }