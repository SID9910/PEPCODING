import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int a=0;
      int b=1;
      int c;
      System.out.println(""+a);
          System.out.println(""+b);
      for(int i=0;i<n-2;i++){
          
          c=a+b;
          System.out.println(""+c);
          a=b;
          b=c;
      }
   }
  }